package com.yangxq.monitor.connector.netty.udp;

import com.yangxq.monitor.common.config.CommonConfig;
import com.yangxq.monitor.common.utils.Global;
import com.yangxq.monitor.common.utils.StatisticMap;
import com.yangxq.monitor.common.utils.StringUtil;
import com.yangxq.monitor.connector.msg.MsgDistributor;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by Yangxq on 2016/8/26.
 */
@Component
@Scope("prototype")
public class UDPHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    private Logger log = Logger.getLogger(UDPHandler.class);

    @Resource
    private CommonConfig commonConfig;

    @Resource
    private MsgDistributor msgDistributor;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        String content = msg.content().toString(Charset.forName("utf-8"));
        StatisticMap.getInstance().incrementTransferNum();
        log.info(content);
        //判断消息格式
        if (StringUtil.isEmpty(msg)) {
            log.error("消息[" + msg + "]为空");
            return;
        }
        String[] strings = content.split(Global.SEPARATED);
        if (strings.length < 4) {
            log.error("消息[" + strings.toString() + "]格式不正确");
            return;
        }
        // 判断消息类型
        InetSocketAddress recipient = msg.recipient();
        int port = recipient.getPort();
        byte businessType = 0;
        if (port == commonConfig.getUdpDelay()) {
            businessType = Global.BusinessType.DELAY.value;
        } else if (port == commonConfig.getUdpTransfer()) {
            businessType = Global.BusinessType.TRANSFER.value;
        } else {
            log.error("消息[" + content + "]类型错误，不予处理");
        }

        // 消息转发
        msgDistributor.handle(content,businessType);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
        log.error(cause);
        // super.exceptionCaught(ctx, cause);
    }
}

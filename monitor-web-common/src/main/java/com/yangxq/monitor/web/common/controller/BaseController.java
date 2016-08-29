package com.yangxq.monitor.web.common.controller;


import com.yangxq.monitor.web.common.model.ApiParams;
import com.yangxq.monitor.web.common.utils.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器基类
 */

@ControllerAdvice
public class BaseController {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());


    /**
     * 获取api参数
     *
     * @param request
     * @return
     */
    public ApiParams getApiParams(HttpServletRequest request) {
        return RequestUtil.getParams(request);
    }

    /**
     * 获取userId
     *
     * @param request
     * @return
     */
    public int getUserId(HttpServletRequest request) {
        return RequestUtil.getUserId(request);
    }



//    /**
//     * 获取房间主播相关信息
//     *
//     * @param userId
//     * @param hostId
//     * @return
//     */
//    public RoomHostModel getRoomHostModel(int userId, int hostId) {
//        RoomHostModel roomHostModel = new RoomHostModel();
//
//        long fansNum = followProvider.followerCount(hostId);
//        roomHostModel.setFansNum(fansNum);
//        log.info("用户userId:[" + hostId + "] ，粉丝数有[" + fansNum + "]个");
//
//        long followNum = followProvider.followingCount(hostId);
//        roomHostModel.setFollowNum(followNum);
//        log.info("用户userId:[" + hostId + "] ，关注数有[" + followNum + "]个");
//
//        List<PrivilegeModel> privilege = expertWhiteListProvider.getPrivilege(hostId);
//        roomHostModel.setPrivilegeList(privilege);
//        log.info("用户userId:[" + hostId + "] ，达人身份标示有[" + JsonAdapter.object2string(privilege) + "]");
//
//        int follow = followProvider.follow(userId, hostId);
//        roomHostModel.setFollowStatus(follow);
//        log.info("用户userId:[" + userId + "]关注followedId:[" + hostId + "]，关注结果是[" + follow + "]");
//
//        UserModel userModel = userRpc.getUserByID(hostId);
//        if (userModel != null) {
//            roomHostModel.setAvatar(userModel.getAvatar());
//            roomHostModel.setUserId(userModel.getUserId());
//            roomHostModel.setNickName(userModel.getNickName());
//        }
//        return roomHostModel;
//    }

}

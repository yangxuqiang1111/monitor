package com.yangxq.monitor.test;

import java.io.*;
import java.net.URISyntaxException;

/**
 * Created by Yangxq on 2016/10/31.
 * flush 的测试
 */
public class Example7 {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;

        String str = "即使是拼音文字，文字最终关联的也不是语音流，而是其对应的语义，" +
                "语义要根本的多。汉语认知得到的研究结论是：高频字中在人脑中通达的顺序的是形，义，音；" +
                "低频字中音义几乎同时出现；低年级小学生中存在着形，音，义的顺序，在词语中，“词义”先于“词音”通达；" +
                "音的触发是不自觉的。通过以上我们可以得出，语音的作用在生理上是根深蒂固的，这也是口语先于文字出现和发达的物质基础的表征，" +
                "第二，文字表达语义是可以不经过语音这一关的，也就是否认了“语音中介”的必要性。[7] " +
                " 由上，“文字记录语义”才是恰当的命题，也更应该作为文字发展的方向和要求。观点A中的汉字记录事件，" +
                "这是机械的，实际上文字刻画的，是主观世界对客观世界的反映，也就是所谓的语义。";
        try {
            fileOutputStream = new FileOutputStream(new File(Example7.class.getClassLoader().getResource("test.txt").toURI()), true);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte[] bytes = new byte[1024 ];
            bufferedOutputStream.write(bytes);
//            bufferedOutputStream.flush();
//            bufferedOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

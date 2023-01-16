package com.springboot.live_comm.tencentcloud.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MakeVideoUtil {
    public static Logger logger = LoggerFactory.getLogger(MakeVideoUtil.class);

//    public static void base64ToVideo(String base64, String videoFilePath) {
//        try {
//            //base解密
//            byte[] videoByte = new sun.misc.BASE64Decoder().decodeBuffer(base64);
//            File videoFile = new File(videoFilePath);
//            //输入视频文件
//            FileOutputStream fos = new FileOutputStream(videoFile);
//            fos.write(videoByte, 0, videoByte.length);
//            fos.flush();
//            fos.close();
//        } catch (IOException e) {
//            logger.error("IOException during base64ToVideo: ", e);
//        }
//
//    }

    public static InputStream stringToInputStream(String base64) {
        if (StringUtils.isBlank(base64))
            return null;
        //base解密
        byte[] videoByte = new byte[0];
        try {
            videoByte = new sun.misc.BASE64Decoder().decodeBuffer(base64);
        } catch (IOException e) {
            logger.error("IOException during stringToInputStream");
        }
        return new ByteArrayInputStream(videoByte);


    }
}

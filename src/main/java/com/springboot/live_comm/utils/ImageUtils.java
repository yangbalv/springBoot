package com.springboot.live_comm.utils;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ImageUtils {
    public static final int COMPRESS_WIDTH = 200;
    public static final int COMPRESS_HEIGHT = 300;
    public static final String DEFAULT_FORMAT_NAME = "png";

    @Test
    public static void testCompress1() throws IOException {
        ImageUtils imageUtils = new ImageUtils();
        File file = new File("D:\\test\\a.png");
        InputStream inputStream = new FileInputStream(file);
        OutputStream fileOutputStream = new FileOutputStream("D:\\test\\a2.png");
        imageUtils.compressFromInputStreamToOutputStream(inputStream, null, fileOutputStream);
    }

    @Test
    public static void testCompress2() throws IOException {
        ImageUtils imageUtils = new ImageUtils();
        InputStream inputStream = new FileInputStream("D:\\test\\a.png");
        String string = imageUtils.compressFromInputStreamToString(inputStream, null);
        System.out.println(string);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(string);
        OutputStream outputStream = new FileOutputStream("D:\\test\\a3.png");
        outputStream.write(bytes);
    }

    @Test
    public static void testCompress3() throws IOException {
        ImageUtils imageUtils = new ImageUtils();
        byte[] buffer = null;
        //读取图片字节数组
        try (InputStream inputStream = new FileInputStream("D:\\test\\a.png");) {
            int count = 0;
            while (count == 0) {
                count = inputStream.available();
            }
            buffer = new byte[count];
            inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = base64Encoder.encode(buffer);
        encode = encode.replaceAll("\n", "").replaceAll("\r", "");
        System.out.println(encode.length());
        String string = imageUtils.compressFromStringToString(encode, null);
        System.out.println(string.length());
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes2 = decoder.decodeBuffer(string);
        OutputStream outputStream = new FileOutputStream("D:\\test\\a5.png");
        outputStream.write(bytes2);
    }


    public String compressFromStringToString(String base64str, String formatName) throws IOException {


        if (StringUtils.isBlank(formatName)) {
            formatName = DEFAULT_FORMAT_NAME;
        }


        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(base64str);
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        BufferedImage image = ImageIO.read(in);

        ByteArrayOutputStream handlerOutputStream = new ByteArrayOutputStream();
        Thumbnails.of(image).
                size(COMPRESS_WIDTH, COMPRESS_HEIGHT).
                outputFormat(formatName).toOutputStream(handlerOutputStream);


        byte[] bytes1 = handlerOutputStream.toByteArray();
        // 转BASE64编码字符串
        BASE64Encoder encoder = new BASE64Encoder();
        String base64String = encoder.encodeBuffer(bytes1).trim();
        base64String = base64String.replaceAll("\n", "").replaceAll("\r", "");
        return base64String;
    }

    public String compressFromInputStreamToString(InputStream inputStream, String formatName) throws IOException {
        if (StringUtils.isBlank(formatName)) {
            formatName = DEFAULT_FORMAT_NAME;
        }
        ByteArrayOutputStream handlerOutputStream = new ByteArrayOutputStream();
        Thumbnails.of(inputStream).
                size(COMPRESS_WIDTH, COMPRESS_HEIGHT).
                outputFormat(formatName).toOutputStream(handlerOutputStream);
        byte[] bytes = handlerOutputStream.toByteArray();
        // 转BASE64编码字符串
        BASE64Encoder encoder = new BASE64Encoder();
        String base64String = encoder.encodeBuffer(bytes).trim();
        base64String = base64String.replaceAll("\n", "").replaceAll("\r", "");
        return base64String;
    }

    public void compressFromInputStreamToOutputStream(InputStream inputStream, String formatName, OutputStream outputStream) throws IOException {
        if (StringUtils.isBlank(formatName)) {
            formatName = DEFAULT_FORMAT_NAME;
        }
        Thumbnails.of(inputStream).
                size(COMPRESS_WIDTH, COMPRESS_HEIGHT).
                outputFormat(formatName).toOutputStream(outputStream);
    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ImageUtils imageUtils = new ImageUtils();
        imageUtils.test1();
        imageUtils.test2();
        imageUtils.test3();
        imageUtils.test4();
        imageUtils.test5();
        imageUtils.test6();
        imageUtils.test7();
        imageUtils.test8();
        imageUtils.test9();
    }

    /**
     * 指定大小进行缩放
     *
     * @throws IOException
     */
    private void test1() throws IOException {
        /*
         * size(width,height) 若图片横比200小，高比300小，不变
         * 若图片横比200小，高比300大，高缩小到300，图片比例不变 若图片横比200大，高比300小，横缩小到200，图片比例不变
         * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
         */
        Thumbnails.of("D://样本//岛上的女孩.jpg").size(200, 300).toFile(
                "D://样本//岛上的女孩1.jpg");
        Thumbnails.of("D://样本//岛上的女孩.jpg").size(2560, 2048).toFile(
                "D://样本//岛上的女孩2.jpg");
    }

    /**
     * 按照比例进行缩放
     *
     * @throws IOException
     */
    private void test2() throws IOException {
        /**
         * scale(比例)
         */
        Thumbnails.of("D://样本//岛上的女孩.jpg").scale(0.25f)
                .toFile("D://样本//岛上的女孩3.jpg");
        Thumbnails.of("D://样本//岛上的女孩.jpg").scale(1.10f).toFile(
                "D://样本//岛上的女孩4.jpg");
    }

    /**
     * 不按照比例，指定大小进行缩放
     *
     * @throws IOException
     */
    private void test3() throws IOException {
        /**
         * keepAspectRatio(false) 默认是按照比例缩放的
         */
        Thumbnails.of("D://样本//岛上的女孩.jpg").size(120, 120).keepAspectRatio(false)
                .toFile("D://样本//岛上的女孩5.jpg");
    }

    /**
     * 旋转
     *
     * @throws IOException
     */
    private void test4() throws IOException {
        /**
         * rotate(角度),正数：顺时针 负数：逆时针
         */
        Thumbnails.of("D://样本//岛上的女孩.jpg").size(1280, 1024).rotate(90).toFile(
                "D://样本//岛上的女孩6.jpg");
        Thumbnails.of("D://样本//岛上的女孩.jpg").size(1280, 1024).rotate(-90).toFile(
                "D://样本//岛上的女孩7.jpg");
    }

    /**
     * 水印
     *
     * @throws IOException
     */
    private void test5() throws IOException {
        /**
         * watermark(位置，水印图，透明度)
         */
        Thumbnails.of("D://样本//岛上的女孩.jpg").size(1280, 1024).watermark(
                Positions.BOTTOM_RIGHT,
                ImageIO.read(new File("D://样本//岛上的女孩.jpg")), 0.5f)
                .outputQuality(0.8f).toFile(
                "D://样本//岛上的女孩8.jpg");
        Thumbnails.of("D://样本//岛上的女孩.jpg").size(1280, 1024).watermark(
                Positions.CENTER,
                ImageIO.read(new File("D://样本//岛上的女孩.jpg")), 0.5f)
                .outputQuality(0.8f).toFile("D://样本//岛上的女孩9.jpg");
    }

    /**
     * 裁剪
     *
     * @throws IOException
     */
    private void test6() throws IOException {
        /**
         * 图片中心400*400的区域
         */
        Thumbnails.of("D://样本//岛上的女孩.jpg").sourceRegion(Positions.CENTER, 400,
                400).size(200, 200).keepAspectRatio(false).toFile(
                "D://样本//岛上的女孩10.jpg");
        /**
         * 图片右下400*400的区域
         */
        Thumbnails.of("D://样本//岛上的女孩.jpg").sourceRegion(Positions.BOTTOM_RIGHT,
                400, 400).size(200, 200).keepAspectRatio(false).toFile(
                "D://样本//岛上的女孩11.jpg");
        /**
         * 指定坐标
         */
        Thumbnails.of("D://样本//岛上的女孩.jpg").sourceRegion(600, 500, 400, 400).size(
                200, 200).keepAspectRatio(false).toFile(
                "D://样本//岛上的女孩12.jpg");
    }

    /**
     * 转化图像格式
     *
     * @throws IOException
     */
    private void test7() throws IOException {
        /**
         * outputFormat(图像格式)
         */
        Thumbnails.of("D://样本//岛上的女孩.jpg").size(1280, 1024).outputFormat("png")
                .toFile("D://样本//岛上的女孩13.jpg");
        Thumbnails.of("D://样本//岛上的女孩.jpg").size(1280, 1024).outputFormat("gif")
                .toFile("D://样本//岛上的女孩.jpg14");
    }

    /**
     * 输出到OutputStream
     *
     * @throws IOException
     */
    private void test8() throws IOException {
        /**
         * toOutputStream(流对象)
         */
        OutputStream os = new FileOutputStream(
                "D://样本//岛上的女孩.jpg");
        Thumbnails.of("D://样本//岛上的女孩15.jpg").size(1280, 1024).toOutputStream(os);
    }

    /**
     * 输出到BufferedImage
     *
     * @throws IOException
     */
    private void test9() throws IOException {
        /**
         * asBufferedImage() 返回BufferedImage
         */
        BufferedImage thumbnail = Thumbnails.of("D://样本//岛上的女孩.jpg").size(1280,
                1024).asBufferedImage();
        ImageIO.write(thumbnail, "jpg", new File(
                "D://样本//岛上的女孩16.jpg"));
    }
}
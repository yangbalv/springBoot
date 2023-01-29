package com.springboot.live_comm.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtils {

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
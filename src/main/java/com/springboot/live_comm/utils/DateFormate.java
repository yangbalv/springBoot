package com.springboot.live_comm.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateFormate {


    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    /**
     * 二维码生成，返回base64编码后的字符串
     *
     * @param url 链接
     * @return
     * @throws IOException
     */
    public String makeQrcode(String url) throws IOException {
        return makeQrcode(url, 420, 420);
    }

    public String makeQrcode(String url, int width, int height) throws IOException {
        return makeQrcode(url, width, height, "UTF-8");
    }

    public String makeQrcode(String url, int width, int height, String charset) throws IOException {
        return makeQrcode(url, width, height, charset, null);
    }

    public String makeQrcode(String url, int width, int height, String charset, File logoFile) throws IOException {
        return makeQrcode(url, width, height, charset, logoFile, "png");
    }

    public String makeQrcode(String url, int width, int height, String charset, File logoFile, String formatName) throws IOException {
        String res;
        ByteArrayOutputStream bops;
        BufferedImage qrcodeImg = createQrcode(url, charset, width, height, logoFile);
        bops = new ByteArrayOutputStream();
        ImageIO.write(qrcodeImg, formatName, bops);
        byte[] buffer = bops.toByteArray();
        String baseImg = Base64.encodeToString(buffer, Base64.DEFAULT);
        res = baseImg.replaceAll("[\\n\\t\\r]", "");
        return res;
    }

    /**
     * 二维码（图片输出）
     *
     * @param url        连接
     * @param outputPath 输出路径
     * @throws IOException
     */
    public void outputQrcode(String url, String outputPath) throws IOException {
        outputQrcode(url, outputPath, 420, 420);
    }

    public void outputQrcode(String url, String outputPath, int width, int height) throws IOException {
        outputQrcode(url, outputPath, width, height, "UTF-8");
    }

    public void outputQrcode(String url, String outputPath, int width, int height, String charset) throws IOException {
        outputQrcode(url, outputPath, width, height, charset, null);
    }

    public void outputQrcode(String url, String outputPath, int width, int height, String charset, File logoFile) throws IOException {
        outputQrcode(url, outputPath, width, height, charset, logoFile, "png");
    }

    public void outputQrcode(String url, String outputPath, int width, int height, String charset, File logoFile, String formatName) throws IOException {
        BufferedImage qrcodeImg = createQrcode(url, charset, width, height, logoFile);
        File file = new File(outputPath);
        ImageIO.write(qrcodeImg, formatName, file);
    }

    /**
     * 不传hint
     *
     * @param data
     * @param charset
     * @param width
     * @param height
     * @return
     */
    public static BufferedImage createQrcode(String data, String charset, int width, int height, File logoFile) {
        Map<EncodeHintType, Object> hint = new HashMap<EncodeHintType, Object>();
        hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        hint.put(EncodeHintType.CHARACTER_SET, charset);
        hint.put(EncodeHintType.MARGIN, 0);
        return createQrcodeWithLogo(data, charset, hint, width, height, logoFile);
    }

    /**
     * logo
     *
     * @param data
     * @param charset
     * @param hint
     * @param width
     * @param height
     * @param logoFile
     * @return
     */
    public static BufferedImage createQrcodeWithLogo(String data, String charset, Map<EncodeHintType, ?> hint, int width, int height, File logoFile) {
        try {
            BufferedImage qrcode = createQrcode(data, charset, hint, width, height);
            //logoFile 为空则返回不加logo的二维码
            if (logoFile == null) return qrcode;

            BufferedImage logo = ImageIO.read(logoFile);
            int deltaHeight = height - logo.getHeight();
            int deltaWidth = width - logo.getWidth();

            BufferedImage combined = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = (Graphics2D) combined.getGraphics();
            g.drawImage(qrcode, 0, 0, null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            g.drawImage(logo, (int) Math.round(deltaWidth / 2), (int) Math.round(deltaHeight / 2), null);

            return combined;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 所有参数
     *
     * @param data
     * @param charset
     * @param hint
     * @param width
     * @param height
     * @return BufferedImage
     */
    public static BufferedImage createQrcode(String data, String charset, Map<EncodeHintType, ?> hint, int width, int height) {
        BitMatrix matrix;
        try {
            matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, width, height, hint);
            return toBufferedImage(matrix);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * BitMatrix 位阵转图片
     *
     * @param matrix
     * @return BufferedImage
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }
}

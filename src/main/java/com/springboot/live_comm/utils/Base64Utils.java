package com.springboot.live_comm.utils;


import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.Base64;

public class Base64Utils {
    private static final Base64.Decoder decoder = Base64.getDecoder();
    private static final Base64.Encoder encoder = Base64.getEncoder();

    public static String base64Encode(String text) throws UnsupportedEncodingException {
        try {
            byte[] textByte = text.getBytes("UTF-8");
            String encodedText = encoder.encodeToString(textByte);
            return encodedText;
        } catch (UnsupportedEncodingException e) {
            throw e;
        }
    }

    public static String base64Decode(String encodedText) throws UnsupportedEncodingException {
        try {
            String text = new String(decoder.decode(encodedText), "UTF-8");
            return text;
        } catch (UnsupportedEncodingException e) {
            throw e;
        }
    }

    /**
     * 将inputstream转为Base64
     *
     * @param is
     * @return
     * @throws Exception
     */
    public static String inputStream2Base64(InputStream is) throws IOException {
        byte[] data = null;
        try {
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = is.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            data = swapStream.toByteArray();
        } catch (IOException e) {
            throw e;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw e;
                }
            }
        }

        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * base64转inputStream
     *
     * @param base64string
     * @return
     */
    public static InputStream base2InputStream(String base64string) throws IOException {
        ByteArrayInputStream stream = null;

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes1 = decoder.decodeBuffer(base64string);
        stream = new ByteArrayInputStream(bytes1);

        return stream;
    }

}


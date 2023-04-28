package com.springboot.live_comm.utils.http;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.util.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class HttpUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public String getHTML(String path, Map<String, Object> requestArgs) throws IOException {
        String uri = makeGetUrl(requestArgs, true);
        return getHTML(path + "?" + uri);
    }

    public String getHTML(String url) throws IOException {
        logger.info("start do getPost, and the url is : {}", url);
        if (StringUtils.isEmpty(url)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            URL toUrl = new URL(url);

            HttpURLConnection httpURLConnection = (HttpURLConnection) toUrl.openConnection();
            httpURLConnection.setRequestMethod("GET");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
            }
            bufferedReader.close();

        } catch (MalformedURLException e) {
            logger.error("MalformedURLException during getPost ", e);
        } catch (IOException e) {
            logger.error("IOException during getPost ", e);
            throw e;
        }
        return stringBuffer.toString();


    }

    public String doPost(String toUrl, Map<String, Object> requestArgs) throws IOException {
        return doPost(toUrl, JSON.toJSONString(requestArgs));
    }

    /**
     * @param toUrl
     * @param message json格式的字符串
     * @return
     * @throws IOException
     */
    public String doPost(String toUrl, String message) throws IOException {
        logger.info("start do postRequest, and the url is : {}", toUrl);
        StringBuffer stringBuffer = new StringBuffer();

        URL url = new URL(toUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);

        httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        httpURLConnection.connect();
//        此步骤用于请求登录接口后获取cookie
//        String headerField = httpURLConnection.getHeaderField("set-cookie");
//        String s = headerField.split(";")[0].split("=")[1];
//        System.out.println(s);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
        bufferedWriter.write(message);
        bufferedWriter.close();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            logger.info("bed request for: {},responseCode is: {}, and the request is: {}", toUrl, responseCode, message);
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line + "\n");

        }
        logger.info(" end the postRequest of url: {}", toUrl);
        return stringBuffer.toString();


    }

    /**
     * 构造get的请求参数形式如 a=1&b=2
     *
     * @param message
     * @param removeLast 设置为false不会除去最后的&
     * @return
     */
    public static String makeGetUrl(Map<String, Object> message, boolean removeLast) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, Object> entry : message.entrySet()) {
            Object value = null;
            try {
                value = URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                value = entry.getValue();
            }
            stringBuffer.append(entry.getKey() + "=" + value + "&");
        }
        if (removeLast) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return new String(stringBuffer);
    }
}

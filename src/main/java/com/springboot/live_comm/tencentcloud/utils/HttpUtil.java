package com.springboot.live_comm.tencentcloud.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class HttpUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public String getHTML(String url) {
        logger.info("start do getPost, and the url is : {}", url);
        if (StringUtils.isBlank(url)) {
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
        }
        return stringBuffer.toString();


    }

    public String doPost(String toUrl, Map<String, String> requestArgs) throws IOException, JSONException {

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
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(JSON.toJSONString(requestArgs));
            bufferedWriter.close();


            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                logger.info("bed request for: {},responseCode is: {}, and the request is: {}", toUrl, responseCode, requestArgs.toString());
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line + "\n");

            }
            logger.info(" end the postRequest of url: {}", toUrl);
            return stringBuffer.toString();


    }

}

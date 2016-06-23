package com.yawei.util;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HttpUtil {
    public static String getText(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpGet);
            int httpCode = response.getStatusLine().getStatusCode();
            if (httpCode == 200) {
                InputStream input = response.getEntity().getContent();
                String result = IOUtils.toString(input);
                return result;
            } else {
                throw new RuntimeException("请求服务器异常:" + httpCode);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void getStream(String url,String savePath) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpGet);
            int httpCode = response.getStatusLine().getStatusCode();
            if (httpCode == 200) {
                InputStream input = response.getEntity().getContent();
                FileOutputStream output = new FileOutputStream(savePath);

                IOUtils.copy(input, output);
                output.flush();
                output.close();
                input.close();
            } else {
                throw new RuntimeException("请求服务器异常:" + httpCode);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}

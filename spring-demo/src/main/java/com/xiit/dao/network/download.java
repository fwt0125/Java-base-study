package com.xiit.dao.network;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class download {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://t7.baidu.com/it/u=1595072465,3644073269&fm=193&f=GIF");

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();

        FileOutputStream fileOutputStream = new FileOutputStream("img.jpg");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        fileOutputStream.close();
        inputStream.close();
        httpURLConnection.disconnect();
    }
}

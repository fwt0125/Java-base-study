package com.xiit.dao.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable <Boolean> {

    private String name;
    private String url;

    public TestCallable(String url, String name) {
        this.name = name;
        this.url = url;
    }


    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载文件："+name);
        return null;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://www.baidu.com/img/flexible/logo/pc/result@2.png", "1.png");
        TestCallable t2 = new TestCallable("https://www.baidu.com/img/flexible/logo/pc/result@2.png", "2.png");
        TestCallable t3 = new TestCallable("https://www.baidu.com/img/flexible/logo/pc/result@2.png", "3.png");

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Boolean> submit1 = executorService.submit(t1);
        Future<Boolean> submit2 = executorService.submit(t2);
        Future<Boolean> submit3 = executorService.submit(t3);

        Boolean aBoolean1 = submit1.get();
        Boolean aBoolean2 = submit2.get();
        Boolean aBoolean3 = submit3.get();

        System.out.println(aBoolean1);
        System.out.println(aBoolean2);
        System.out.println(aBoolean3);

        executorService.shutdown();


    }

}


class WebDownloader{
    public void downloader(String url,String name) throws IOException {
        FileUtils.copyURLToFile(new URL(url),new File(name));
    }
}
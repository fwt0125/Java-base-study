package com.xiit.dao.thread;

//测试守护纯种
public class TestDaemon {

    public static void main(String[] args) {
        God god = new God();
        You1 you = new You1();

        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start();

        new Thread(you).start();

    }

}

class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑着你");
        }
    }
}


class You1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 365; i++) {
            System.out.println("一生都在活着"+i);
        }
        System.out.println("==== goodbye! world====");
    }
}
package com.xiit.dao.thread;

public class DeadLock {
    public static void main(String[] args) {
        MakeUp g1 = new MakeUp(0, "小灰");
        MakeUp g2 = new MakeUp(1, "小白");

        g1.start();
        g2.start();
    }
}

class Lipstick{

}

class Mirror{

}

class MakeUp extends Thread{

    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    MakeUp(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if(choice == 0) {
            synchronized (lipstick){
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(1000);
                synchronized (mirror){
                    System.out.println(this.girlName+"获得镜子的锁");
                }
            }

        }else{
            synchronized (mirror){
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(2000);
                synchronized (lipstick){
                    System.out.println(this.girlName+"获得镜子的锁");
                }
            }

        }
    }
}
package com.xiit.dao.thread;

public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "苦逼的我").start();
        new Thread(buyTicket, "牛逼的你").start();
        new Thread(buyTicket, "老师").start();

    }

}

class BuyTicket implements Runnable{

    private int ticketNum = 10;
    boolean flag = true;

    @Override
    public void run() {
        //买票
        while (true){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //这里买
        }
    }

    private synchronized void buy() throws InterruptedException {
        if(ticketNum < 1) {
            flag = false;
            return;
        }
        Thread.sleep(10);
        System.out.println(Thread.currentThread().getName()+"买到了"+ticketNum--);
    }

}

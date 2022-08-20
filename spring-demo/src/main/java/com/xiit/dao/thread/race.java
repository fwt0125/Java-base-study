package com.xiit.dao.thread;

public class race implements Runnable {

    private static String winner;

    public void run(){
        for (int i = 0; i <= 100; i++) {

            if(Thread.currentThread().getName().equals("兔子")){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            boolean game = gameOver(i);
            if (game) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "---> 跑了" + i +" 步");
        }
    }

    private boolean gameOver(int steps){
        if(winner != null) {
            return true;
        }else{
            if (steps >= 100 ) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is :" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        race race = new race();

        new Thread(race,"兔子").start();
        new Thread(race, "乌龟").start();
    }
}

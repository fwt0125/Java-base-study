package com.xiit.dao.thread;

public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("循环中");
            }
        });

        Thread.State state = thread.getState();
        System.out.println(state);

        thread.start();
        System.out.println(thread.getState());

        while (state != Thread.State.TERMINATED){
            Thread.sleep(300);
            state = thread.getState();
            System.out.println(state);
        }


    }
}

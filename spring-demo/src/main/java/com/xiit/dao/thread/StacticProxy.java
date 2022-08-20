package com.xiit.dao.thread;

public class StacticProxy {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("我爱你")).start();

       new WeddingCompany(new You()).HappyMarry();

    }
}

interface Marry{
    void HappyMarry();

}

class  You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("自己要结婚了");
    }
}

class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target){
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("结婚之前要布置");
    }

    private void after() {
        System.out.println("结婚之后收尾款");
    }


}

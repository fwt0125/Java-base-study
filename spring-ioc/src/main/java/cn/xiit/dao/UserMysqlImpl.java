package cn.xiit.dao;

public class UserMysqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("从Mysql获取用户信息");
    }
}

package cn.xiit.service;

import cn.xiit.dao.UserDao;
import cn.xiit.dao.UserDaoImpl;
import cn.xiit.dao.UserMysqlImpl;

public class UserServiceImpl implements UserService{

    private UserDao userDao = new UserMysqlImpl();

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}

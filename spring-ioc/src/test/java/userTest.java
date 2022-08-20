import cn.xiit.dao.UserDaoImpl;
import cn.xiit.service.UserServiceImpl;

public class userTest {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.setUserDao(new UserDaoImpl());
        userService.getUser();
    }
}

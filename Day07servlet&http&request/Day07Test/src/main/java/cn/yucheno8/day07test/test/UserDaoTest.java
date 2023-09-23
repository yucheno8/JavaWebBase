package cn.yucheno8.day07test.test;


import cn.yucheno8.day07test.dao.UserDao;
import cn.yucheno8.day07test.domain.User;
import org.junit.Test;


public class UserDaoTest {



    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("superbaby");
        loginuser.setPassword("123");


        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }
}

package com.sumuwen.boot;

import com.sumuwen.boot.dao.UserDao;
import com.sumuwen.boot.pojo.Detail;
import com.sumuwen.boot.pojo.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class WorkTestOfPayApplicationTests {
    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("登记消费明细测试")
    public void testRegisterDetial(){
        Detail detail = new Detail(null,1,0.0,
                0.0,0.0,new Date(System.currentTimeMillis()));
        Integer result = userDao.registration(detail);
        if(result > 0){
            System.out.println("登记成功！");
            System.out.println("明细订单did为: " + detail.getDid());
        }else {
            System.out.println("登记失败！");
        }
    }

    @Test
    @DisplayName("更新用户余额测试")
    public void testUpdateBalance(){
        User user = new User(1,null,300.0);
        Integer result = userDao.updateBalance(user);
        if(result > 0){
            System.out.println("登记成功！");
        }else {
            System.out.println("登记失败！");
        }
    }
}

package com.sumuwen.boot.service.impl;

import com.sumuwen.boot.dao.UserDao;
import com.sumuwen.boot.pojo.Detail;
import com.sumuwen.boot.pojo.User;
import com.sumuwen.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public Integer consume(Integer uid,Double expenditure) {
        if(expenditure > userDao.getBalance(uid)){
            return 0;
        }else{
            //记录本次付款操作
            Detail detail = new Detail();
            detail.setUid(uid);
            detail.setExpenditure(expenditure);
            this.registration(detail);
            //用户余额减去相应的消费金额
            User user = new User();
            user.setUid(uid);
            Double afterConsumeBalance = userDao.getBalance(uid) - expenditure;
            //记录新的用户余额
            user.setBalance(afterConsumeBalance);
            userDao.updateBalance(user);
            return 1;
        }
    }

    @Override
    @Transactional
    public Integer refund(Integer uid, Double refundAmount) {
        //记录本次退款操作
        Detail detail = new Detail();
        detail.setUid(uid);
        detail.setRefund(refundAmount);
        this.registration(detail);
        //用户余额加上相应的退款金额
        User user = new User();
        user.setUid(uid);
        Double afterConsumeBalance = userDao.getBalance(uid) + refundAmount;
        //记录新的用户余额
        user.setBalance(afterConsumeBalance);
        userDao.updateBalance(user);
        return 1;
    }

    @Override
    public void registration(Detail detail) {
        Date dateOfNow = new Date(System.currentTimeMillis());
        detail.setDate(dateOfNow);
        userDao.registration(detail);
    }

    @Override
    public Double getBalance(Integer uid) {
        return userDao.getBalance(uid);
    }
}

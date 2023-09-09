package com.sumuwen.boot.service;

import com.sumuwen.boot.pojo.Detail;
import com.sumuwen.boot.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    public Double getBalance(Integer uid);
    public Integer consume(Integer uid,Double expenditure);
    public Integer refund(Integer uid,Double refundAmount);
    public void registration(Detail detail);
}

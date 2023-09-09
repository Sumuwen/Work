package com.sumuwen.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Slf4j
public class Detail {
    private Integer did;
    private Integer uid;
    private Double income;
    private Double expenditure;
    private Double refund;
    private Date date;
}

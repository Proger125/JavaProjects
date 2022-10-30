package edu.bsu.kr.kr_26_05.entity;

import lombok.Data;

@Data
public class Payment {

    private Long id;

    private PaymentType type;

    private String payer;

    private double sum;
}

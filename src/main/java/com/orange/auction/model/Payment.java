package com.orange.auction.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "PAYMENT")
@Data
public class Payment {
    private enum PaymentType{
        CREDIT, WITHDRAWAL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "FROM_MEMBER_ID")
    private Member fromMember;
    @Column(name = "TO_COMMITTEE_ID")
    private Committee toCommitte;
    @Column(name = "PAYMENT_TYPE")
    private PaymentType paymentType;
    @Column(name = "AMOUNT")
    private long amount;

    public Payment() {
    }
}

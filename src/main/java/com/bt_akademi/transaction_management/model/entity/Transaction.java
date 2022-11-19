package com.bt_akademi.transaction_management.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@SequenceGenerator(name = "TRANSACTIONS_SEQUENCE", sequenceName = "BT_AKADEMI_TRANSACTIONS_SEQ", initialValue = 1, allocationSize = 1)
@Table(name = "TRANSACTIONS")
@Data
@Entity
public class Transaction
{
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTIONS_SEQUENCE")
    @Column(name = "TRANSACTION_ID", nullable = false)
    @Id
    private Integer transactionID;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Integer productID;

    @Column(name = "USER_ID", nullable = false)
    private Integer userID;

    @Column(name = "TRANSACTION_TIME")
    private Date transactionTime;
}

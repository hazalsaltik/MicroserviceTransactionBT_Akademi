package com.bt_akademi.transaction_management.model.service;

import com.bt_akademi.transaction_management.model.entity.Transaction;
import com.bt_akademi.transaction_management.model.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractTransactionService implements EntityService<Transaction, Integer>
{
    @Autowired
    protected TransactionRepository transactionRepository;

    public abstract List<Transaction> findAllByUserID(Integer userID);
}

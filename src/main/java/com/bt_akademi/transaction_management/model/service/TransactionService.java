package com.bt_akademi.transaction_management.model.service;

import com.bt_akademi.transaction_management.model.entity.Transaction;
import com.bt_akademi.transaction_management.utility.ExceptionMessageType;
import com.bt_akademi.transaction_management.utility.Util;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService extends AbstractTransactionService
{

    @Override
    public List<Transaction> findAllByUserID(Integer userID)
    {
        return transactionRepository.findAllByUserID(userID);
    }

    @Override
    public List<Transaction> getAll()
    {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findByID(Integer transactionID)
    {
        return transactionRepository.findById(transactionID)
                .orElseThrow(() -> new RuntimeException(ExceptionMessageType.FIND_BY_ID.getValue()));
    }

    @Override
    public Transaction save(Transaction entity)
    {
        try
        {
            return transactionRepository.save(entity);
        }
        catch (IllegalArgumentException  e)
        {
            Util.showGeneralExceptionInfo(e);
            return new Transaction();
        }
        catch (OptimisticEntityLockException e)
        {
            Util.showGeneralExceptionInfo(e);
            return new Transaction();
        }
    }

    @Override
    public void deleteById(Integer transactionID)
    {
        try
        {
            transactionRepository.deleteById(transactionID);
        }
        catch (IllegalArgumentException  e)
        {
            Util.showGeneralExceptionInfo(e);
        }
        catch (OptimisticEntityLockException e)
        {
            Util.showGeneralExceptionInfo(e);
        }
    }
}

package com.bt_akademi.transaction_management.model.service;

import com.bt_akademi.transaction_management.model.entity.Transaction;
import com.bt_akademi.transaction_management.utility.ExceptionMessageType;
import com.bt_akademi.transaction_management.utility.Util;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionService extends AbstractTransactionService
{

    @Override
    protected List<Transaction> findAllByUserId(Integer userId) {
        return transactionRepository.findAllByUserID(userId);
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findByID(Integer UserID) {
        return transactionRepository.findById(UserID)
                .orElseThrow(() -> new RuntimeException(ExceptionMessageType.FIND_BY_ID.getValue()));
    }

    @Override
    public Transaction save(Transaction entity) {
        try
        {
            return transactionRepository.save(entity);
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
        catch (OptimisticLockingFailureException e)
        {
            Util.showGeneralExceptionInfo(e);
            return null;
        }
    }

    @Override
    public void delete(Integer UserID)
    {

        try
        {
            transactionRepository.deleteById(UserID);
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionInfo(e);
        }

    }
}

package com.bt_akademi.transaction_management.controller;

import com.bt_akademi.transaction_management.model.entity.Transaction;
import com.bt_akademi.transaction_management.model.service.AbstractTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("api/transaction")
@RestController
public class TransactionController
{
    @Autowired
    private AbstractTransactionService transactionService;

    @GetMapping("{userID}")
    public ResponseEntity<List<Transaction>> getTransactionsOfUser(@PathVariable Integer userID)
    {
        List<Transaction> transactionList = transactionService.findAllByUserID(userID);

        return ResponseEntity.ok(transactionList);
    }

    @PostMapping
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction)
    {
        transaction.setTransactionTime(new Date());
        Transaction savedTransaction = transactionService.save(transaction);

        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{transactionID}")
    public ResponseEntity deleteTransactionByID(@PathVariable Integer transactionID)
    {
        transactionService.deleteById(transactionID);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions()
    {
        List<Transaction> transactionList = transactionService.getAll();

        return ResponseEntity.ok(transactionList);
    }
}

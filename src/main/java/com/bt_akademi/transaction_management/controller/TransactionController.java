package com.bt_akademi.transaction_management.controller;

import com.bt_akademi.transaction_management.model.entity.Transaction;
import com.bt_akademi.transaction_management.model.service.AbstractTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping ("api/transaction")
@RestController

public class TransactionController {

    @Autowired
    private AbstractTransactionService transactionService;

    @DeleteMapping()
    public RequestBody delete (@PathVariable Integer userID)
    {

        return null;
    }


    @PostMapping
    public  ResponseEntity<Transaction> save (@RequestBody Transaction transaction)
    {
        transaction.setTransactionTime(new Date());
        Transaction savedTransaction = transactionService.save(transaction);

        return  new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

             @GetMapping
             public ResponseEntity<List<Transaction>> getAll()

             {
                 List <Transaction> transactionList = transactionService.getAll();

                 return  ResponseEntity.ok(transactionList);
   }



}

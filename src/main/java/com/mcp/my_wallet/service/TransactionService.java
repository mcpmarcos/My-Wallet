package com.mcp.my_wallet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mcp.my_wallet.DTO.TransactionDTO;
import com.mcp.my_wallet.model.Account;
import com.mcp.my_wallet.model.CreditCard;
import com.mcp.my_wallet.model.Transaction;
import com.mcp.my_wallet.repository.CreditCardRepository;
import com.mcp.my_wallet.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CreditCardService creditCardService;

    public ResponseEntity<Transaction> paymentTransaction(TransactionDTO transactionDTO, String cardNumber) {

        Transaction transaction = new Transaction(transactionDTO.id(), transactionDTO.amount(), transactionDTO.buyingLocation(), transactionDTO.operatorName());
      
        CreditCard card = creditCardService.findByCardNumber(cardNumber);
       
        Account account = card.getAccount();

        //lógica da transação

        return null;
    }

	public List<TransactionDTO> findAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return createDTO(transactions);
	}


     public List<TransactionDTO> createDTO(List<Transaction> transactions){
        List<TransactionDTO> transactionDTOs = new ArrayList<>();
        for (Transaction transaction: transactions) {        
            TransactionDTO transactionDTO = new TransactionDTO(transaction.getId(), transaction.getAmount(), transaction.getBuyingLocation(), transaction.getOperatorName());
            transactionDTOs.add(transactionDTO);
        }
        return transactionDTOs;
    }    
}

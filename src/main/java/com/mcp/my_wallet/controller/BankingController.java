package com.mcp.my_wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.my_wallet.DTO.AccountDTO;
import com.mcp.my_wallet.DTO.ClientDTO;
import com.mcp.my_wallet.model.Client;
import com.mcp.my_wallet.service.AccountService;
import com.mcp.my_wallet.service.ClientService;
import com.mcp.my_wallet.service.CreditCardService;
import com.mcp.my_wallet.service.DependentService;

@RestController
public class BankingController {
    
    @Autowired
    ClientService clientService;

    @Autowired
    AccountService accountService;
    
    @Autowired
    CreditCardService creditCardService;
    
    @Autowired
    DependentService dependentService;
    
    // register client
    @PostMapping("/client")
    public ResponseEntity<Client>registerNewclient(@RequestBody ClientDTO clientDTO) {
        return clientService.createClient(clientDTO);
    }

    // update account credit limit 
    @PutMapping("/account/{clientId}")
    public ResponseEntity<String> updateAccountBalance(@RequestBody AccountDTO updateAccount, @PathVariable Long clientId) {

        return accountService.updateAccountBalance(updateAccount, clientId);
    }

    //==========================================
    
    // paymentTransaction   >>  update balance

    // save transaction in account

    // criar lógica para a transação parcelada
    /*
     *  se qtd parcelas > 1
     *      salvar em transações parceladas
     *  
    */

    // Generate invoice(criar atributo para status da invoice, pode ser enum ou boolean)

    // quit invoice(apenas um botão que dispara requisição pra alterar o status da invoice para PAGO/PAYD) 

    // save invoice in account

    // show dashboard(tela inicial)

    // Os endpoins relacionados a Dependent ainda não estão funcionando, é necessário corrigi/ erros 

    //Criar e substituir DTO nos métodos de CRUD para o cartão de crédito, não criei pq to codando no VsCode e as vezes rolam uns bugs de importação de lib, daí eu tava com pressa e só queria fazer funcionar o básico logo kkk
}

package com.mcp.my_wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.my_wallet.DTO.AccountDTO;
import com.mcp.my_wallet.DTO.ClientDTO;
import com.mcp.my_wallet.DTO.CreditCardBrandDTO;
import com.mcp.my_wallet.DTO.DependentDTO;
import com.mcp.my_wallet.DTO.UpdatedDependendDTO;
import com.mcp.my_wallet.model.Client;
import com.mcp.my_wallet.model.CreditCard;
import com.mcp.my_wallet.model.Dependent;
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

    // update account credit limit / consumed credit 
    @PutMapping("/account/{id}")
    public ResponseEntity<String> updateAccountBalance(@RequestBody AccountDTO updateAccount, @PathVariable Long accountId) {

        return accountService.updateAccountBalance(updateAccount, accountId);
    }

    // create credit card 
    @PostMapping("/card/{clientId}")
    public ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCardBrandDTO brand, @PathVariable Long clientId){
        return creditCardService.createCreditCard(clientId, brand);
    }

    // delete credit card
    @DeleteMapping("/card/{id}")
    public void deleteCreditCard(@PathVariable Long id) {
        creditCardService.deleteCreditCard(id);
    }

    // activate credit card
    @PutMapping("/cardActivate/{id}")
    public ResponseEntity<String> activateCreditCard(@PathVariable Long id) {
        return creditCardService.activateCreditCard(id);
    }
    
    // desactivate credit card
    @PutMapping("/cardDesactivate/{id}")
    public ResponseEntity<String> desactivateCreditCard(@PathVariable Long id) {
        return creditCardService.desactivateCreditCard(id);
    }

    // find by id
    @GetMapping("/card/{id}")
    public CreditCard findCreditCardById(@PathVariable Long id){
        return creditCardService.findById(id);
    }
    
    //find by card numerber
    @GetMapping("/cardNumber/{cardNumber}")
    public CreditCard findCreditCardByCardNumber(@PathVariable String cardNumber){
        return creditCardService.findByCardNumber(cardNumber);
    }

    // find all cards
    @GetMapping("/card")
    public List<CreditCard> findAllCreditCards(){
        return creditCardService.findAll();
    }
    
    @PostMapping("/dependent/{cardNumber}")
    public ResponseEntity<DependentDTO> insertDependentOnCard(@RequestBody DependentDTO dependentDTO, @PathVariable String cardNumber){
        return dependentService.insertDependentOnCard(dependentDTO, cardNumber);       
    }

    //find dependent by id
    @GetMapping("/dependent/{dependentID}")
    public DependentDTO finddependedById(@PathVariable Long dependentId){
        return dependentService.findById(dependentId);
    }

    //find all dependents
    @GetMapping("/dependent")
    public List<DependentDTO> findAllDependents(){
        return dependentService.findAll();
    }

    // update dependent data
    @PutMapping("/dependent/{dependentID}")
    public ResponseEntity<String> updateDependentData(@RequestParam UpdatedDependendDTO dependentDTO, @PathVariable Long dependentID ){
        return dependentService.updateDependentData(dependentDTO, dependentID);
    }

    // delete dependent
    @DeleteMapping("/dependent/{dependentId}")
    public void deleteDependent(@PathVariable Long dependentId){
        dependentService.deleteDependent(dependentId);
    }



    //==========================================
    

    // create transaction entity
    
    // paymentTransaction   >>  update balance

    // save transaction in account

    // criar lógica para a transação parcelada

    // create invoice entity

    // Generate invoice(criar atributo para status da invoice, pode ser enum ou boolean)

    // quit invoice(apenas um botão que dispara requisição pra alterar o status da invoice para PAGO/PAYD) 

    // save invoice in account

    // show dashboard

    //analisar quais endpoints terão que ser alterados para receberem o número cartão como parâmetro e quais receberão o id do client

     //Criar e substituir DTO nos métodos de CRUD para o cartão de crédito, não criei pq to codando no VsCode e as vezes rolam uns bugs de importação de lib, daí eu tava com pressa e só queria fazer funcionar o básico logo kkk
}

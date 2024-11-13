package com.mcp.my_wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.my_wallet.DTO.AddressDTO;
import com.mcp.my_wallet.DTO.ClientDTO;
import com.mcp.my_wallet.model.Client;
import com.mcp.my_wallet.service.ClientService;

@RestController
public class ClientController {
    
    @Autowired
    ClientService service;
    
    @PostMapping("/client")
    public ResponseEntity<Client>createclient(@RequestBody ClientDTO clientDTO) {
        return service.createClient(clientDTO);
    }
    
   @GetMapping("/client/{id}")
   public ClientDTO findById(@PathVariable Long id){
       return service.findById(id); 
   }

    @GetMapping("/client")
    public List<ClientDTO> findAllClients() {
       return service.findAllClients();
    }


   //update client
   
   //delete clients

   /* tentativa de resolver o formato de data que o json terá


    *@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(LocalDateTime.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            }
        });
    }
   */
}

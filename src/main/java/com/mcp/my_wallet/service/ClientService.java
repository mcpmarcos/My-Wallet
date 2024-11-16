package com.mcp.my_wallet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mcp.my_wallet.DTO.ClientDTO;
import com.mcp.my_wallet.model.Client;
import com.mcp.my_wallet.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;
    
    // CreditCardService creditCardService

     public ResponseEntity<Client> createClient(ClientDTO clientDTO) {
        Client newClient = new Client(clientDTO.id(), clientDTO.cpf(), clientDTO.name(), clientDTO.password(), clientDTO.birth(), clientDTO.address(), clientDTO.account());

    
        //newClient.account.cards.add(creditCardService.createCreditCard(VISA));

        repository.save(newClient);
        return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
    }

    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).get();
        return createDTO(client);
    }
    
    public List<ClientDTO> findAllClients() {
        List<Client> clients = repository.findAll();
        return createDTO(clients);
    }
    
    public ResponseEntity<String> updateClient(ClientDTO clientDTO, Long id) {
       Client newClient = repository.findById(id).get(); 
       if (!newClient.equals(null)) {
        newClient.setCpf(clientDTO.cpf());
        newClient.setName(clientDTO.name());
        newClient.setPassword(clientDTO.password());
        newClient.setBirth(clientDTO.birth());
        newClient.setAddress(clientDTO.address());
        newClient.setAccount(clientDTO.account());
        repository.save(newClient);
    }
    return ResponseEntity.ok("Ok");
    }

    public void deleteClient(Long id) {
        Client client = repository.findById(id).get();
        repository.delete(client);
    }

    public ClientDTO createDTO(Client client){
        ClientDTO clientDTO = new ClientDTO(client.getId(), client.getCpf(), client.getName(), client.getPassword(), client.getBirth(),client.getAddress(), client.getAccount());
        return clientDTO;
    }

    public List<ClientDTO> createDTO(List<Client> clients){
        List<ClientDTO> clientDTOs = new ArrayList<>();
        for (Client client: clients) {        
            ClientDTO clientDTO = new ClientDTO(client.getId(), client.getCpf(), client.getName(), client.getPassword(), client.getBirth(), client.getAddress(), client.getAccount());
            clientDTOs.add(clientDTO);
        }
        return clientDTOs;
    }


}

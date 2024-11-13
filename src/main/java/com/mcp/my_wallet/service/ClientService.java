package com.mcp.my_wallet.service;

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
    
     public ResponseEntity<Client> createClient(ClientDTO clientDTO) {
        Client newClient = new Client(clientDTO.id(), clientDTO.cpf(), clientDTO.name(), clientDTO.password(), clientDTO.birth(), clientDTO.address());
        repository.save(newClient);
        return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
    }

    public ClientDTO findById(Long id) {
       Client client = repository.findById(id).get();
       return createDTO(client);
   }

    public ClientDTO createDTO(Client client){
        ClientDTO clientDTO = new ClientDTO(client.getId(), client.getCpf(), client.getName(), client.getPassword(), client.getBirth(),client.getAddress());
        return clientDTO;
    }
}

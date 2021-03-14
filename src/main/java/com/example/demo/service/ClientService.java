package com.example.demo.service;

import com.example.demo.domain.Client;
import com.example.demo.repo.ClientRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepo clientRepo;


    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Optional<Client> getId(Long id) {
        return clientRepo.findById(id);
    }

    public Client add(Client client) {
        return clientRepo.save(client);
    }

    public Client findById(Long id) {
        return clientRepo.findByIdAndDeletedAtIsNull(id);
    }

    public Client findByName(String name) {
        return clientRepo.findByNameAndDeletedAtIsNull(name);
    }

    public Client findByAddress(String address) {
        return clientRepo.findByAddressAndDeletedAtIsNull(address);
    }

    public Client findByPhoneNumber(int phoneNumber) {
        return clientRepo.findByPhoneNumberAndDeletedAtIsNull(phoneNumber);
    }

    public String updateAddress(Long id, String address) {
        Client client = clientRepo.findByIdAndDeletedAtIsNull(id);
        client.setAddress(address);
        clientRepo.save(client);
        return "address updated";
    }

    public String updateAll(Long id, String name, String address, int phoneNumber) {
        Client client = clientRepo.findByIdAndDeletedAtIsNull(id);
        client.setName(name);
        client.setAddress(address);
        client.setPhoneNumber(phoneNumber);
        clientRepo.save(client);
        return "updated all";
    }

    public String delete(Long id) {
        Date date =  new Date();
        Client client = clientRepo.findByIdAndDeletedAtIsNull(id);
        client.setDeletedAt(date);
        clientRepo.save(client);
        return "deleted";
    }

    public List<Client> findAll() {
        return clientRepo.findAllByDeletedAtIsNull();
    }
}

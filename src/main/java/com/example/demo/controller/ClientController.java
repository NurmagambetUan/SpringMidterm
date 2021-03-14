package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import com.example.demo.domain.Client;
import com.example.demo.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/client")
public class ClientController extends BaseController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Client client ) {
        return buildResponse(clientService.add(client), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        return buildResponse(clientService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<?> findByName(@RequestParam String name) {
        return buildResponse(clientService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/findByAddress")
    public ResponseEntity<?> findByAddress(@RequestParam String address) {
        return buildResponse(clientService.findByAddress(address),HttpStatus.OK);
    }

    @GetMapping("/findByPhoneNumber")
    public ResponseEntity<?> findByPhoneNumber(@RequestParam int phoneNumber) {
        return buildResponse(clientService.findByPhoneNumber(phoneNumber), HttpStatus.OK);
    }

    @PostMapping("/updateAddress")
    public ResponseEntity<?> updateAddress(@RequestParam Long id, String address) {
        return buildResponse(clientService.updateAddress(id, address), HttpStatus.OK);
    }

    @PostMapping("/updateAll")
    public ResponseEntity<?> updateAll(@RequestParam Long id, String name, String address, int phoneNumber) {
        return buildResponse(clientService.updateAll(id, name, address, phoneNumber), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        return buildResponse(clientService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return buildResponse(clientService.findAll(), HttpStatus.OK);
    }
}

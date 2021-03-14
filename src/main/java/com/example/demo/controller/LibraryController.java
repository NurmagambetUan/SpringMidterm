package com.example.demo.controller;


import com.example.demo.domain.Library;
import com.example.demo.domain.Request.LibraryRequest;
import com.example.demo.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/Library")
public class LibraryController extends BaseController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Library library) {
        return buildResponse(libraryService.add(library), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        return buildResponse(libraryService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<?> findByName(@RequestParam String name) {
        return buildResponse(libraryService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/findByAddress")
    public ResponseEntity<?> findByAddress(@RequestParam String address) {
        return buildResponse(libraryService.findByAddress(address), HttpStatus.OK);
    }

    @GetMapping("/findByPhoneNumber")
    public ResponseEntity<?> findByPhoneNumber(@RequestParam String phoneNumber) {
        return buildResponse(libraryService.findByPhoneNumber(phoneNumber), HttpStatus.OK);
    }

    @GetMapping("/findByCity")
    public ResponseEntity<?> findByCity(@RequestParam String city) {
        return buildResponse(libraryService.findByCity(city), HttpStatus.OK);
    }

    @GetMapping("/findByState")
    public ResponseEntity<?> findByState(@RequestParam String state) {
        return buildResponse(libraryService.findByState(state), HttpStatus.OK);
    }

    @PostMapping("/updateName")
    public ResponseEntity<?> updateName(@RequestParam Long id, String name) {
        return buildResponse(libraryService.updateName(id, name), HttpStatus.OK);
    }

    @PostMapping("/updateAll")
    public ResponseEntity<?> updateAll(@RequestParam Long id, String name, String address, String phoneNumber) {
        return buildResponse(libraryService.updateAll(id, name, address, phoneNumber), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        return buildResponse(libraryService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/delete/address")
    public ResponseEntity<?> deleteAddress(@RequestParam Long id) {
        return buildResponse(libraryService.deleteAddress(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return buildResponse(libraryService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add/address")
    public ResponseEntity<?> addAddress(@RequestBody LibraryRequest libraryRequest) {
        return buildResponse(libraryService.addAddress(libraryRequest), HttpStatus.OK);
    }

    @GetMapping("/findNameAndAddress")
    public ResponseEntity<?> findNameAndAddress(@RequestParam Long id) {
        return buildResponse(libraryService.getNameAndAddressResponse(id), HttpStatus.OK);
    }

}

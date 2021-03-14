package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.Library;
import com.example.demo.domain.Request.LibraryRequest;
import com.example.demo.domain.Request.LibraryRequestCity;
import com.example.demo.domain.Request.LibraryRequestState;
import com.example.demo.domain.Response.LibraryResponse;
import com.example.demo.domain.Response.LibraryResponseCity;
import com.example.demo.domain.Response.LibraryResponseState;
import com.example.demo.repo.LibraryRepo;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    private final LibraryRepo libraryRepo;

    public LibraryService(LibraryRepo libraryRepo) {
        this.libraryRepo = libraryRepo;
    }

    public Optional<Library> getId(Long id) {
        return libraryRepo.findById(id);
    }

    public Library add(Library library) {
        return libraryRepo.save(library);
    }

    public Library findById(Long id) {
        return libraryRepo.findByIdAndDeletedAtIsNull(id);
    }

    public Library findByName(String name) {
        return libraryRepo.findByNameAndDeletedAtIsNull(name);
    }

    public Library findByAddress(String address) {
        return libraryRepo.findByAddressAndDeletedAtIsNull(address);
    }

    public Library findByPhoneNumber(String phoneNumber) {
        return libraryRepo.findByPhoneNumberAndDeletedAtIsNull(phoneNumber);
    }

    public Library findByCity(String city) {
        return libraryRepo.findByCityAndDeletedAtIsNull(city);
    }

    public Library findByState(String state) {
        return libraryRepo.findByStateAndDeletedAtIsNull(state);
    }

    public LibraryResponse getNameAndAddressResponse(long id) {
        Library library = libraryRepo.findByIdAndDeletedAtIsNull(id);
        LibraryResponse libraryResponse = new LibraryResponse(library.getName(), library.getAddress());
        return libraryResponse;
    }

    public Library addAddress(LibraryRequest libraryRequest) {
        Library library = new Library();
        library.setAddress(libraryRequest.getAddress());
        libraryRepo.save(library);
        return library;
    }

    public Library addCity(LibraryRequestCity libraryRequestCity) {
        Library library = new Library();
        library.setCity(libraryRequestCity.getCity());
        libraryRepo.save(library);
        return library;
    }

    public LibraryResponseCity getCity(long id) {
        Library library = libraryRepo.findByIdAndDeletedAtIsNull(id);
        LibraryResponseCity libraryResponseCity = new LibraryResponseCity(library.getCity());
        return libraryResponseCity;
    }

    public Library addState(LibraryRequestState libraryRequestState) {
        Library library = new Library();
        library.setCity(libraryRequestState.getState());
        libraryRepo.save(library);
        return library;
    }

    public LibraryResponseState getState(long id) {
        Library library = libraryRepo.findByIdAndDeletedAtIsNull(id);
        LibraryResponseState libraryResponseState = new LibraryResponseState(library.getState());
        return libraryResponseState;
    }

    public String updateName(Long id, String name) {
        Library library = libraryRepo.findByIdAndDeletedAtIsNull(id);
        library.setName(name);
        libraryRepo.save(library);
        return "name updated";
    }

    public String updateAll(Long id, String name, String address, String phoneNumber) {
        Library library = libraryRepo.findByIdAndDeletedAtIsNull(id);
        library.setName(name);
        library.setAddress(address);
        library.setPhoneNumber(phoneNumber);
        libraryRepo.save(library);
        return "updated all";
    }

    public String delete(Long id) {
        Date date = new Date();
        Library library = libraryRepo.findByIdAndDeletedAtIsNull(id);
        library.setDeletedAt(date);
        libraryRepo.save(library);
        return "deleted";
    }

    public String deleteAddress(Long id) {
        Library library = libraryRepo.findByIdAndDeletedAtIsNull(id);
        library.setAddress(null);
        libraryRepo.save(library);
        return "address deleted";
    }

    public List<Library> findAll() {
        return libraryRepo.findAllByDeletedAtIsNull();
    }
}

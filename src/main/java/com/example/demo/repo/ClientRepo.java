package com.example.demo.repo;

import com.example.demo.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
    Client findByIdAndDeletedAtIsNull(long id);
    Client findByNameAndDeletedAtIsNull(String name);
    Client findByAddressAndDeletedAtIsNull(String address);
    Client findByPhoneNumberAndDeletedAtIsNull(int phoneNumber);
    List<Client> findAllByDeletedAtIsNull();
}

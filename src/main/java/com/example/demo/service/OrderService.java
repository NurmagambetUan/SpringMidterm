package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.Order;
import com.example.demo.repo.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Optional<Order> getId(Long id) {
        return orderRepo.findById(id);
    }

    public Order findById(Long id) {
        return orderRepo.findByIdAndDeletedAtIsNull(id);
    }

    public Order add(Order order) {
        return orderRepo.save(order);
    }

//    public Order findByClientId(int id) {
//        return orderRepo.findByClientIdAndDeletedAtIsNull(id);
//    }

//   //public Order findByBookId(int id) {
//        return orderRepo.findByBookIdAndDeletedAtIsNull(id);
//    }

//    public Order findByLibraryId(int id) {
//        return orderRepo.findByLibraryIdAndDeletedAtIsNull(id);
//    }

    public Order findByPassedDate(Date passedDate) {
        return orderRepo.findByPassedDateAndDeletedAtIsNull(passedDate);
    }

    public Order findByPassingDate(Date passingDate) {
        return orderRepo.findByPassingDateAndDeletedAtIsNull(passingDate);
    }

    public String updateAll(Long id, Date passedDate, Date passingDate) {
        Order order = orderRepo.findByIdAndDeletedAtIsNull(id);
        order.setPassedDate(passedDate);
        order.setPassingDate(passingDate);
        orderRepo.save(order);
        return "updated all";
    }

    public String delete(Long id) {
        Date date = new Date();
        Order order = orderRepo.findByIdAndDeletedAtIsNull(id);
        order.setDeletedAt(date);
        orderRepo.save(order);
        return "deleted";
    }

    public List<Order> findAll() {
        return orderRepo.findAllByDeletedAtIsNull();
    }
}

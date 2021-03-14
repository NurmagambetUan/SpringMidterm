package com.example.demo.repo;

import com.example.demo.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    Order findByIdAndDeletedAtIsNull(long id);
    Order findByPassedDateAndDeletedAtIsNull(Date passedDate);
    Order findByPassingDateAndDeletedAtIsNull(Date passingDate);
    List<Order> findAllByDeletedAtIsNull();
}

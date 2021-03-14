package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "seq",
        sequenceName = "s_order",
        initialValue = 1,
        allocationSize = 1
)
public class Order extends AuditModel {
    @Column(name = "passed_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Almaty")
    private Date passedDate;

    @Column(name = "passing_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Almaty")
    private Date passingDate;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Client client;

    @ManyToOne
    private  Library library;

}

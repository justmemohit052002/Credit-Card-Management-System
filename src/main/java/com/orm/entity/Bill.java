package com.orm.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bill_id;

    @Positive(message = "Total bill amount must be greater than 0")
    private double total_amount;

    @NotNull(message = "Bill date cannot be null")
    private LocalDate bill_date;

    @NotNull(message = "Due date cannot be null")
    private LocalDate due_date;

    // many bills can belong to one credit card
    @ManyToOne
    private CreditCard creditCard;
}
package com.orm.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int card_id;

    @NotNull(message = "Card number cannot be null")
    private long card_number;

    @Positive(message = "Credit limit must be greater than 0")
    private double credit_limit;

    @Min(value = 0, message = "Available limit cannot be negative")
    private double available_limit;

    // many cards belong to one customer
    @ManyToOne
    private Customer customer;

    // one card → many transactions
    @OneToMany(mappedBy = "creditCard")
    @ToString.Exclude
    private List<Transaction> transactions;

    // one card → many bills
    @OneToMany(mappedBy = "creditCard")
    @ToString.Exclude
    private List<Bill> bills;
}
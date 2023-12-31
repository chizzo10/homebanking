package com.mindhub.homebanking.models;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Transaction {
@Id
@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
@GenericGenerator(name="native", strategy = "native")
    private Long id;
    private TransactionType type;
    private double amount;
    private String description;

    private LocalDate date;

    public Transaction() {
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="account_id")
    private Account account;


    public Transaction(TransactionType type, double amount, String description, LocalDate date) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
}


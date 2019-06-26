package ua.bondary.bankapp.domain;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "balance")
    private Double balance;

    public Account(long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public Double getBalance() {
        //return balance;
        return 10.0;
    }
}

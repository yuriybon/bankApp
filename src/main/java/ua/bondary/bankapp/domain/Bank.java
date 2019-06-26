package ua.bondary.bankapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANK")
public class Bank {
    @Id private
    Long id;
    @Column(name="name")
    String name;
}

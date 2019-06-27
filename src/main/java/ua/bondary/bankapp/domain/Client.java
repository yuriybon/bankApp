package ua.bondary.bankapp.domain;

import javax.persistence.*;

@Entity
@Table(name="CLIENT")
public class Client {


    @Id
    @GeneratedValue
    Long Id;

    @Column(name="NAME")
    String clientName;
}

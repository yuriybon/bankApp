package ua.bondary.bankapp.domain;

import javax.persistence.*;

@Entity
@Table(name = "PARTY")
public class Party {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "PARTY_NAME")
    private String partyName;

    @Column(name = "PARTY_TYPE")
    private String partyType;

}

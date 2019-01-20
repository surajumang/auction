package com.orange.auction.model;

import lombok.Data;

import javax.persistence.*;

/*
@JoinColumn indicates that this is the owning side of the relationship.
Example of an Owning side would be { Consider the relationship between a Person and his Address.
    A person may have multiple addresses (indicated by a Set<Address> inside Person) and the
    Address must have a refernce to a Person (shown by a Person refrenece in Address). In this case
    the Address is the owner of the relationship as denoted by the single reference it has to
    Person. Whereas the Person side }.

    This mapping can be represented by
    class Person {
        @Id
        @GeneratedValue
        private int id;
        @OneToMany(mappedBy="PERSON_ID")
        private Set<Address> addresses;
    }

    class Address {
        @Id
        @GeneratedValue
        private int id;
        @ManyToOne
        @JoinColumn(name = "PERSON_ID")
        private Person person;
    }
 */

/*
    What does it mean by the Owning side in a relationship (ORM).
    The side which will have a foreign key is generally the owining side.
    In Java terms the side which is containing a reference to other object is the owner of the relation.
    Another thing to note here is that Hibernate doesn't allow One side of @OneToMany to be the owner
    of the relationship as that would need many pointers to be maintained for the other side.
    Only the Many side in a @OneToMany relationship can be the owner.
 */
@Entity(name = "PAYMENT")
@Data
public class Payment {
    private enum PaymentType{
        DEPOSIT, WITHDRAWAL
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "COMMITTEE_ID")
    private Committee committee;
    @Enumerated
    @Column(name = "PAYMENT_TYPE")
    private PaymentType paymentType;
    @Column(name = "AMOUNT")
    private long amount;

    public Payment() {
    }
}

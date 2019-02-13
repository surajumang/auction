package com.orange.auction.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/*
Adding a user in to the DB using json post request.
curl syntax to make a POST request :
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"email":"surajumang08@gmail.com", "firstName":"Suraj", "lastName": "Kumar", "password":"sdflkjs"}' \
  http://localhost:8080/users/
 */

@Entity(name="MEMBER")
@Data
public class Member extends BaseModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;
    @Column(name = "EMAIL")
    private String email;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ADDRESS")
    private String address;
    /*
    The Set of committees a member is part of, since an owner is also a participant and not every
    member needs to be an owner we don't need a set of committees which are owned by the member.
    When the owner creates a committe we need to add him as a participant as well.
     */
    @ManyToMany
    @JoinTable(name = "PARTICIPANT",
            joinColumns = {@JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "COMMITTEE_ID", referencedColumnName = "ID")})
    private Set<Committee> committees;

    @OneToMany(mappedBy = "member")
    private Set<Payment> payments;

    public Member(){

    }

    public Member(String firstName){
        this.firstName = firstName;
    }

    private static final Member DUMMY_MEMBER = new Member("Empty Member");

    public static Member getDummyMember() {
        return DUMMY_MEMBER;
    }

}

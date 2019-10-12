package com.orange.auction.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "COMMITTEE")
@Data
public class Committee extends BaseModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="OWNER_ID")
    private Member owner;

    @ManyToMany
    @JoinTable(name = "PARTICIPANT",
            joinColumns = {@JoinColumn(name = "COMMITTEE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID")})
    private List<Member> participants;

    @OneToMany(mappedBy = "committee")
    private Set<Payment> payments;
    @Column(name = "TENURE")
    private int tenure;
    @Column(name = "AMOUNT")
    private long amount;
    @Column(name = "BID_DATE")
    private int bidDate;

    public Committee() {
    }
}

package com.orange.auction.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/*
Since participant has to be a member, it makes perfect sense for participant to extend Member.
 */

@Entity(name = "PARTICIPANT")
@Data
public class Participant extends BaseModel {
    private enum MemberType {
        MEMBER, OWNER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Committee> committees;
    @Column(name = "MEMBER_TYPE")
    private MemberType memberType;

    public Participant() {
    }
}

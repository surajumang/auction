package com.orange.auction.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "COMMITTEE")
@Data
public class Committee extends BaseModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="OWNER_ID")
    private Member owner;

    private List<Participant> participants;
    @Column(name = "TENURE")
    private int tenure;
    @Column(name = "AMOUNT")
    private long amount;
    @Column(name = "BID_DATE")
    private int bidDate;

    public Committee() {
    }
}

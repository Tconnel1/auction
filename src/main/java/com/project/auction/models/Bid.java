package com.project.auction.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Bid {
    private final Bidder bidder;
    private int amount;
}

package com.project.auction.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Bidder {
    private final String name;
    private final int startingBid;
    private final int maxBid;
    private final int incrementAmount;
}

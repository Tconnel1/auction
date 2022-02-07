package com.project.auction.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@AllArgsConstructor
@Data
@Slf4j
public class Auction {
    private final String itemName;
    private final List<Bid> bids;
}

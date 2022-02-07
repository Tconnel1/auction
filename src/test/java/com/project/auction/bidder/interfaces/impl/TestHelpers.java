package com.project.auction.bidder.interfaces.impl;

import com.project.auction.models.Auction;
import com.project.auction.models.Bid;
import com.project.auction.models.Bidder;

import java.util.ArrayList;
import java.util.List;

public class TestHelpers {
    public static Auction createSkatesAuction() {
        List<Bid> bids = new ArrayList<>();
        Bidder alicia = new Bidder("Alicia", 50, 80, 3);
        Bidder olivia = new Bidder("Olivia", 60, 82, 2);
        Bidder mason = new Bidder("Mason", 55, 85, 5);
        Bid bid1 = new Bid(alicia, alicia.getStartingBid());
        Bid bid2 = new Bid(olivia, olivia.getStartingBid());
        Bid bid3 = new Bid(mason, mason.getStartingBid());
        bids.add(bid1);
        bids.add(bid2);
        bids.add(bid3);
        return new Auction("Skates", bids);
    }

    public static Auction createUnicycleAuction() {
        List<Bid> bids = new ArrayList<>();
        Bidder alicia = new Bidder("Alicia", 700, 725, 2);
        Bidder olivia = new Bidder("Olivia", 599, 725, 15);
        Bidder mason = new Bidder("Mason", 625, 725, 8);
        Bid bid1 = new Bid(alicia, alicia.getStartingBid());
        Bid bid2 = new Bid(olivia, olivia.getStartingBid());
        Bid bid3 = new Bid(mason, mason.getStartingBid());
        bids.add(bid1);
        bids.add(bid2);
        bids.add(bid3);
        return new Auction("Unicycle", bids);
    }

    public static Auction createHoverBoardAuction() {
        List<Bid> bids = new ArrayList<>();
        Bidder alicia = new Bidder("Alicia", 2500, 3000, 500);
        Bidder olivia = new Bidder("Olivia", 2800, 3100, 201);
        Bidder mason = new Bidder("Mason", 2501, 3200, 247);
        Bid bid1 = new Bid(alicia, alicia.getStartingBid());
        Bid bid2 = new Bid(olivia, olivia.getStartingBid());
        Bid bid3 = new Bid(mason, mason.getStartingBid());
        bids.add(bid1);
        bids.add(bid2);
        bids.add(bid3);
        return new Auction("Hover Board", bids);
    }
}

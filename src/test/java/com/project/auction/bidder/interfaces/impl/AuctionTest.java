package com.project.auction.bidder.interfaces.impl;

import com.project.auction.models.Auction;
import com.project.auction.models.Bid;
import com.project.auction.services.AuctionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AuctionTest {
    private final AuctionService auctionService = new AuctionService();

    private Auction skateAuction;
    private Auction unicycleAuction;
    private Auction hoverBoardAuction;

    @BeforeEach
    public void setUp() {
        skateAuction = TestHelpers.createSkatesAuction();
        unicycleAuction = TestHelpers.createUnicycleAuction();
        hoverBoardAuction = TestHelpers.createHoverBoardAuction();
    }

    @Test
    public void testEmptyAuction() {
        Auction auction = new Auction("Stretch Armstrong", Collections.emptyList());
        Bid winningBid = auctionService.auction(auction, null);

        assertEquals(null, winningBid.getBidder());
    }

    @Test
    public void testBicycleAuction() {
        Bid winningBid = auctionService.auction(skateAuction, null);

        assertEquals(skateAuction.getBids().get(2).getBidder(), winningBid.getBidder());
        assertEquals(85, winningBid.getAmount());
    }

    @Test
    public void testUnicycleAuction() {
        Bid winningBid = auctionService.auction(unicycleAuction, null);

        assertEquals(unicycleAuction.getBids().get(0).getBidder(), winningBid.getBidder());
        assertEquals(722, winningBid.getAmount());
    }

    @Test
    public void testScooterAuction() {
        Bid winningBid = auctionService.auction(hoverBoardAuction, null);

        assertEquals(hoverBoardAuction.getBids().get(1).getBidder(), winningBid.getBidder());
        assertEquals(3001, winningBid.getAmount());
    }
}

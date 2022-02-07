package com.project.auction.controllers;

import com.project.auction.models.Auction;
import com.project.auction.responses.AuctionResponse;
import com.project.auction.services.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auction")
public class AuctionController {
    private final AuctionService auctionService;

    @PostMapping("/start")
    public AuctionResponse startAuction(@RequestParam Auction auction) {
        return new AuctionResponse(auctionService.auction(auction, null));
    }
}

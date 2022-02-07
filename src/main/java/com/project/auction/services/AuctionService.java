package com.project.auction.services;

import com.project.auction.models.Auction;
import com.project.auction.models.Bid;
import com.project.auction.models.Bidder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuctionService {

    /**
     * Determine the winner of the item after competitors have entered bids.
     *
     * @param auction Item being auctioned and the list of bids placed on it.
     * @param highestBid Currently the bid winning the auction.
     * @return The Bid the won the Auction
     */
    public Bid auction(Auction auction, Bid highestBid) {
        boolean validBids = false;
        List<Bid> bids = auction.getBids();

        if (highestBid == null) {
            highestBid = new Bid(null, 0);
        }

        log.info("This round of the auction for [item: {}], has begun", auction.getItemName());

        // iterates through each bid to and collects the highest amount for each one to determine the rounds highest bidder.
        for(Bid bid : bids) {
            // gets this rounds bid from the bidder
            Bid currentBid = getRoundsHighestBid(bid.getBidder(), highestBid);
            if(currentBid != null) {
                // if the current bid is higher than the highest bid. set new highest and mark validBids
                if (currentBid.getAmount() > highestBid.getAmount()) {
                    highestBid = currentBid;
                    validBids = true;
                }
                // check to select winner in case of a tie. selects the earliest bidder.
                if (currentBid.getAmount() == highestBid.getAmount() && highestBid.getBidder() != null) {
                    if (bids.indexOf(currentBid.getBidder()) < bids.indexOf(highestBid.getBidder()))
                        highestBid = currentBid;
                }
            }
        }
        // checks if there were still valid bids for the next round of the auction
        if (validBids) {
            highestBid = auction(auction, highestBid);
        } else if (highestBid.getBidder() != null) {
            log.info("[Auction Item: {}] Has been won by {}", auction.getItemName(), highestBid.getBidder().getName());
        } else {
            log.info("Nobody won. No bids were placed on {} ", auction.getItemName());
        }

        return highestBid;
    }

    /**
     * gets the current bid from the bidder, determined by the highest bid in the auction.
     *
     * @param bidder current bidder attempting to make bid on item
     * @param lastBid The last bid given.
     * @return The competitors newest bid on the item
     */
    private Bid getRoundsHighestBid(final Bidder bidder, final Bid lastBid) {
        Bid nextBid = null;
        int currentBid = bidder.getStartingBid();

        /* Makes three checks:
            1. if the bidder is currently winning.
            2. if the bidder is the first bid
            3. if the bidder can beat the current bid
         */
        if (bidder.equals(lastBid.getBidder())) {
            log.info("{} is currently winning, they will not bid against themselves", bidder.getName());
            nextBid = lastBid;
        } else if (lastBid.getBidder() == null) {
            log.info("{} has kicked off the auction with a bid for {}", bidder.getName(), bidder.getStartingBid());
            nextBid = new Bid(bidder, bidder.getStartingBid());
        } else if (bidder.getMaxBid() >= lastBid.getAmount()) {
            currentBid = getHigherBid(bidder, lastBid, currentBid);
            nextBid = new Bid(bidder, currentBid);
        }
        return nextBid;
    }

    /**
     *
     * @param bidder The bidder attempting to beat the current bid
     * @param winningBid the amount on the bid currently winning the auction
     * @param competitorsBid the bidders bid that will attempt to beat the currently winning bid
     * @return
     */
    private int getHigherBid(Bidder bidder, Bid winningBid, int competitorsBid) {
        // increases the amount from starting by the bidders increment until it outbids the current bid or maxes out.
        while (competitorsBid <= winningBid.getAmount()) {
            // checks if amount can increase by full increment. if not - do not go to max bet.
            int maxBidCheck = competitorsBid + bidder.getIncrementAmount();
            if (maxBidCheck <= bidder.getMaxBid()) {
                competitorsBid += bidder.getIncrementAmount();
            } else {
                break;
            }
        }
        if(competitorsBid > winningBid.getAmount()) {
            log.info("A new bid has been made by {}, for {}", bidder.getName(), competitorsBid);
        } else {
            log.info("{} could not beat the last bid", bidder.getName());
        }
        return competitorsBid;
    }
}

package com.project.auction.responses;

import com.project.auction.models.Bid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AuctionResponse {
    private Bid bid;
}

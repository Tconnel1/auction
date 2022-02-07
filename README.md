Auction Exercise

The assigned task was to create an auction program that would find
the highest bid for an auctioned item based on given bidder parameters.

logic requirements as understood were:
    1. Bidders provide starting bid, maximum bid, and bid increments
    2. Bids will only increase by the bidders chosen increment.
    3. Current bid can never exceed max bid
    4. In case of tie, the earliest bid wins.
    5. Algorithm should determine winner and amount of winning bid.

Process:

    1. The first step was deciding how I wanted my data to be stored and managed.
       I chose 3 models; Auction, bid, and bidder. These models properly 
       contained all the need information to complete the process and
       managed them in readable chunks.
        a. Auction: Linked the item being auctioned to all the bids made on it
        b. Bid: contains the bidder that is making this bid and the amount he is currently bidding
        c. Bidder: contains the bidders name and bid limits (start, max, increment)

    2. After that i worked on the skeleton of the auction() method. the method took in
       an Auction object and a Bid. I started with a recursive setup that would go through each bid in 
       the list of bids to try and get the top bid amount. The auction would run again if there were
       valid bids and use the new highest bid as the parameter. To determine this i made
       a second method.

    3. The getRoundsHighestBid() method takes the current bidder in the for loop
       bidding and the last bid to win the round. It starts by checking if the current biddder
       is already winning. THey shouldn't outbid themselves. Then it checks if the current
       bid is higher than their max. No need to increment if they can't win. Finally the bidder 
       would increment their starting bid until it is higher than the last bid or hits it's max. 
       Depending on the results, the bidder will tap out or be the newest top bid.

    4. After that i created the setup to determine who wins ties which was checking which bidder
       has the earliest index in the list.

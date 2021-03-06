def find_inside_trader(feed):
    flagged_trades = []
    trades = {}
    current_price = 0
    for transaction in feed:
        vals = transaction.split("|")
        curr_day = int(vals[0])
        if len(vals) == 2:
            current_price = int(vals[1])
            for prev_day in range(curr_day-3, curr_day):
                if prev_day in trades:
                    for (trader_name, isBuy, price, amount) in trades[prev_day]:
                        if (prev_day, trader_name) in flagged_trades:
                            continue
                        if isBuy:
                            isInsideTrader = (current_price - price) * amount >= 500000
                        else:
                            isInsideTrader = (price - current_price) * amount >= 500000
                        if isInsideTrader:
                            flagged_trades.append((prev_day, trader_name))
        else:
            trader_name = vals[1]
            isBuy = len(vals[2]) == 3
            amount = int(vals[3])
            if curr_day not in trades:
                trades[curr_day] = []
            trades[curr_day].append((trader_name, isBuy, current_price, amount))
    flagged_trades = sorted(list(flagged_trades))
    return list(map(lambda x: str(x[0]) + "|" + str(x[1]), flagged_trades))




#Testing 
feed1 = """0|1000
0|Shilpa|BUY|30000
0|Will|BUY|50000
0|Tom|BUY|40000
0|Kristi|BUY|15000
1|Kristi|BUY|11000
1|Tom|BUY|1000
1|Will|BUY|19000
1|Shilpa|BUY|25000
2|1500
2|Will|SELL|7000
2|Shilpa|SELL|8000
2|Kristi|SELL|6000
2|Tom|SELL|9000
3|500
38|1000
78|Shilpa|BUY|30000
79|Kristi|BUY|60000
80|1100
81|1200"""
 
datafeed1 = feed1.split("\n")
 
find_inside_trader(datafeed1)

feed2 = """0|20
0|Kristi|SELL|3000
0|Will|BUY|5000
0|Tom|BUY|50000
0|Shilpa|BUY|1500
1|Tom|BUY|1500000
3|25
5|Shilpa|SELL|1500
8|Kristi|SELL|600000
9|Shilpa|BUY|500
10|15
11|5
14|Will|BUY|100000
15|Will|BUY|100000
16|Will|BUY|100000
17|25"""
 
datafeed2 = feed2.split("\n")
 
find_inside_trader(datafeed2)
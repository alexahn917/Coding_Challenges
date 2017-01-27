def findFraudolentTraders(datafeed):
    flagged_trades = set()
    trades = dict()
    current_price = None
    for feed in datafeed:
        vals = feed.split("|")
        day = int(vals[0])
        if len(vals) == 2:
            current_price = int(vals[1])
            for x in range(day - 3, day):
                if x in trades:
                    for (trader_name, isBuy, price, amount) in trades[x]:
                        if (x, trader_name) in flagged_trades:
                            continue
                        if isBuy:
                            fraudolent = (current_price - price) * amount >= 5000000
                        else:
                            fraudolent = (price - current_price) * amount >= 5000000
                        if fraudolent:
                            flagged_trades.add((x, trader_name))
        else:
            trader_name = vals[1]
            isBuy = len(vals[2]) == 3
            amount = int(vals[3])
            if day not in trades:
                trades[day] = []
            trades[day].append((trader_name, isBuy, current_price, amount))
    flagged_trades = sorted(list(flagged_trades))
    return list(map(lambda x: str(x[0]) + "|" + str(x[1]), flagged_trades))
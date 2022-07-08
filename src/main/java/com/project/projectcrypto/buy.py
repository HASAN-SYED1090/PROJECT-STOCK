
API_KEY = 'PK5R4ARORC9WEOG38Q4M'
SECRET_TOKEN = 'JkJUKGbJMhGuBHmIGSU8cLXYNJLHNEvoG9AFSqtW'
BASE_URL = 'https://paper-api.alpaca.markets'
import alpaca_trade_api as tradeapi
api = tradeapi.REST(
    base_url = BASE_URL,
    key_id = API_KEY,
    secret_key = SECRET_TOKEN
)
account = api.get_account()
if account.trading_blocked:
  print("Your Account is restricted from trading.")
print("${} is available as buying power".format(account.buying_power))
balance_change = float(account.equity) - float(account.last_equity)
print(f'today portfolio balance changes: ${balance_change}')

# ticker="GOOG"
# quantity=1
# print(type(quantity))
# side="buy"
# type= "market"

file = open("C:\\Users\\HPP\\ProjectCrypto\\buy.txt","r")
text = file.readlines()
ticker = text[0]

if (ticker[0:4] == "FORD" ):
    ticker = "F"

elif (ticker[0:4] == "HPCO" ):
    ticker = "HPQ"

elif (ticker[0:4] == "TSLA" ):
    ticker = "TSLA"

elif (ticker[0:4] == "GOOG" ):
    ticker = "GOOG"

elif (ticker[0:4] == "MSFT" ):
    ticker = "MSFT"
else:
    ticker = "AAPL"


# ticker = text[0]
# ticker = ticker[0:4]
quantity = int(text[1])
ordertype = text[2]
side = text[3]
file.close()

print(ticker)
print (quantity)
print (ordertype)
print (side)
order = api.submit_order(symbol = ticker,qty = quantity,side=side, type="market", time_in_force= 'day')









# API_KEY = 'PKGGM516KZYPV0I7U9L9'
# SECRET_TOKEN = 'Z191P8Ey5ckdrRcjTXyMVVcBooyFypRSQtnwi5ci'
# BASE_URL = 'https://paper-api.alpaca.markets'

# buyorder = []
# file = open("C:\\Users\\HPP\\ProjectCrypto\\buy.txt","r")
# text = file.readlines()
# ticker=text[0]
# quantity = text[1]
# quantity=int(quantity)
# ordertype= text[2]
# side= text[3]
# file.close()
# print("order")
# print(ticker)
# print(quantity)
# print(side)
# print(ordertype)
# import alpaca_trade_api as tradeapi
#
# api = tradeapi.REST(
#     base_url = BASE_URL,
#     key_id = API_KEY,
#     secret_key = SECRET_TOKEN
# )
# account = api.get_account()
# order = api.submit_order(symbol='AAPL',qty = 7,side='buy', type='market', time_in_force= 'day')
# if account.trading_blocked:
#   print("Your Account is restricted from trading.")
#
# print("${} is available as buying power".format(account.buying_power))
#
# balance_change = float(account.equity) - float(account.last_equity)
# print(f'today portfolio balance changes: ${balance_change}')

print("order")
#order = api.submit_order(symbol=ticker,qty = quantity,side= side, type= ordertype, time_in_force= 'day')
# if (ticker == "TSLA"):
#     order = api.submit_order(symbol="TSLA",qty = 7,side=side, type='market', time_in_force= 'day')
# elif (ticker == "AAPL"):
#     print("order placed apple")
#     order = api.submit_order(symbol="AAPL",qty = 7,side=side, type='market', time_in_force= 'day')
# elif (ticker == "GOOG"):
#     order = api.submit_order(symbol="GOOG",qty = 7,side=side, type='market', time_in_force= 'day')
# elif (ticker == "HPQ"):
#     order = api.submit_order(symbol="TSLA",qty = 7,side=side, type='market', time_in_force= 'day')
# elif (ticker == "F"):
#     order = api.submit_order(symbol="F",qty = 7,side=side, type='market', time_in_force= 'day')
# elif (ticker == "MSFT"):
#     order = api.submit_order(symbol="MSFT",qty = 7,side=side, type='market', time_in_force= 'day')
# else:
#     order = api.submit_order(symbol='MSFT',qty = 7,side='buy', type='market', time_in_force= 'day')
#
# order = api.submit_order(symbol='AAPL',qty = 7,side='buy', type='market', time_in_force= 'day')
#
# print("order")
f = open("orders.txt","a")
f.write("Buy \n")
f.write(ticker+ "\n")
f.write(quantity+ "\n")
f.write(ordertype+ "\n")
f.write(side+ "\n")
f.close()


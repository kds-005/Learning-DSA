# N : number of inputs
# Time Complexity: Initializing StockSpanner- O(1), next() - O(N^2)
# Space Complexity: O(N)
# class StockSpanner:

#     def __init__(self):
#         self.prices = []

#     def next(self, price: int) -> int:
#         self.prices.append(price)
#         n = len(self.prices)
#         i = n - 1
#         while i >= 0 and self.prices[i] <= price:
#             i -= 1
#         return n - i - 1



# N : number of inputs
# Time Complexity: Initializing StockSpanner- O(1), next() - O(N)
# Space Complexity: O(N)
class StockSpanner:

    def __init__(self):
        self.priceStack = []
        self.days = 1

    def next(self, price: int) -> int:
        while len(self.priceStack) > 0 and self.priceStack[-1][0] <= price:
            self.priceStack.pop()
        prev = 0 if len(self.priceStack) == 0 else self.priceStack[-1][1]
        self.priceStack.append([price, self.days])
        self.days += 1
        return self.priceStack[-1][1] - prev
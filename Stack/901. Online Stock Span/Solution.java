import java.util.*;

// N : number of inputs
// Time Complexity: Initializing StockSpanner- O(1), next() - O(N^2)
// Space Complexity: O(N)
// class StockSpanner {
//     ArrayList<Integer> prices;
//     public StockSpanner() {
//         prices = new ArrayList<>();
//     }
    
//     public int next(int price) {
//         prices.add(price);
//         int n = prices.size();
//         int i = n - 1;
//         while (i >= 0 && prices.get(i) <= price) i--;
//         return n - i - 1;
//     }
// }



// N : number of inputs
// Time Complexity: Initializing StockSpanner- O(1), next() - O(N)
// Space Complexity: O(N)
class StockSpanner {
    Stack<List<Integer>> priceStack;
    int days;
    public StockSpanner() {
        priceStack = new Stack<>();
        days = 1;
    }
    
    public int next(int price) {
        int prev = 0;
        while (!priceStack.isEmpty() && priceStack.peek().get(0) <= price) priceStack.pop();
        if (!priceStack.isEmpty()) prev = priceStack.peek().get(1);
        priceStack.push(Arrays.asList(price, days++));
        return priceStack.peek().get(1) - prev;
    }
}
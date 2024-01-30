class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int min_price = prices[0];
        int max_price = 0;
        for(int i : prices){
            min_price = Math.min(i,min_price);
            max_price = Math.max(max_price,i-min_price);
        }
        return max_price;
    }
}
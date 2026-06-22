class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;

        for (int cost : costs) {
            max = Math.max(max, cost);
        }

        int[] count = new int[max + 1];

        for (int cost : costs) {
            count[cost]++;
        }

        int bars = 0;

        for (int price = 1; price <= max; price++) {
            while (count[price] > 0 && coins >= price) {
                coins -= price;
                bars++;
                count[price]--;
            }
        }

        return bars;
    }
}
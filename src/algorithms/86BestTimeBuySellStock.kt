package algorithms

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * 记录数组最大值和最小值
 */
fun main(args: Array<String>) {
    val nums = intArrayOf(7,1,5,3,6,4)
    System.out.println("${maxProfit(nums)}")
}

private fun maxProfit(prices: IntArray): Int {
    var cost = Int.MAX_VALUE
    var profit = 0

    prices.forEach { price->
        cost = Math.min(cost, price)
        profit = Math.max(profit, price - cost)
    }

    return profit
}
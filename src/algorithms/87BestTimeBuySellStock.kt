package algorithms


/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 * 定义状态 dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，
 * dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）
 * dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}
 * dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}
 */
fun main(args: Array<String>) {
    val prices = intArrayOf(7,1,5,3,6,4)

    System.out.println("${maxProfit(prices)}")
}

private fun maxProfit(prices: IntArray): Int {

    val dp = Array(prices.size) { IntArray(2) }
    dp[0][0] = 0
    dp[0][1] = -prices[0]

    prices.forEachIndexed { index, price->
        if(index == 0) return@forEachIndexed
        dp[index][0] = Math.max(dp[index-1][0], dp[index-1][1] + price)
        dp[index][1] = Math.max(dp[index-1][1], dp[index-1][0] - price)
    }

    System.out.println("${dp.joinToString(transform = {
        "[${it.joinToString()}]"
    })}")
    return dp.last()[0]
}
package algorithms

/**
 * 322. 零钱兑换
 * https://leetcode.cn/problems/coin-change/description/
 * 解法一：回溯法
 */
fun main(args: Array<String>) {
    val coins = intArrayOf(1, 2, 5)

    // 解法一：回溯法
    System.out.println("${coinChange1(coins, 11)}")

    // 解法二：动态规划
    System.out.println("${coinChange2(coins, 11)}")
}

private fun coinChange2(coins: IntArray, amount: Int): Int {
    // 创建dp数组，大小为amount+1，初始化每个元素为amount+1（表示不可达）
    val dp = IntArray(amount + 1) { amount + 1 }
    dp[0] = 0 // 金额0需要0个硬币

    // 动态规划：遍历每个金额
    for (i in 1..amount) {
        for (coin in coins) {
            // 如果当前硬币面值小于等于当前金额i
            if (coin <= i) {
                // 更新dp[i]：比较不取这个硬币（原值）和取这个硬币（dp[i-coin]+1）的最小值
                dp[i] = minOf(dp[i], dp[i - coin] + 1)
            }
        }
    }

    // 如果dp[amount]仍然大于amount，说明无法凑出
    return if (dp[amount] > amount) -1 else dp[amount]
}

private fun coinChange1(coins: IntArray, amount: Int): Int {
    val result: MutableList<List<Int>> = mutableListOf()
    backtrackCoinChange(coins,0, amount, result, mutableListOf())
    System.out.println("${result.joinToString(transform = {
        "[${it.joinToString()}]"
    })}")
    return result.minOf { it.size }
}

private fun backtrackCoinChange(coins: IntArray, start: Int, amount: Int, result: MutableList<List<Int>>, path: MutableList<Int>) {
    if(amount == 0) {
        result.add(path.toList())
        return
    }

    for (index in start..coins.lastIndex) {
        if (amount < 0) break
        path.add(coins[index])

        backtrackCoinChange(coins, index, amount - coins[index], result, path)
        path.removeLast()
    }
}


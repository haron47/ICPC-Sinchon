#14494 - 다이나믹이 뭐예요
n, m = map(int, input().split())
dp = [[1 for row in range(m + 1)] for col in range(n + 1)]
MOD = 1000000007

for i in range(2, n + 1):
    for j in range(2, m + 1):
        dp[i][j] = (dp[i - 1][j] + dp[i][j - 1] + dp[i - 1][j - 1]) % MOD

print(dp[n][m])
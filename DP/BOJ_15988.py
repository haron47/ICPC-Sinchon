dp = [0] * 10000001
divide = 1000000009
dp[1] = 1
dp[2] = 2
dp[3] = 4
for i in range(4, 1000001):
    dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % divide

T = int(input())
while T > 0:
    n = int(input())
    print(dp[n])
    T -= 1
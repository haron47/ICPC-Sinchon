#2470 - 두용액
N = int(input())
arr = list(map(int, input().split()))
arr.sort()
MIN = int(1e10)

for i in range(N - 1):
    low = i + 1
    high = N - 1
    while high >= low:
        mid = (low + high) // 2
        if arr[i] + arr[mid] == 0:
            res = mid
            break
        elif mid == high:
            res = high
            break
        elif abs(arr[i] + arr[mid]) > abs(arr[i] + arr[mid + 1]):
            low = mid + 1
        elif abs(arr[i] + arr[mid]) > abs(arr[i] + arr[mid - 1]):
            high = mid - 1
        else:
            res = mid
            break
    res = abs(arr[i] + arr[mid])
    if MIN > res and i != mid:
        MIN = res
        al = min(arr[i], arr[mid])
        ar = max(arr[i], arr[mid])
print(al, ar)
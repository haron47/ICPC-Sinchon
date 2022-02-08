def binary_sort(A, low, high, key):
    if low > high:
        return 0
    mid = (low + high) // 2
    if key == A[mid]:
        return 1
    elif key < A[mid]:
        return binary_sort(A, low, mid - 1, key)
    else:
        return binary_sort(A, mid + 1, high, key)

N = int(input())
A = list(map(int, input().split()))
A.sort()
M = int(input())
key = list(map(int, input().split()))

for i in range(M):
    print(binary_sort(A, 0, N - 1,key[i]))
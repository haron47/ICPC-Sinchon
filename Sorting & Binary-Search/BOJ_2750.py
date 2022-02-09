#sorting- 2750- 수 정렬하기
N = int(input())
arr = [0] * N
for i in range(N):
    arr[i] = int(input())
arr.sort()
for i in range(N):
    print(arr[i])
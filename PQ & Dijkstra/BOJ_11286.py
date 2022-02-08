import sys
import heapq
heap = []
N = int(sys.stdin.readline())
for i in range(N):
    num = int(sys.stdin.readline())
    if num != 0:
        heapq.heappush(heap, (abs(num), num))
    elif heap:
        (ab, num) = heapq.heappop(heap)
        print(num)
    else:
        print(0)
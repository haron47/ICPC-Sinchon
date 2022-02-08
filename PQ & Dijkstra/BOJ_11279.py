#11279 - 최대힙
import sys
import heapq
heap = []
N = int(sys.stdin.readline())
for i in range(N):
    num = int(sys.stdin.readline())
    if num != 0:
        heapq.heappush(heap, (-num, num))
    elif heap:
        (minus, num) = heapq.heappop(heap)
        print(num)
    else:
        print(0)

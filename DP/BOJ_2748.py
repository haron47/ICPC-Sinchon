fibo = [-1] * 91

def Fibo(n):
    if n <= 1:
        fibo[n] = n
    elif fibo[n] == -1:
        fibo[n] = Fibo(n - 2) + Fibo(n - 1)
    return fibo[n]

n = int(input())
print(Fibo(n))
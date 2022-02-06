n=int(input())
for i in range(n+1):
    for j in range(i+1):
        print(j%10,end="")
    print(" "*(n-1))


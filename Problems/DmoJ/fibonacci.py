# no memoization, ty geeksforgeeks
def fib(n) :
    # Base cases
    if (n == 0) :
        return 0
    if (n == 1 or n == 2) :
        return 1

    if( n & 1) :
        k = (n + 1) // 2
    else : 
        k = n // 2

    # Applying above formula [Note value n&1 is 1
    # if n is odd, else 0.
    if((n & 1) ) :
        return (fib(k) * fib(k) + fib(k-1) * fib(k-1))
    else :
        return (2*fib(k-1) + fib(k))*fib(k)


# Driver code
n = int(input())
print(fib(n) % 1000000007)
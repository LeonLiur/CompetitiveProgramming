arr = [1,   2,  4,  9,  12, 24, 124,    242]
x = 0
y = len(arr) - 1

while x < y:
    cur = arr[x] + arr[y]
    print("cur: " + str(cur))
    if cur < 128:
	    x += 1
    elif cur > 128:
	    y -= 1
    else:
        print(str(arr[x]) + " " + str(arr[y]))
        exit()

print("inpossible")

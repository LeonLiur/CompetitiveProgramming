n = int(input())
map = {'q': 1, 'w': 1, 'e': 1, 'r': 1, 't': 1, 'y': 1, 'u': 1, 'i': 1, 'o': 1, 'p': 1,
'a': 2, 's': 2, 'd': 2, 'f': 2, 'g': 2, 'h': 2, 'j': 2, 'k': 2, 'l' : 2, 'z': 3, 'x': 3,
'c' : 3, 'v' : 3, 'b' : 3, 'n' : 3, 'm' : 3}

counter = 0

for _ in range(n):
    s = input()
    canBeTypedInOne = True
    for i in range(len(s) - 1):
        if(map[s[i + 1]] != map[s[i]]):
            canBeTypedInOne = False
            break
    
    if canBeTypedInOne:
        counter += 1

print(counter)
    
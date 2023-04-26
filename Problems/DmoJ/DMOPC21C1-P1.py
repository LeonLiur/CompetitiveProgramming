n = int(input())
singles = ['a', 'e', 'i', 'o', 'u']
cons = ['k', 'n', 'h', 'm', 'r']

for _ in range(n):
    flag = False
    s = input()
    pointer = 0
    while pointer < len(s):
        if s[pointer] in singles:
            pointer+=1
            continue;
        if s[pointer] in cons:
            if pointer == len(s) - 1:
                flag = True
                break
            if s[pointer] == 'h' and s[pointer + 1] == 'u':
                flag = True
                break
            if s[pointer] in cons and s[pointer + 1] in singles:
                pointer += 2
                continue
            if s[pointer] == 'f' and s[pointer + 1] == 'u':
                pointer += 2
                continue
    print("YES" if not flag else "NO")

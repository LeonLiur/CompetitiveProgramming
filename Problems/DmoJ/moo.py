n = int(input())
t = input()
if len(t) > n*3:
    print("no")
i = t.find("m")
j = t.rfind("moo")
pre = t[:i]
suf = t[j+3:]
if not (pre == "oo" or pre == "o" and (suf == "m" or suf == "mo")):
    print("no")
    exit()

t = t.replace("moo", "")
if len(t) != len(pre) + len(suf):
    print("no")
else:
    print("yes")
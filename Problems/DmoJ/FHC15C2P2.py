import sys

cases = int(sys.stdin.readline())
for i in range(cases):
    num_ids = int(sys.stdin.readline())
    double_q = [int(x) for x in  sys.stdin.readline().split()]
    top = 0
    bottom = 0
    for j in range(num_ids):
        if len(double_q) == 0:
            print(f'Case #${i + 1}: yes')
            break
        if j == 0:
            top = double_q[0]
            bottom = double_q[0]
            double_q.pop(0)
        else:
            if top - 1 == double_q[0]:
                top = double_q[0]
                double_q.pop(0)
            elif top - 1 == double_q[-1]:
                top = double_q[-1]
                double_q.pop(-1)
            elif bottom + 1 == double_q[0]:
                bottom = double_q[0]
                double_q.pop(0)
            elif bottom + 1 == double_q[-1]:
                bottom = double_q[-1]
                double_q.pop(-1)
            else:
                print(f'Case #{i + 1}: no')
                break

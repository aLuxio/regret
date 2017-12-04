import math

count = int(input("number of test cases: "))

for perm in range(0, count):
    print("length of sides/angles. input '?' for which element you want to find")
    print("A = opp., B = adj., C = hyp., θ = angle")
    a = int(input("A = "))
    b = int(input("B = "))
    c = int(input("C = "))
    θ = int(input("θ = "))

    if a == '?':
        a = math.sin(θ) * c
    elif b == '?':
        b = math.cos(θ) * c
    elif c == '?':
        if b == '?':
            c = a / math.sin(θ)
        elif a == '?':
            c = b / math.cos(θ)
    elif θ == '?':
        if a == '?':
            θ = math.acos(b/c)
        elif b == '?':
            θ = math.asin(a/c)
        elif c == '?':
            θ = math.atan(a/b)

    print('A=' + a + "\nB=" + b + "\nC=" + c + "\nθ=" + θ)

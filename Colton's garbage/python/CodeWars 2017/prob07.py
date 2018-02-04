# CodeWars 2017 - Problem 7 - Iterative Solutions

import math

file = open("data\\prob07-in.txt")
count = int(file.readline())

for index in range(0, count):
    x0, a, b, c, m, n, e = file.readline().split()
    x0 = int(x0)
    a = int(a)
    b = int(b)
    c = int(c)
    m = int(m)
    n = int(n)
    e = float(e)

    i = 0
    x = x0
    while i <= 100 and abs(e)
        x = c + (a * x + m) / (b * x + n)

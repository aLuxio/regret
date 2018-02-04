# CodeWars 2017 - Problem 6 - Delta Inversion

file = open("data\\prob06-in.txt")

for a in range(0, int(file.readline()[:-1])):
    line = list(file.readline().split())
    deltas = list()
    output = [int(line[1])]

    for b in range(1, len(line)-1):
        deltas.append(-(int(line[b+1]) - int(line[b])))

    for index in range(0, len(deltas)):
            output.append(output[index] + deltas[index])

    for ayy in output:
        print(ayy, '', end='')
    print()

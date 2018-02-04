import point, math, re

# kx^2+kx+k
class Polynomial(object):

    def __init__(self, equ):
        self.equation = equ
        self.data = equ.split()

    def getNumFactors(self):
        out = 0
        for a in self.equation:
            if a == 'x': out += 1
        return out

    def solve(self, var):
        result = 0
        for it in self.data:
            a = str(it)
            varPos = a.index('x') if not a.index('x') >= 0 else -1
            if re.match('\dx\^\d', a):
                result += varPos-1 * pow(var, varPos+2)
            elif re.match('x\^\d', a):
                result += pow(var, varPos+2)
            elif re.match('\dx', a):
                result += varPos-1 * var
            else:
                result += var
        return result

    def __str__(self):
        return str(self.data)


lol = Polynomial('x^2 + 2x + 4')
print(lol.getNumFactors(), lol)
print(lol.solve(2))

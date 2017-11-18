import math

class Point(object):
    x = 0.0
    y = 0.0

    def __init__(self, x, y):
        self.x = x
        self.y = y

    def move(self, dx, dy):
        self.x = self.x + dx
        self.y = self.y + dy

    def getx(self):
        return self.x

    def gety(self):
        return self.y

    def __cmp__(self, other):
        if self.x < other.x:
            return -1
        if self.x > other.x:
            return 1

        if self.y < other.y:
            return -1
        if self.y > other.y:
            return 1

        return 0

    def distance(self, other):
        return math.sqrt((other.x - self.x) ** 2 + (other.y - self.y) ** 2)

    def __str__(self):
        return '(%g, %g)' % (self.x, self.y)

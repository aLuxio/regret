import math, point

class Point(object):

    def __init__(self):
        self.x = 0
        self.y = 0

    def __init__(self, x_init, y_init):
        self.x = x_init
        self.y = y_init

    def __cmp__(self, other):
        if self.x < other.x: return -1
        if self.x > other.x: return 1

        if self.y < other.y: return -1
        if self.y > other.y: return 1

        return 0

    def equals(self, other):
        if __cmp__(self, other) == 0: return True

    def move(self, x, y):
        self.x = x
        self.y = y

    def shift(self, x, y):
        self.x += x
        self.y += y

    def distance(self, x, y):
        dx = math.fabs(self.x - x)
        dy = math.fabs(self.y - y)
        return math.sqrt(dx ** 2 + dy ** 2)

    def distance(self, other):
        dx = math.fabs(self.x - other.x)
        dy = math.fabs(self.y - other.y)
        return math.sqrt(dx ** 2 + dy ** 2)

    def slope(self, other):
        return (other.y - self.y)/(other.x - self.x)

    def __str__(self):
        return '(%g, %g)' % (self.x, self.y)

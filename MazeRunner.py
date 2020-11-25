class Runner:
    #Purpose of this class is to provide OOP functionality to generalize the behavior of the maze runner.
    #Be as abstract as possible.
    #Possible functions:
    #1. #GetMoves() , gets the available squares which are open in all directions from the runner.
    #2. +MakeMove(+enum DIRECTION) , takes the move with argument specifying the move.
    #3. #GetCoordinates() , returns the current coordinates of the runner.
    class Direction:
        direction = ""

        def __init__(self, xVal, yVal):
            self.pos = tuple((xVal, yVal))
            #cover all direction strings.
            if xVal == 0 and yVal == 1:
                self.direction = "Up"
            elif xVal == 1 and yVal == 1:
                self.direction = "UpRight"
            elif xVal == 1 and yVal == 0:
                self.direction = "Right"
            elif xVal == 1 and yVal == -1:
                self.direction = "DownRight"
            elif xVal == 0 and yVal == -1:
                self.direction = "Down"
            elif xVal == -1 and yVal == -1:
                self.self.direction = "DownLeft"
            elif xVal == -1 and yVal == 0:
                self.direction = "Left"
            elif xVal == -1 and yVal == 1:
                self.direction = "LeftUp"
            else:
                printerror("There was a problem with the Direction class use!")

    def __init__(self, map):
        self.map = map
        while i < len(map[0]):
            while j < len(map[i][0]):
                if map[i][j] == 'P':
                    self.pos = tuple((i,j))
                elif map[i][j] == '*':
                    self.goal = tuple((i,j))
                    #must compute manhattan distance too...
                    return
                j += 1
            i += 1

    def getAvailableMoves(self):
        k = 0
        f = 1
        ls = list([])
        while k < 8:
            dir = Direction(k % 2, f % 2)
            if self.map[self.x + dir.pos[0]][self.y + dir.pos[1]] == ' ':
                ls += dir
            k += 1
            f += 1
        return
        ls = list([])

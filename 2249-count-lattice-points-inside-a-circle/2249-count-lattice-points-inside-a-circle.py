class Solution:
    def countLatticePoints(self, circles: List[List[int]]) -> int:
        out = set()
        for i in range(len(circles)):
            i_center = circles[i][0]
            j_center = circles[i][1]
            radius = circles[i][2]
            for ii in range(i_center-radius, i_center+radius+1):
                for jj in range(j_center-radius, j_center+radius+1):
                    if (ii,jj) not in out:
                        if sqrt((ii-i_center)**2 + (jj-j_center)**2) <= radius:
                            out.add((ii, jj))
                        

        return len(out)
package leetcode.success.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/walking-robot-simulation/description/
 * A robot on an infinite grid starts at point (0, 0) and faces north.  The robot can receive one of three possible types of commands:
 * <p>
 * -2: turn left 90 degrees
 * -1: turn right 90 degrees
 * 1 <= x <= 9: move forward x units
 * Some of the grid squares are obstacles.
 * <p>
 * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
 * <p>
 * If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.)
 * <p>
 * Return the square of the maximum Euclidean distance that the robot will be from the origin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: commands = [4,-1,3], obstacles = []
 * Output: 25
 * Explanation: robot will go to (3, 4)
 * Example 2:
 * <p>
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * Output: 65
 * Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * The answer is guaranteed to be less than 2 ^ 31.
 */
public class WalkingRobotSimulation {
    private static final int FACE_NORTH=0;
    private static final int FACE_EAST=1;
    private static final int FACE_SOUTH=2;
    private static final int FACE_WEST=3;

    class Cord{
        int x;
        int y;

        Cord(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int hashCode() {
            int hash = 17;
            hash = hash * 31 + x;
            hash = hash * 31 + y;
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            return this.x == ((Cord) o).x && this.y == ((Cord) o).y;
        }
    }

    private Set convertArrayToSet(int[][] obstacles){
        Set<Cord> set=new HashSet<>();
        for(int[] obstacle:obstacles){
            set.add(new Cord(obstacle[0],obstacle[1]));
        }
        return set;
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        int face=FACE_NORTH;
        int x=0;
        int y=0;
        int max=0;

        Set<Cord> set=convertArrayToSet(obstacles);

        for(int c:commands){
            if(c==-1){
                face++;
                if(face>FACE_WEST){
                    face=FACE_NORTH;
                }
            }else if(c==-2){
                face--;
                if(face<FACE_NORTH){
                    face=FACE_WEST;
                }
            }else{
                int[] position= move(face,x,y,set,c);
                x=position[0];
                y=position[1];
                int dis=x*x+y*y;
                if(max<dis){
                    max=dis;
                }
            }
        }

        return max;
    }

    private boolean isBlocked(int x, int y,Set<Cord> set) {
        return (set.contains(new Cord(x,y)));
    }

    private int[] move(int face, int x, int y, Set<Cord> set, int unit) {
        int step = 0;
        boolean blocked = false;
        while (!blocked && step < unit) {
            switch (face) {
                case FACE_NORTH: {
                    if (!isBlocked(x, y + 1, set)) {
                        y++;
                    } else {
                        blocked = true;
                    }
                    break;
                }
                case FACE_SOUTH: {
                    if (!isBlocked(x, y - 1, set)) {
                        y--;
                    } else {
                        blocked = true;
                    }
                    break;
                }
                case FACE_EAST: {
                    if (!isBlocked(x + 1, y, set)) {
                        x++;
                    } else {
                        blocked = true;
                    }
                    break;
                }
                case FACE_WEST: {
                    if (!isBlocked(x - 1, y, set)) {
                        x--;
                    } else {
                        blocked = true;
                    }
                    break;
                }

            }


            step++;
        }
        return new int[]{x, y};
    }


}

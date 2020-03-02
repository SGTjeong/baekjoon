import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon1726 {
    static int M, N;
    static int [][]map;
    static boolean [][][]visited;

    static int startX, startY, startD;
    static int endX, endY, endD;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []line = br.readLine().split(" ");
        M = Integer.parseInt(line[0]); N = Integer.parseInt(line[1]);
        map = new int[M][N];
        visited = new boolean[M][N][4];

        for(int i=0; i<M; i++){
            line = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        line = br.readLine().split(" ");
        startX = Integer.parseInt(line[0])-1; startY = Integer.parseInt(line[1])-1; startD = Integer.parseInt(line[2])-1;
        line = br.readLine().split(" ");
        endX = Integer.parseInt(line[0])-1; endY = Integer.parseInt(line[1])-1; endD = Integer.parseInt(line[2])-1;

        System.out.println(BFS());
    }

    public static int BFS(){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY, startD));
        visited[startX][startY][startD] = true;

        int cnt = 0;

        while(!queue.isEmpty()){
            //System.out.println(cnt+"---------------");
            int qsize = queue.size();
            for(int size=0; size<qsize; size++){
                Point location = queue.poll();
              //  System.out.println((location.x+1)+","+(location.y+1)+","+(location.dir+1));

                if(location.x == endX && location.y == endY && location.dir == endD) return cnt;
                //방향회전
                if(isSouthOrNorth(location.dir)){
                    if(!visited[location.x][location.y][EAST]){
                        visited[location.x][location.y][EAST] = true;
                        queue.add(new Point(location.x, location.y, EAST));
                //        System.out.println("-->" + (location.x+1)+","+(location.y+1)+","+(EAST+1));
                    }
                    if(!visited[location.x][location.y][WEST]){
                        visited[location.x][location.y][WEST] = true;
                        queue.add(new Point(location.x, location.y, WEST));
                  //      System.out.println("-->" + (location.x+1)+","+(location.y+1)+","+(WEST+1));
                    }
                }

                else{
                    if(!visited[location.x][location.y][SOUTH]){
                        visited[location.x][location.y][SOUTH] = true;
                        queue.add(new Point(location.x, location.y, SOUTH));
                   //     System.out.println("-->" + (location.x+1)+","+(location.y+1)+","+(SOUTH+1));
                    }
                    if(!visited[location.x][location.y][NORTH]){
                        visited[location.x][location.y][NORTH] = true;
                        queue.add(new Point(location.x, location.y, NORTH));
                     //   System.out.println("-->" + (location.x+1)+","+(location.y+1)+","+(NORTH+1));
                    }
                }

                for(int i = 1; i <= 3; i++) {
                    int newX = moveX[direction(location.dir)]*i + location.x;
                    int newY = moveY[direction(location.dir)]*i + location.y;
                    if(newX<0||newX>=M||newY<0||newY>=N) continue;
                    if(map[newX][newY]==1) break;
                    if(visited[newX][newY][location.dir]) continue;

                    visited[newX][newY][location.dir] = true;
                    queue.add(new Point(newX, newY, location.dir));
                    //System.out.println("-->" + (newX+1)+","+(newY+1)+","+(location.dir+1));
                    //System.out.println((location.x+1) +"," + (location.y+1) + "," + (location.dir+1) + " to " + (newX+1) + "," + (newY+1) + "," + (location.dir+1));
                }

            }
            cnt++;
        }
        return -1;
    }



    static int []moveX = {1,-1,0,0};
    static int []moveY = {0,0,1,-1};

    static final int MOVE_TO_SOUTH = 0;
    static final int MOVE_TO_NORTH = 1;
    static final int MOVE_TO_EAST = 2;
    static final int MOVE_TO_WEST = 3;

    static final int EAST = 0;
    static final int WEST = 1;
    static final int SOUTH = 2;
    static final int NORTH = 3;


    public static boolean isSouthOrNorth(int dir){
        if(dir == SOUTH || dir == NORTH) return true;
        else return false;
    }

    public static int direction(int dir){
        if(dir == EAST) return MOVE_TO_EAST;
        else if(dir == WEST) return MOVE_TO_WEST;
        else if(dir == SOUTH) return MOVE_TO_SOUTH;
        else return MOVE_TO_NORTH;
    }

    public static class Point{
        int x, y, dir;
        public Point(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon1194 {
    static char [][] map;
    static boolean [][][] visited;
    static int x, y;

    static int res;
    static int startX, startY;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []line = br.readLine().split(" ");

        x = Integer.parseInt(line[0]); y = Integer.parseInt(line[1]);
        map = new char[x][y];
        visited = new boolean[x][y][64];

        for(int i=0; i<x; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<y; j++){
                if(map[i][j]=='0'){
                    startX=i;
                    startY=j;
                }
            }
        }

        System.out.println(BFS());
    }

    public static int BFS(){
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(startX, startY, 0));
        visited[startX][startY][0] = true;
        res = 0;

        while(!queue.isEmpty()){
            for(int size = 0; size < queue.size(); size++){
                Point location = queue.poll();
                if(map[location.x][location.y]=='1') return res;

                for(int i=0; i<4; i++){
                    int newX = location.x + moveX[i];
                    int newY = location.y + moveY[i];
                    int key = location.key;

                    if(newX>=0&&newX<x&newY>=0&&newY<y){
                        if(map[newX][newY]=='#') continue;
                        if ('a' <= map[newX][newY] && map[newX][newY] <= 'f') {
                            key |= (1 << map[newX][newY] - 'a');
                        }
                        if ('A' <= map[newX][newY] && map[newX][newY] <= 'F') {
                            if ((key & (1 << (map[newX][newY] - 'A'))) == 0) {
                                continue;
                            }
                        }
                        if (visited[newX][newY][key]) {
                            continue;
                        }

                        visited[newX][newY][key] = true;
                        queue.add(new Point(newX, newY, key));
                    }
                }
            }
            res++;
        }
        return -1;
    }

    static int []moveX = {1,-1,0,0};
    static int []moveY = {0,0,1,-1};

    public static class Point{
        int x, y, key;
        public Point(int x, int y, int key){
            this.x = x;
            this.y = y;
            this.key = key;
        }
    }
}

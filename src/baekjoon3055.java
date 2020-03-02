import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon3055 {
    static int R, C;
    static int startX, startY, endX, endY;
    static char [][]map;
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); C= Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<C; j++){
                if(map[i][j]=='D'){endX = i; endY = j;}
                else if(map[i][j]== 'S') {startX = i; startY = j;}
            }
        }
        BFS();
    }

    static int moveX[] = {1,-1,0,0};
    static int moveY[] = {0,0,1,-1};

    static void fill(){
        boolean [][]visitedWater = new boolean[R][C];
        for(int i=0; i<R; i++)
            for(int j=0; j<C; j++){
                if(!visitedWater[i][j] && map[i][j]=='*') DFS(i,j,visitedWater);
            }

        /*
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }

         */
    }

    static void DFS(int r, int c, boolean [][]visitedWater){
        visitedWater[r][c] = true;
        for(int i=0; i<4; i++){
            int newX = r + moveX[i];
            int newY = c + moveY[i];
            if(newX>=0&&newX<R&&newY>=0&&newY<C){
                if(map[newX][newY]=='.' || map[newX][newY]=='S'){
                    map[newX][newY]='*'; visitedWater[newX][newY] = true;
                }
            }
        }
    }

    static void BFS(){
        boolean [][]visited = new boolean[R][C];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY));
        visited[startX][startY] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            cnt++;
            fill();
            int qsize = q.size();
            while(qsize-->0){
                Point p = q.poll();
                //System.out.println(p.x+","+p.y);
                for(int i=0; i<4; i++){
                    int newX = p.x + moveX[i];
                    int newY = p.y + moveY[i];
                    if(newX>=0&&newX<R&&newY>=0&&newY<C){
                        if(map[newX][newY]!='*' && map[newX][newY]!='X'&&!visited[newX][newY]){
                            if(newX == endX && newY == endY){
                                System.out.println(cnt);
                                return;
                            }
                            visited[newX][newY] = true;
                            q.add(new Point(newX,newY));
                        }
                    }
                }
            }
        }

        System.out.println("KAKTUS");
        return ;
    }

    static class Point{
        int x ,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

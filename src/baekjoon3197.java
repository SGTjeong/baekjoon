import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class baekjoon3197 {
    static int M, N;
    static char[][]map;
    static int [][]time;
    static boolean[][]visited;
    static int X1, X2, Y1, Y2;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []line = br.readLine().split(" ");
        M = Integer.parseInt(line[0]); N = Integer.parseInt(line[1]);
        map = new char[M][N];
        time = new int[M][N];
        int [][]loc = new int [2][2];

        int k = 0;
        for(int i=0; i<M; i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                if(map[i][j]=='L'){
                    loc[k][0] = i;
                    loc[k][1] = j;
                    k++;
                }
            }
        }
        X1 = loc[0][0]; X2 = loc[1][0]; Y1 = loc[0][1]; Y2 = loc[1][1];

        melt();

/*
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                System.out.print(time[i][j] + " ");
            }
            System.out.println("");
        }

  */      System.out.println(check());
    }

    public static void melt(){
        visited = new boolean[M][N];
        Queue<Point> queue = new LinkedList<>();

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]=='L' || map[i][j]=='.'){
                    queue.add(new Point(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            for(int size=0; size<queue.size(); size++){
                Point location = queue.poll();
                for(int i=0; i<4; i++){
                    int newX = location.x + moveX[i];
                    int newY = location.y + moveY[i];
                    if(newX<0||newX>=M||newY<0||newY>=N) continue;
                    if(visited[newX][newY]) continue;

                    visited[newX][newY] = true;
                    queue.add(new Point(newX, newY, location.days+1));
                    time[newX][newY] = location.days+1;
                }
            }
        }
    }

    public static int check(){
        visited = new boolean[M][N];

        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(X1, Y1, 0));
        visited[X1][Y1] = true;

        while(!queue.isEmpty()){
            Point location = queue.poll();

            if(location.x == X2 && location.y == Y2) return location.days;

            for(int i=0; i<4; i++){
                int newX = location.x + moveX[i];
                int newY = location.y + moveY[i];

                if(newX<0||newX>=M||newY<0||newY>=N) continue;
                if(visited[newX][newY]) continue;

                queue.add(new Point(newX, newY, Math.max(location.days, time[newX][newY])));
                visited[newX][newY] = true;
            }
        }

        return -1;
    }

    static int []moveX = {1,-1,0,0};
    static int []moveY = {0,0,1,-1};

    public static class Point implements  Comparable<Point>{
        int x, y, days;
        public Point(int x, int y, int days){
            this.x = x;
            this.y = y;
            this.days = days;
        }

        @Override
        public int compareTo(Point o) {
            return this.days>o.days?1:-1;
        }
    }


}

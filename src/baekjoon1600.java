import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon1600 {

    static int K, M, N;
    static int map[][];
    static boolean visited[][][];
    public static void main(String []args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        String []line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]); M = Integer.parseInt(line[1]);

        map = new int[M][N];
        visited = new boolean[M][N][K+1];

        for(int i=0; i<M; i++){
            line = br.readLine().split(" ");
            for(int j=0; j<N; j++)
                map[i][j] = Integer.parseInt(line[j]);
        }

        System.out.println(BFS());
    }

    public static int BFS(){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, K));
        visited[0][0][K] = true;

        int res = 0;

        while(!queue.isEmpty()){
                int qsize = queue.size();

                for(int size=0; size<qsize; size++){
                    Point location = queue.poll();
                    //System.out.println(location.x + "," + location.y + ", " + location.k);
                    if(location.x == M-1 && location.y == N-1) return res;

                    for(int i=0; i<4; i++){
                        int newX = location.x + moveX[i];
                        int newY = location.y + moveY[i];

                        if(newX<0||newX>=M||newY<0||newY>=N) continue;
                        if(map[newX][newY]==1) continue;
                        if(visited[newX][newY][location.k]) continue;


                        queue.add(new Point(newX, newY, location.k));
                        visited[newX][newY][location.k] = true;
                    }

                    if(location.k>0){
                        for(int i=4; i<12; i++){
                            int newX = location.x + moveX[i];
                            int newY = location.y + moveY[i];

                            if(newX<0||newX>=M||newY<0||newY>=N) continue;
                            if(map[newX][newY]==1) continue;
                            if(visited[newX][newY][location.k-1]) continue;

                            queue.add(new Point(newX, newY, location.k-1));
                            visited[newX][newY][location.k-1] = true;
                        }
                    }
            }
            res++;
        }

        return -1;
    }


    static int[] moveX = {0,0,1,-1,-2,-1,1,2,2,1,-1,-2};
    static int[] moveY = {1,-1,0,0,1,2,2,1,-1,-2,-2,-1};


    public static class Point{
        int x, y, k;

        public Point(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
}

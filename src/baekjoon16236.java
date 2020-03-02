import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon16236 {
    static int N;
    static int [][]map;
    static int curSize = 2;
    static int curStack = 0;
    static int startX, startY;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    map[i][j] = -1;
                    startX = i; startY = j;
                }
            }
        }

        int time = 0;
        //check
        while(true){
            int res = BFS(startX, startY);
            if(res<0) break;
            else {
              // System.out.println(res);
                if(curStack==curSize){
                    curStack=0;
                    curSize++;
                }
                time += res;
            }
        }

        System.out.println(time);
    }

    static boolean [][]visited;
    static int moveX[] = {-1,0,0,1};
    static int moveY[] = {0,-1,1,0};

    static int BFS(int x, int y){
        visited = new boolean[N][N];
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(x, y, 0));
        visited[x][y] = true;

        while(!q.isEmpty()){
            int qsize = q.size();
            while(qsize-->0){
                Point p = q.poll();
                if(map[p.x][p.y]<curSize && map[p.x][p.y]>0){
                    map[x][y]=0;
                    map[p.x][p.y]=-1;
                    startX = p.x; startY = p.y;
                    curStack++;
                    return p.cnt;
                }

                int cnt = p.cnt;
                for(int i=0; i<4; i++){
                    int rx = p.x+moveX[i];
                    int ry = p.y+moveY[i];
                    if(rx>=0&&rx<N&&ry>=0&&ry<N&&!visited[rx][ry]&&map[rx][ry]<=curSize){
                        visited[rx][ry]=true;
                        q.add(new Point(rx,ry, cnt+1));
                    }
                }
            }
        }

        return -1;
    }

    static class Point implements Comparable<Point>{
        int x,y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            if(cnt > o.cnt) return 1;
            else if(cnt < o.cnt) return -1;

            if(x > o.x) return 1;
            else if(x < o.x) return -1;
            else{
                if(y > o.y) return 1;
                else return -1;
            }
        }
    }
}

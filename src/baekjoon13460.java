import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon13460 {
    static int N, M;
    static char [][]map;
    static boolean [][]visited;
    static Queue<Point> queue;
    static int redX, redY, blueX, blueY, holeX, holeY;

    public static void main(String []args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new char[N][M]; visited = new boolean[N][M];
        queue = new LinkedList<>();

        for(int i=0; i<N ;i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(map[i][j]=='R'){
                    redX = i;
                    redY = j;
                }
                else if(map[i][j]=='B'){
                    blueX = i;
                    blueY = j;
                }
                else if(map[i][j]=='O'){
                    holeX = i;
                    holeY = j;
                }
            }
        }

        //System.out.println(holeX + ", " +holeY);

        System.out.println(BFS());
    }

    public static int BFS(){
        queue.add(new Point(redX, redY, blueX, blueY));
        int cnt = 0;

        while(!queue.isEmpty()&&cnt<=10){
            int qsize = queue.size();
            for(int i=0; i<qsize; i++){
                Point location = queue.poll();
          //      System.out.println(location.rX+","+location.rY+","+location.bX+","+location.bY);
                if(location.rX==holeX&&location.rY==holeY) return cnt;
                if(location.bX==holeX&&location.bY==holeY) continue;
                move(location);
            }
            cnt++;
        }

        return -1;
    }

    public static void move(Point location){
        int rX = location.rX; int rY = location.rY; int bX = location.bX; int bY = location.bY;

        while(rX>0){
            if(map[rX][rY]=='O') break;
            if(map[rX-1][rY]!='#') rX--;
            else break;
        }
        while(bX>0){
            if(map[bX][bY]=='O') break;
            if(map[bX-1][bY]!='#') bX--;
            else break;
        }

        if(rX==bX&&rY==bY) {
            if (map[rX][rY] != 'O') {
                if(location.rX<location.bX) bX++;
                else rX++;
                queue.add(new Point(rX, rY, bX, bY));
            }
        }

        else queue.add(new Point(rX, rY, bX, bY));
        //System.out.println(rX+","+rY+","+bX+","+bY+"a");
        rX = location.rX; rY = location.rY; bX = location.bX; bY = location.bY;

        while(rX<N-1){
            if(map[rX][rY]=='O') break;
            if(map[rX+1][rY]!='#') rX++;
            else break;
        }

        while(bX<N-1){
            if(map[bX][bY]=='O') break;
            if(map[bX+1][bY]!='#') bX++;
            else break;
        }

        if(rX==bX&&rY==bY) {
            if (map[rX][rY] != 'O') {
                if(location.rX<location.bX) rX--;
                else bX--;
                queue.add(new Point(rX, rY, bX, bY));
            }
        }
        else queue.add(new Point(rX, rY, bX, bY));

        //System.out.println(rX+","+rY+","+bX+","+bY+"b");
        rX = location.rX; rY = location.rY; bX = location.bX; bY = location.bY;

        while(rY>0){
            if(map[rX][rY]=='O') break;
            if(map[rX][rY-1]!='#') rY--;
            else break;
        }

        while(bY>0){
            if(map[bX][bY]=='O') break;
            if(map[bX][bY-1]!='#') bY--;
            else break;
        }

        if(rX==bX&&rY==bY) {
            if (map[rX][rY] != 'O') {
                    if(location.rY<location.bY) bY++;
                else rY++;
                queue.add(new Point(rX, rY, bX, bY));
            }
        }
        else queue.add(new Point(rX, rY, bX, bY));

        //System.out.println(rX+","+rY+","+bX+","+bY+"c");
        rX = location.rX; rY = location.rY; bX = location.bX; bY = location.bY;

        while(rY<M-1){
            if(map[rX][rY]=='O') break;
            if(map[rX][rY+1]!='#') rY++;
            else break;
        }

        while(bY<M-1){
            if(map[bX][bY]=='O') break;
            if(map[bX][bY+1]!='#') bY++;
            else break;
        }

        if(rX==bX&&rY==bY) {
            if (map[rX][rY] != 'O') {
                if(location.rY<location.bY) rY--;
                else bY--;
                queue.add(new Point(rX, rY, bX, bY));
            }
        }
        else queue.add(new Point(rX, rY, bX, bY));
        //System.out.println(rX+","+rY+","+bX+","+bY+"d");
    }

    public static class Point{
        int rX, rY, bX, bY;

        public Point(int rX, int rY, int bX, int bY) {
            this.rX = rX;
            this.rY = rY;
            this.bX = bX;
            this.bY = bY;
        }
    }
}

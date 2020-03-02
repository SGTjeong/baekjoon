import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon6593 {
    static int L, R, C;
    static char [][][]building;
    static boolean [][][]visited;
    static int [][][]dist;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();
            if(str.length() == 0) str = br.readLine();
            String[] LRC = str.split(" ");
            L = Integer.parseInt(LRC[0]);
            R = Integer.parseInt(LRC[1]);
            C = Integer.parseInt(LRC[2]);

            if(L==0&&R==0&&C==0) break;
            building = new char[L][R][C];
            visited = new boolean[L][R][C];
            dist = new int[L][R][C];
            int startX=0; int startY=0; int startZ=0;

            /*
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = line.charAt(k);
                        if (line.charAt(k) == 'S') {
                            startX = i;
                            startY = j;
                            startZ = k;
                            dist[i][j][k]=0;
                        }
                    }
                }

                br.readLine();
            }
            */

            for(int k=0; k<building.length; k++) {
                for(int i=0; i<building[0].length; i++) {
                    char[] arr = br.readLine().toCharArray();
                    if(arr.length == 0) arr = br.readLine().toCharArray();
                    for(int j=0; j<building[0][0].length; j++) {
                        building[k][i][j] = arr[j];
                        //'S'이면 시작점을 정해준다. 입력을 해주면서 설정해야 불필요한 연산이 없다.
                        if(building[k][i][j] == 'S') {
                            startX = k;
                            startY = i;
                            startZ = j;
                        }
                    }
                }
            }
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(startX, startY, startZ));
            visited[startX][startY][startZ] = true;
            boolean trapped = true;
            int time = 0;

            while (!queue.isEmpty() ) {
                Point point = queue.poll();
                if (building[point.x][point.y][point.z] == 'E') {
                    trapped = false;
                    time = dist[point.x][point.y][point.z];
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int newX = point.x + moveX[i];
                    int newY = point.y + moveY[i];
                    int newZ = point.z + moveZ[i];
                    if (newX >= 0 && newY >= 0 && newZ >= 0 && newX < L && newY < R && newZ < C)
                        if (visited[newX][newY][newZ] == false && (building[newX][newY][newZ]!='#')){
                            queue.add(new Point(newX, newY, newZ));
                            dist[newX][newY][newZ] = dist[point.x][point.y][point.z] + 1;
                            visited[newX][newY][newZ]=true;
                        }
                }
            }

            if (trapped) System.out.println("Trapped!");
            else System.out.println("Escaped in " + time + " minute(s).");
        }
    }

    static int []moveX = {1,-1,0,0,0,0};
    static int []moveY = {0,0,1,-1,0,0};
    static int []moveZ = {0,0,0,0,1,-1};

    static class Point{
        int x,y,z;
        public Point(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}

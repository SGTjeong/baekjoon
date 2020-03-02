import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon3184 {
    public final static char FIELD = '.';
    public final static char FENCE = '#';
    public final static char SHEEP = 'o';
    public final static char WOLF = 'v';

    static int R,C;
    static char[][]map;
    static boolean [][]visited;
    static int wolfCnt, sheepCnt, totalWolfCnt, totalSheepCnt;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []lines;
        lines = br.readLine().split(" ");
        R = Integer.parseInt(lines[0]);
        C = Integer.parseInt(lines[1]);

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            String line = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(!visited[i][j] && (map[i][j] == SHEEP || map[i][j] == WOLF)){
                    wolfCnt = 0;
                    sheepCnt =0;
                    DFS(i, j);
                    if(sheepCnt <= wolfCnt) totalWolfCnt += wolfCnt;
                    else totalSheepCnt += sheepCnt;
                }
            }
        }

        System.out.println(totalSheepCnt + " " + totalWolfCnt);
    }

    static int []moveX = {1,-1,0,0};
    static int []moveY = {0,0,1,-1};

    public static void DFS(int row, int col){
        visited[row][col] = true;
        if(map[row][col]==WOLF) wolfCnt++;
        else if(map[row][col]==SHEEP) sheepCnt++;

        for(int i=0; i<4; i++){
            int nrow = row + moveX[i];
            int ncol = col + moveY[i];
            if(nrow>=0&&nrow<R&&ncol>=0&&ncol<C)
                if(map[nrow][ncol]!=FENCE && visited[nrow][ncol]==false) DFS(nrow, ncol);
        }
    }
}

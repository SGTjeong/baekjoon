import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1987 {
    static int R, C;
    static int [][]map;
    static int max;
    static boolean [][]visited;
    static boolean []occupied;

    public static void main(String []args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        map = new int[21][21];
        visited = new boolean[21][21];
        occupied = new boolean[26];
        max = 1;

        for(int i=1; i<=R; i++){
            char []tmp = br.readLine().toCharArray();
            for(int j=1; j<=C; j++){
                map[i][j] = tmp[j-1] - 'A';
            }
        }

        visited[1][1] = true;
        occupied[map[1][1]] = true;
        for(int i=0; i<4; i++){
            int newX = 1 + moveX[i];
            int newY = 1 + moveY[i];

            if(newX>=1 && newX <=R && newY>=1 && newY <=C && !visited[newX][newY]){
                if(!occupied[map[newX][newY]]) DFS(newX, newY, 2);
            }
        }

        System.out.println(max);
    }

    static void DFS(int x, int y, int cnt){
        if(cnt > max) max = cnt;
        visited[x][y] = true;
        occupied[map[x][y]] = true;
        for(int i=0; i<4; i++){
            int newX = x + moveX[i];
            int newY = y + moveY[i];

            if(newX>=1 && newX <=R && newY>=1 && newY <=C && !visited[newX][newY]){
                if(!occupied[map[newX][newY]]) DFS(newX, newY, cnt+1);
            }
        }
        visited[x][y] = false;
        occupied[map[x][y]] = false;

    }

    static int moveX[] = {1,-1,0,0};
    static int moveY[] = {0,0,1,-1};
}

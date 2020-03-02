import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon11559 {
    static int [][]map;
    static boolean [][]visited;
    public static void main(String []args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        map = new int[12][6];
        for(int i=0; i<12; i++){
            String line = br.readLine();
            for(int j=0; j<6; j++){
                map[i][j] = line.charAt(j);
            }
        }

        int res = -1;

        while(changed) {
            res++;
            changed = false;
            visited = new boolean[12][6];
            fall = new int[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && map[i][j] > 0) bomb(i, j);
                }
            }
            clear();
        }

        System.out.println(res);

    }

    static int moveX[] = {1,-1,0,0};
    static int moveY[] = {0,0,1,-1};
    static int fall[][];
    static boolean changed = true;
    static int cnt = 0;

    static void bomb(int r, int c){
        cnt = 0;
        DFS(r, c, map[r][c]);
        for(int i=0; i<12; i++){
            for(int j=0; j<6; j++){
                if(map[i][j]<0){
                    if(cnt>=4){
                        map[i][j]='.';
                        for(int k = i-1; k>=0; k--) fall[k][j]++;
                    }
                    else{
                        map[i][j]*=-1;
                    }
                }
            }
        }
        if(cnt>=4) changed = true;
    }

    static void DFS(int r, int c, int COLOR){
        cnt++;
        visited[r][c] = true;
        map[r][c] *= -1;
        for(int i=0; i<4; i++){
            int nr = r + moveX[i]; int nc = c + moveY[i];
            if(nr>=0&&nr<12&&nc>=0&&nc<6&&map[nr][nc]==COLOR&&!visited[nr][nc]){
                DFS(nr, nc, COLOR);
            }
        }
    }

    static void clear(){
        for(int i=11; i>=0; i--){
            for(int j=0; j<6; j++){
                if(map[i][j]!='.' && fall[i][j]>0){
                    map[i+fall[i][j]][j] = map[i][j];
                    map[i][j]='.';
                }
            }
        }
    }
}

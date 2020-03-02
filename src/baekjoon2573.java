import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2573 {
    static int row, col;
    static int [][]map;
    static int [][]degree;
    static boolean [][]melt;
    static boolean [][]visited;
    static int year = 0;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        row = Integer.parseInt(line[0]);
        col = Integer.parseInt(line[1]);

        map = new int[row][col];
        melt = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < col; j++) map[i][j] = Integer.parseInt(line[j]);
        }

        while(true){
            year++;
            prog();
            if(isSplit()){
                System.out.println(year);
                break;
            }
            if(totallyMelt()){
                System.out.println(0);
                break;
            }
        }

    }

    static int []moveX = {1,-1,0,0};
    static int []moveY = {0,0,1,-1};

    public static void prog(){
        degree = new int[row][col];

        for(int i=0; i<row; i++)
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < 4; k++) {
                    int newX = i + moveX[k];
                    int newY = j + moveY[k];
                    if (newX < row && newX >= 0 && newY < col && newY >= 0 && map[newX][newY] == 0) {
                        degree[i][j]++;
                    }
                }
            }

        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++){
                map[i][j] -= degree[i][j];
                if(map[i][j]<0) map[i][j] = 0;
            }
    }

    public static boolean isSplit(){
        visited = new boolean[row][col];
        int cnt = 0;

        for(int i=0; i<row; i++) {
            for (int j = 0; j < col; j++){
                if(!visited[i][j] && map[i][j]>0){
                    dfs(i, j);
                    cnt++;
                    if(cnt == 2) return true;
                }
            }
        }
        return false;
    }

    public static void dfs(int r, int c){
        visited[r][c] = true;
        for (int k = 0; k < 4; k++) {
            int newX = r + moveX[k];
            int newY = c + moveY[k];
            if (newX < row && newX >= 0 && newY < col && newY >= 0 && map[newX][newY] > 0 && !visited[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }

    public static boolean totallyMelt(){
        for(int i=0; i<row; i++)
            for(int j=0; j<col; j++)
                if(map[i][j]!=0) return false;

        return true;
    }
}

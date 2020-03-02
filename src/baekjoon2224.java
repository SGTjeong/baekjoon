import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2224 {
    static int N; static boolean map[][];
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []line;
        N = Integer.parseInt(br.readLine()); map = new boolean[52][52];

        while(N-->0){
            int from, to;
            line = br.readLine().split(" ");
            if(line[0].charAt(0)>='A'&&line[0].charAt(0)<='Z') from = line[0].charAt(0) - 'A';
            else from = line[0].charAt(0) - 'a' + 26;
            if(line[2].charAt(0)>='A'&&line[2].charAt(0)<='Z') to = line[2].charAt(0) - 'A';
            else to = line[2].charAt(0) - 'a' + 26;
            map[from][to] = true;
        }

        connect();

        int cnt=0;
        for(int from=0; from<52; from++)
            for(int to=0; to<52; to++)
                if(map[from][to]&&from!=to) cnt++;
        System.out.println(cnt);

        for(int from=0; from<52; from++){
            for(int to=0; to<52; to++){
                if(map[from][to]&&from!=to){
                    char f, t;
                    if(from>=0 && from<26) f = (char)(from + 'A'); else f = (char)(from -26 + 'a');
                    if(to>=0 && to<26) t = (char)(to + 'A'); else t = (char)(to -26 + 'a');
                    System.out.println(f + " => " + t);
                }
            }
        }


    }

    static void connect(){
        for(int i=0; i<52; i++){
            boolean []visited = new boolean[52];
            visited[i] = true;
            for(int j=0; j<52; j++){
                if(!visited[j]&&map[i][j]) DFS(i, j, visited);
            }
        }
    }

    static void DFS(int pivot, int from, boolean []visited){
        //System.out.println("pviot :" + pivot + " from : " + from);
        visited[from] = true;
        for(int to=0; to<52; to++){
            if(map[from][to]&&!visited[to]){
                map[pivot][to] = true;
                DFS(pivot, to, visited);
            }
        }
    }

}

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class baekjoon2140 {
    static int N;
    static char [][]map;

    static int moveX[] = {1,-1,0,0,1,1,-1,-1};
    static int moveY[] = {0,0,1,-1,1,-1,1,-1};

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N+2][N+2];
        for(int i=1; i<=N; i++){
            char tmp[] = br.readLine().toCharArray();
            for(int j=1; j<=N; j++){
                map[i][j] = tmp[j-1];
            }
        }

        if(N<3) System.out.println(0);
        else{
            int cnt = 0;

            for(int i=2; i<N; i++){
                for(int j=2; j<N; j++){
                    boolean isBomb = true;
                    int newX, newY;
                    for(int k=0; k<8; k++){
                        newX = i + moveX[k];
                        newY = j + moveY[k];

                        if(map[newX][newY]=='#') continue;
                        if(map[newX][newY]=='0') {
                            isBomb = false;
                            break;
                        }
                    }
                    if(!isBomb) cnt++;
                    else{
                        for(int k=0; k<8; k++){
                            newX = i + moveX[k];
                            newY = j + moveY[k];
                            if(map[newX][newY]=='#' || map[newX][newY]=='0') continue;
                            map[newX][newY]--;
                        }
                    }

                }
            }
            System.out.println((N-2)*(N-2) - cnt);
        }
    }


}

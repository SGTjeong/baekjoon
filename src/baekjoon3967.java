import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon3967 {
    static int []seq;
    static int []node;
    static boolean []occupied;
    static boolean isFound = false;
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        seq = new int[25];
        occupied = new boolean[13];
        node = new int[13];
        int cnt = 1;

        for(int i=0; i<5; i++){
            char []arr = br.readLine().toCharArray();
            for(int j=0; j<9; j++){
                if(arr[j]=='.') continue;
                if(arr[j]=='x'){
                    node[cnt]=0;
                    cnt++;
                }
                else{
                    node[cnt]=arr[j]-'A'+1;
                    occupied[arr[j]-'A'+1]=true;
                    cnt++;
                }
            }
        }

        proc(1);
    }

    static void proc(int index){
        if(isFound) return;
        if(index>12){
            if(check()){
                isFound = true;
                int i=1;
                System.out.println("...." + (char)(node[i++]+'A'-1) + "....");
                System.out.println("."+(char)(node[i++]+'A'-1) + "." +(char)(node[i++]+'A'-1) + "." + (char)(node[i++]+'A'-1) + "." + (char)(node[i++]+'A'-1) + ".");
                System.out.println(".."+(char)(node[i++]+'A'-1)+"..."+(char)(node[i++]+'A'-1)+"..");
                System.out.println("."+(char)(node[i++]+'A'-1) + "." +(char)(node[i++]+'A'-1) + "." + (char)(node[i++]+'A'-1) + "." + (char)(node[i++]+'A'-1) + ".");
                System.out.println("...." + (char)(node[i++]+'A'-1) + "....");
            }
            return;
        }

        if(node[index]!=0){

            proc(index+1);
            return;
        }

        for(int alphabet=1; alphabet<=12; alphabet++){
            if(!occupied[alphabet]) {
                occupied[alphabet] = true;
                node[index] = alphabet;
                proc(index+1);
                occupied[alphabet] = false;
                node[index] = 0;
            }
        }
    }


    static boolean check(){
        for(int i=1; i<=12; i++){
            seq[input[i][0]] = node[i]; seq[input[i][1]] = node[i];
        }

        for(int i=1; i<6; i++){
            if(seq[1]+seq[2]+seq[3]+seq[4]==seq[1+4*i]+seq[2+4*i]+seq[3+4*i]+seq[4+4*i]) continue;
            else return false;
        }

        return true;
    }

    static int [][]input = {
            {0, 0},
            {1, 12},
            {13, 24},
            {2, 23},
            {11, 22},
            {20, 21},
            {3, 14},
            {10, 19},
            {4, 5},
            {6, 15},
            {7, 18},
            {8, 9},
            {16, 17}
    };

}

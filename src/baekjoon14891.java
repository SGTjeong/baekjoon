import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon14891 {
    static LinkedList<Integer> gear[];
    static int K;
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new LinkedList[4];
        for(int i=0; i<4; i++){
            gear[i] = new LinkedList<>();
            char line[] =br.readLine().toCharArray();
            for(int j=0; j<8; j++){
                gear[i].add(line[j]-'0');
            }
        }

        K = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            rotate(index-1, direction, BOTH);
        }

        int sum = 0;
        int grade = 1;

        for(int i=0; i<4; i++){
            if(gear[i].get(0)==1) sum+=grade;
            grade *= 2;
        }

        System.out.println(sum);
    }

    static final int BOTH = 0;
    static final int LEFT = 1;
    static final int RIGHT = 2;

    static void rotate(int index, int direction, int effect){
       int leftIndex = index-1;
       int rightIndex = index+1;

       if(leftIndex>=0&&effect!=RIGHT){
           if(gear[leftIndex].get(2)!=gear[index].get(6)){
                rotate(leftIndex, direction*(-1), LEFT);
           }
       }

       if(rightIndex<=3&&effect!=LEFT){
            if(gear[rightIndex].get(6)!=gear[index].get(2)){
                rotate(rightIndex, direction*(-1), RIGHT);
            }
       }

       if(direction == 1){
           gear[index].addFirst(gear[index].removeLast());
       }

       else{
           gear[index].addLast(gear[index].removeFirst());
       }
    }
}

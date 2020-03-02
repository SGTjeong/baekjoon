import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class baekjoon1467 {
    static LinkedList<Integer> sequence;
    public static void main(String []args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        char []arrChar = br.readLine().toCharArray();
        sequence = new LinkedList<>();
        for(int i = 0; i < arrChar.length; i++) sequence.add(arrChar[i] - '0');

        arrChar = br.readLine().toCharArray();
        int []arrQuery = new int[arrChar.length];
        for(int i=0; i<arrChar.length; i++){
            arrQuery[i] = arrChar[i]-'0';

        }

        Arrays.sort(arrQuery);
        for(int i=0; i<arrQuery.length; i++){
            remove(arrQuery[i]);
        }

        for(int i : sequence) System.out.print(i);
    }

    static void remove(int num){
        int index = -1;
        for(int i = 0; i < sequence.size()-1; i++){
            if(sequence.get(i)==num){
                if(sequence.get(i+1)>num){
                    sequence.remove(i);
                    return;
                }
                else if(sequence.get(i+1)<=num){
                    index = i;
                }
            }
        }

        if(sequence.get(sequence.size()-1)==num) index = sequence.size()-1;
        sequence.remove(index);
    }
}



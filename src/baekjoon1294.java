import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon1294 {
    static Queue<Integer> q[];
    static String list[];
    static int N;

    public static void main(String []args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        q = new Queue[20];
        list = new String[20];
        int itemCnt = 0;

        for(int i=0; i<N; i++){
            q[i] = new LinkedList<>();
            list[i] = br.readLine();
            char []line = list[i].toCharArray();
            for(int j=0; j<line.length; j++){
                q[i].add((int)line[j]);
                itemCnt++;
            }
        }

        while(itemCnt > 0){
            int index = choose();
            int num =q[index].poll();
            System.out.print((char)(num));
            list[index] = list[index].substring(1, list[index].length());
            itemCnt--;
        }


    }

    static int choose(){
        int index = -1;
        int curChar = 'Z'+1;
        for(int i=0; i<N; i++){
            if(q[i].size()==0) continue;

            if(q[i].peek()<curChar){
                index = i;
                curChar = q[i].peek();
            }
            else if(q[i].peek()==curChar){
                //System.out.println(list[i] + " vs" + list[index]);
                //System.out.println(list[i].compareTo(list[index]));
                if(list[index].length()==1){
                    index = i;
                }

                else if(list[i].length()==1){
                    continue;
                }

                if(compare(list[i], list[index])<0){
                    index = i;
                }
            }
        }
        return index;
    }

    static int compare(String s1, String s2){
        int size1 = s1.length(); int size2 = s2.length();
        if(size1>size2){
            String tmp = s1.substring(0, size2);
            if(tmp.compareTo(s2)!=0){
                return tmp.compareTo(s2);
            }
            else return -2;
        }

        else if(size1<size2){
            String tmp = s2.substring(0, size1);
            if(s1.compareTo(tmp)!=0){
                return s1.compareTo(tmp);
            }
            else return 2;
        }

        else{
            return s1.compareTo(s2);
        }
    }
}

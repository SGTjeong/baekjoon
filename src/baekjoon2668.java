import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon2668 {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int []pair = new int[N+1];
        int []cnt = new int[N+1];
        LinkedList<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        for(int i=1; i<=N; i++){
            pair[i] = Integer.parseInt(br.readLine());
            list.add(i);
            set.add(pair[i]);
            cnt[pair[i]]++;
        }

        boolean done = false;
        while(!done){
            done = true;
            Iterator<Integer> itr = list.iterator();
            while(itr.hasNext()){
                int num = itr.next();

                if(!set.contains(num)){
                    done = false;
                    itr.remove();
                    cnt[pair[num]]--;
                    if(cnt[pair[num]]==0) set.remove(pair[num]);
                }
            }

        }

        Collections.sort(list);
        System.out.println(list.size());
        Iterator<Integer> itr= list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}

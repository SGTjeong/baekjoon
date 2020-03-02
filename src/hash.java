import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class hash {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /**
         *  주문 line 수
         */
        int queryNum = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        while(queryNum-->0){
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            while(st.hasMoreTokens()){
                /**
                 *  이름 + 음식 set에 넣어줌
                 */
                set.add(name + " " + st.nextToken());
            }
        }

        HashMap<String, Integer> map = new HashMap<>();
        for(String s : set){
            /**
             *  String s = Name Food
             */
            String name = s.split(" ")[0];
            if(map.get(name)==null){
                map.put(name, 1);
            }
            else{
                int curNum = map.get(name);
                map.put(name, curNum+1);
            }
        }

        LinkedList<Person> res = new LinkedList<>();

        for(String s : map.keySet()) res.add(new Person(s, map.get(s)));
        Collections.sort(res);

        int max = res.get(0).item;
        for(Person p : res){
            if(max!=p.item) break;
            System.out.print(p.name + " ");
        }

    }

    static class Person implements  Comparable<Person>{
        String name; int item;

        public Person(String name, int item) {
            this.name = name;
            this.item = item;
        }

        @Override
        public int compareTo(Person o) {
            if(item > o.item) return -1;
            else if(item < o.item) return 1;
            else{
                return name.compareTo(o.name);
            }
        }
    }
}

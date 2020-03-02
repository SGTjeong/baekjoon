import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class baekjoon11279 {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> queue = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int command = Integer.parseInt(br.readLine());

            if(command == 0){
                if(queue.isEmpty()) System.out.println("0");
                else System.out.println(queue.poll().element);
            }

            else{
                queue.add(new Node(command));
            }
        }

    }

    public static class Node implements Comparable<Node>{
        int element;

        public Node(int element) {
            this.element = element;
        }

        @Override
        public int compareTo(Node o) {
            return element>o.element?-1:1;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon1504 {
    static int N, M;
    static LinkedList<Edge> relation[];
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        relation = new LinkedList[N+1];
        for(int i=1; i<=N; i++) relation[i] = new LinkedList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken()); int c = Integer.parseInt(st.nextToken());
            relation[a].add(new Edge(b,c));
            relation[b].add(new Edge(a,c));
        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());

        int p1 = dijkstra(1, A);
        int p2 = dijkstra(N, B);

        int p11 = dijkstra(1, B);
        int p22 = dijkstra(N, A);

        int p3 = dijkstra(A, B);

        //System.out.println(p1 + ", " +p2 +", "+p11+", "+p22 +", "+p3);
        if(p1!=-1&&p2!=-1&&p11!=-1&&p22!=-1&&p3!=-1){
            System.out.println(Math.min(p1+p2, p11+p22) + p3);
        }
        else if(p1!=-1&&p2!=-1&&p3!=-1){
            System.out.println(p1+p2+p3);
        }
        else if(p11!=-1&&p22!=-1&&p3!=-1){
            System.out.println(p11+p22+p3);
        }
        else{
            System.out.println(-1);
        }
    }

    static int dijkstra(int start, int destination){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean visited[] = new boolean[N+1];

        queue.add(new Node(start, 0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(visited[node.index]) continue;

            if(node.index == destination) return node.dist;
            visited[node.index] = true;

            if(node.index == destination) return node.dist;
            for(Edge edge : relation[node.index]){
                if(!visited[edge.to]){
                    int distance = node.dist + edge.weight;
                    queue.add(new Node(edge.to, distance));
                }
            }
        }

        return -1;
    }

    static class Node implements Comparable<Node>{
        int index, dist;
        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return dist > o.dist ? 1 : -1;
        }
    }

    static class Edge{
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}

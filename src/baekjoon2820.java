import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class baekjoon2820{
    static int N, M;
    static boolean [][]relation;
    static int []salary;
    static boolean []visited;
    static ArrayList<Integer>[]sibiling;

    static int[]startIndex;
    static int[]endIndex;
    static long[]tree;
    static int treeIndex = 0;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line[] = br.readLine().split(" ");
        N = Integer.parseInt(line[0]); M = Integer.parseInt(line[1]);

        relation = new boolean[N+1][N+1];
        salary = new int[N+1];
        visited = new boolean[N+1];
        sibiling = new ArrayList[N+1];

        startIndex = new int[N+1];
        endIndex = new int[N+1];
        tree = new long[N+1];

        salary[1] = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=2; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            salary[i] = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());

            if(sibiling[parent] == null) sibiling[parent] = new ArrayList<>();
            sibiling[parent].add(i);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            if(st.nextToken().charAt(0)=='u'){
                int target = Integer.parseInt(st.nextToken());
                sb.append(tree[startIndex[target]]+"\n");
            }
            else{
                int senior = Integer.parseInt(st.nextToken());
                int updateDegree = Integer.parseInt(st.nextToken());
                update(senior, updateDegree);
            }
        }

        System.out.println(sb.toString());
    }

    public static void update(int target, int updateDegree){
        for(int i=startIndex[target]+1; i<=endIndex[target]; i++)
            tree[i] += updateDegree;
    }

    public static void dfs(int index){
        startIndex[index] = ++treeIndex;
        //System.out.println("index : " + index + ", treeStartIndex : " + treeIndex);
        tree[treeIndex] = salary[index];

        if(sibiling[index]!=null) {
            for (Integer child : sibiling[index])
                dfs(child);
        }
        endIndex[index] = treeIndex;
        //System.out.println("index : " + index + ", treeEndIndex : " + treeIndex);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon17825 {
    static int diceNum[];
    static int map[] ={
            0,
            2, 4, 6, 8, 10, 12, 14 ,16 ,18, 20,
            13, 16, 19, 22, 24 ,25, 22, 24, 26, 28,
            30, 28, 27, 26, 30, 35, 32, 34, 36, 38,
            40, 0
    };

    static int moveResult[][] = {
            {1, 2, 3, 4, 5},
            {2, 3, 4, 5, 6},
            {3, 4, 5, 6, 7},
            {4, 5 ,6, 7, 8},
            {5, 6, 7, 8, 9},
            {11, 12, 13, 16, 25},
            {7, 8, 9, 10, 17},
            {8, 9, 10, 17, 18},
            {9, 10, 17, 18, 19},
            {10, 17, 18, 19, 20},
            {14, 15, 16, 25, 26}, //10
            {12, 13, 16, 25, 26},
            {13, 16 ,25 ,26 ,31},
            {16, 25, 26, 31, 32},
            {15, 16, 25, 26, 31},
            {16, 25, 26, 31, 32},
            {25, 26, 31, 32, 32},
            {18, 19, 20, 21, 27},
            {19, 20, 21, 27, 28},
            {20, 21, 27, 28, 29},
            {21, 27, 28, 29, 30}, //20
            {22, 23, 24, 16, 25},
            {23, 24, 16, 25, 26},
            {24, 16, 25, 26, 31},
            {16, 25, 26, 31, 32},
            {26, 31, 32, 32, 32},
            {31, 32, 32, 32, 32},
            {28, 29, 30, 31, 32},
            {29, 30, 31, 32, 32},
            {30, 31, 32 ,32 ,32},
            {31, 32, 32, 32, 32}, //30
            {32, 32, 32, 32, 32},
            {32, 32, 32, 32, 32}
    };

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        diceNum = new int[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<10; i++) {
            diceNum[i] = Integer.parseInt(st.nextToken());
        }
        for (int a = 1; a <= 4; a++)
            for (int b = 1; b <= 4; b++)
                for (int c = 1; c <= 4; c++)
                    for (int d = 1; d <= 4; d++)
                        for (int e = 1; e <= 4; e++)
                            for (int f = 1; f <= 4;f ++)
                                for (int g = 1; g <= 4; g++)
                                    for (int h = 1; h <= 4; h++)
                                        for (int i = 1; i <= 4; i++)
                                            for (int j = 1; j <= 4; j++){
                                                queue.add(a); queue.add(b); queue.add(c); queue.add(d); queue.add(e);
                                                queue.add(f); queue.add(g); queue.add(h); queue.add(i); queue.add(j);
                                                max = Integer.max(max, prog(queue));
                                            }

        System.out.println(max);

    }

    public static int prog(Queue<Integer> queue){
        int sum=0;

        int []seq = new int[10];
        int []loc = new int[5];
        int []horseCnt = new int[33];
        horseCnt[0] = 4;

        for(int i=0; i<10; i++) {
            seq[i] = queue.poll();
            //System.out.print(seq[i]);
        }

        for(int cnt = 0; cnt <10; cnt++){
            int horseIndex = seq[cnt];
            int moveDistance = diceNum[cnt];

            int posCurrent = loc[horseIndex];
            int posNext = moveResult[posCurrent][moveDistance-1];
            int point = map[posNext];

            sum += point;
            horseCnt[posCurrent]--;
            horseCnt[posNext]++;
            loc[horseIndex] = posNext;

            for(int i=1; i<=31; i++){
                if(horseCnt[i]>1) return -1;
            }
        }

        return sum;
    }



}

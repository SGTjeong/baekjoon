    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Iterator;
    import java.util.TreeSet;

    public class baekjoon2842 {
        static int n;
        static char [][]vMap;
        static int [][]vHeight;
        static boolean [][]visited;
        static int []range;

        static int startX, startY;
        static int desCnt, cnt;

        static int low, high;
        static int res = Integer.MAX_VALUE;

        public static void main(String []args) throws IOException {
            read();
            for(int i=0; i<range.length; i++)
                for(int j=i; j<range.length; j++){
                    low = range[i];
                    high = range[j];
                    cnt = 0;
                    visited = new boolean[vMap.length][vMap[0].length];
                    dfs(startX, startY);
                    if(cnt == desCnt){
                        if(high - low < res) res = high - low;
                    }
                }
            System.out.println(res);
        }

        public static void dfs(int x, int y){
            visited[x][y] = true;
            if(vMap[x][y]=='K') cnt++;
            if(cnt == desCnt) return;
            for(int i=0; i<8; i++){
                int newX = x + moveX[i];
                int newY = y + moveY[i];
                if(newX>=0&&newY>=0&&newX<vMap.length&&newY<vMap[0].length&&!visited[newX][newY]&&vHeight[newX][newY]>=low&&vHeight[newX][newY]<=high) dfs(newX, newY);
            }
        }

        public static void read() throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            vMap= new char[n][n];
            vHeight = new int[n][n];
            for(int i=0; i<n; i++){
                vMap[i] = br.readLine().toCharArray();
                for(int j=0; j<n; j++){
                    if(vMap[i][j]=='P'){
                        startX = i; startY = j;
                    }
                    else if(vMap[i][j]=='K'){
                        desCnt++;
                    }
                }
            }

            TreeSet<Integer> set = new TreeSet<>();
            for(int i=0; i<n; i++){
                String line[] = br.readLine().split(" ");
                for(int j=0; j<n; j++){
                    vHeight[i][j] = Integer.parseInt(line[j]);
                    set.add(vHeight[i][j]);
                }
            }

            int s=0;
            range = new int[set.size()];
            Iterator<Integer> itr = set.iterator();
            while(itr.hasNext()){
                range[s++] = itr.next();
            }

            /*
            char [][]map = new char[n][n];
            int [][]height = new int[n][n];
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;

            for(int i=0; i<n; i++){
                map[i] = br.readLine().toCharArray();
                for(int j=0; j<n; j++)
                    if(map[i][j]=='K' || map[i][j]=='P'){
                        if(i>maxX) maxX = i;
                        if(i<minX) minX = i;
                        if(j>maxY) maxY = j;
                        if(j<minY) minY = j;
                    }
            }

            for(int i=0; i<n; i++){
                String line[] = br.readLine().split(" ");
                for(int j=0; j<n; j++){
                    height[i][j] = Integer.parseInt(line[j]);
                }
            }

            //System.out.println(maxX + "," + minX + "," + maxY + "," + minY);
            vMap = new char[maxX-minX+1][maxY-minY+1];
            vHeight = new int[maxX-minX+1][maxY-minY+1];
            TreeSet<Integer> set = new TreeSet<>();

            for(int i=minX; i<=maxX; i++) {
                for (int j = minY; j <= maxY; j++) {
                    vMap[i - minX][j - minY] = map[i][j];
                    vHeight[i - minX][j - minY] = height[i][j];
                    set.add(height[i][j]);
                    if (map[i][j] == 'P') {
                        startX = i - minX;
                        startY = j - minY;
                    } else if (map[i][j] == 'K') {
                        desCnt++;
                    }
                }
            }

            int s=0;
            range = new int[set.size()];
            Iterator<Integer> itr = set.iterator();
            while(itr.hasNext()){
                range[s++] = itr.next();
            }
            */

        }

        static int []moveX = {1,-1,0,0,1,1,-1,-1};
        static int []moveY = {0,0,1,-1,1,-1,1,-1};
    }

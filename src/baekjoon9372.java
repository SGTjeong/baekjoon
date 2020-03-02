import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class baekjoon9372 {
    static BufferedReader br;
    static int countryNum, flightNum;
    public static void main(String []args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        while(testcase>0){
            String []line = br.readLine().split(" ");
            countryNum = Integer.parseInt(line[0]);
            flightNum = Integer.parseInt(line[1]);

            for(int i=0; i<flightNum; i++){
                String dum = br.readLine();
            }

            System.out.println(countryNum-1);
            testcase--;
        }

    }

}

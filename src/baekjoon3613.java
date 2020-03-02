import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class baekjoon3613 {
    static final int C = 0;
    static final int JAVA = 1;
    static final int NONE = 2;
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String []parsedInput = input.split("_");
        int result;


        if(parsedInput.length==0) result = NONE;

        else if(parsedInput.length==1){
            int point = -1;
            int i=0;
            for(i=0; i<input.length(); i++){
                if(input.charAt(i)<='z'&&input.charAt(i)>='a') continue;
                else if(input.charAt(i)<='Z'&&input.charAt(i)>='A'){
                    if(i==0) break;
                }
                else break;
            }

            if(i == input.length())result = JAVA;
            else result = NONE;
        } //

        else {
            int i = 0;
            for (i = 0; i < parsedInput.length; i++) {
                if (!isValid(parsedInput[i])) {
                   break;
                }
            }
            if(i!=parsedInput.length) result = NONE;
            else result = C;
        }

        switch (result){
            case C:
                System.out.print(parsedInput[0]);
                for(int i=1; i<parsedInput.length; i++){
                    System.out.print((char)(parsedInput[i].charAt(0)+('A'-'a')));
                    for(int j=1; j<parsedInput[i].length(); j++){
                        System.out.print(parsedInput[i].charAt(j));
                    }
                }
                System.out.println("");
                break;

            case JAVA:
                for(int i=0; i<input.length(); i++){
                    if(input.charAt(i)<='Z'&&input.charAt(i)>='A') {
                        System.out.print('_');
                        System.out.print((char)(input.charAt(i)+'a'-'A'));
                    }
                    else System.out.print(input.charAt(i));
                }
                System.out.println("");
                break;

            default:
                System.out.println("Error!");
        }
    }

    public static boolean isValid(String str){
        if(str.length()==0) return false;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)<'a'||str.charAt(i)>'z'){
                return false;
            }
        }
        return true;
    }
}

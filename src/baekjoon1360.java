import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon1360 {
    static Stack<Command> stack;
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            stack.push(new Command(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        int due = Integer.MAX_VALUE;
        String res = "";

        while(!stack.isEmpty()){
            Command c = stack.pop();
            int now = c.time;
            if(now>=due) continue;

            if(c.command.equals("type")){
                res = c.content + res;
            }
            else{
                due = now - Integer.parseInt(c.content);
            }
        }

        System.out.println(res);
    }


    static class Command{
        String command, content;
        int time;

        public Command(String command, String content, int time) {
            this.command = command;
            this.content = content;
            this.time = time;
        }
    }
}

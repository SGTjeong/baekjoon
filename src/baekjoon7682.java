import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon7682 {
    public static int numX, numO;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (true) {
            boolean valid = false;
            if ((line = br.readLine()).equals("end")) break;
            char[] board = line.toCharArray();

            for (int i = 0; i < board.length; i++) {
                if (board[i] == 'X') numX++;
                else if (board[i] == 'O') numO++;
            }

            if(numO > numX || numX > numO + 1) {
                valid = false;
            }
            else{

            }
            if (valid) System.out.println("valid");
            else System.out.println("invalid");
        }

    }

    public static int validVictory(char[] board) {
        int vCnt, hCnt, dCnt;
        vCnt = hCnt = dCnt = 0;
        int res;

        for (int i = 0; i < 3; i++) {
            if (board[i * 3] == board[i * 3 + 1] && board[i * 3 + 1] == board[i * 3 + 2] && (board[i * 3] == 'X' || board[i * 3] == 'O')) {
                vCnt++;
            }
            if (board[i] == board[i + 3] && board[i + 3] == board[i + 6] && (board[i] == 'X' || board[i] == 'O')) {
                hCnt++;
            }
        }
        if (board[0] == board[4] && board[4] == board[8] && (board[0] == 'X' || board[0] == 'O')) {
            dCnt++;
        }
        if (board[2] == board[4] && board[4] == board[6] && (board[2] == 'X' || board[2] == 'O')) {
            dCnt++;
        }

        if (vCnt > 1 || hCnt > 1) res = 0;
        else if (vCnt == 1 || hCnt == 1 || dCnt > 0) res = 1;
        else res = 2;

        return res;
    }

    public static boolean isFilled(char[] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == '.') return false;
        }
        return true;
    }
}

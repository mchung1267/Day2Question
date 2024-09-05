import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionThree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int formula = 4 * (n-1);
        char[][] pan = new char[formula + 1][formula + 1];
        for (int i = 0; i < formula + 1; i++) {
            for (int j = 0; j < formula + 1; j++) {
                pan[i][j] = ' ';
            }
        }
        drawStars(0, pan, n);
        for (int i = 0; i < formula + 1; i++) {
            for (int j = 0; j < formula + 1; j++) {
                System.out.print(pan[i][j]);
            }
            System.out.println();
        }
    }

    public static void drawStars(int start, char[][] array, int n) {
        if (n <= 0) {
            return;
        }
        int formula = 4 * (n - 1);
        for (int i = start; i < start+formula + 1; i++) {
            array[start][i] = '*';
            array[i][start] = '*';
            array[start+formula][i] = '*';
            array[i][start+formula] = '*';

        }
        drawStars(start+2, array, n-1);
    }
}

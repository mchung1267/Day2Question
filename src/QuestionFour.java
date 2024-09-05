import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuestionFour {
    static int[][][] data = new int[21][21][21];
    static int w(int a, int b, int c) {
        if(checkRange(a,b,c) && data[a][b][c] != 0) {
            return data[a][b][c];
        }
        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if(a > 20 || b > 20 || c > 20) {
            return data[20][20][20] = w(20, 20, 20);
        }
        if(a < b && b < c) {
            return data[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return data[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
    static boolean checkRange(int a, int b, int c) {
        return a >= 0 && b >= 0 && c >= 0 && a <= 20 && b <= 20 && c <= 20;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1) {
                break;
            }
            //모든 텍스트를 각각 append 하도록 IDE에서 권장하며, 백준 기준 28ms정도의 시간이 단축되었습니다.
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c)).append('\n');
        }
        System.out.println(sb);
    }
}

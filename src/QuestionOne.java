import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionOne {
    static int[] f;
    static int codeA, codeB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        f = new int[n];
        codeA = 0;
        codeB = 0;

        fib(n);
        fibonacci(n);
        System.out.println(codeA + " " + codeB);
    }
    static int fib(int n) {
        if (n == 1 || n == 2) {
            codeA++;
            return 1;
        } else {
            return (fib(n - 1) + fib(n - 2));
        }
    }
    static int fibonacci(int n) {
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i < n; i++) {
            codeB++;
            f[i] = f[i-1] + f[i-2];
        }
        return f[n - 1];
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        int A = 0;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch(cmd) {
                case "add":
                    A |= (1 << Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    A &= ~(1 << Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    sb.append((A & (1 << Integer.parseInt(st.nextToken()))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    A ^= (1 << Integer.parseInt(st.nextToken()));
                    break;
                case "all":
                    A = (1 << 21) - 1;
                    break;
                case "empty":
                    A = 0;
                    break;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

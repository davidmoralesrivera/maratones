
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class trees {

    static final BufferedReader IN = new BufferedReader(new InputStreamReader(System.in));
    static String[] input;
    static int n;
    static int m;
    static int orderingSTree[];
    static char distributionSTree[];
    static char VVAs[];
    static int caseCount = 1;

    public static void main(String[] args) throws IOException {
        while (true) {
            n = Integer.parseInt(IN.readLine());
            if (n == 0) {
                break;
            }
            input = IN.readLine().split("\\s++");
            orderingSTree = new int[n];
            for (int i = 0; i < n; i++) {
                orderingSTree[i] = input[i].charAt(1) - '0' - 1;
            }
            distributionSTree = IN.readLine().toCharArray();
            m = Integer.parseInt(IN.readLine());
            System.out.println("S-Tree #" + caseCount + ":");
            for (int i = 0; i < m; i++) {
                VVAs = IN.readLine().toCharArray();
                int x = 0;
                for (int j = 0; j < n; j++) {
                    if (VVAs[orderingSTree[j]] == '0') {
                        x = 2 * x;
                    } else {
                        x = 2 * x + 1;
                    }
                }
                System.out.print(distributionSTree[x]);
            }
            System.out.println("\n");
            caseCount++;
        }

    }
}

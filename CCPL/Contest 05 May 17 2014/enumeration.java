
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class enumeration {

    static final int MAX = 200001;
    static final BufferedReader IN = new BufferedReader(new InputStreamReader(System.in));
    static final long EULER[];
    static long acum[];
    static long k;

    static {
        EULER = new long[MAX];
        EULER[0] = EULER[1] = 0;
        for (int i = 2; i < MAX; ++i) {
            EULER[i] = i - 1;
        }
        for (int i = 1; i < MAX; ++i) {
            for (int j = i + i; j < MAX; j += i) {
                EULER[j] -= EULER[i];
            }
        }
    }

    static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        long[] acumAux = new long[MAX];
        acum = new long[MAX + 1];
        acumAux[0] = acum[0] = 1;
        for (int i = 1; i < MAX; i++) {
            acumAux[i] = EULER[i] + acumAux[i - 1];
            acum[i] = acumAux[i] + 1;
        }
        while (true) {
            k = Long.parseLong(IN.readLine());
            if (k == 0) {
                break;
            } else if (k == 1) {
                System.out.printf("%d/%d\n", 0, 1);
                continue;
            }
            int index = Arrays.binarySearch(acum, k);
            if (index < 0) {
                index = 0;
            }
            long keep = k - acum[index - 1];
            long top = 1, bottom = index;
            for (long i = 1; i < bottom; i++) {
                if (gcd(i, bottom) == 1) {
                    --keep;
                }
                if (keep == 0) {
                    top = i;
                    break;
                }
            }
            System.out.printf("%d/%d\n", top, bottom);
        }
    }

}

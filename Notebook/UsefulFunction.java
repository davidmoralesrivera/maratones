
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class UsefulFunction {

    public static BigInteger bigSqrt(String n) {
        BigInteger root = BigInteger.ZERO;
        BigInteger res = BigInteger.ZERO;
        BigInteger HUNDRED = new BigInteger("100");
        BigInteger TEN = new BigInteger("10");
        BigInteger[] DIGITS = new BigInteger[10];
        for (int i = 0; i < DIGITS.length; i++) {
            DIGITS[i] = new BigInteger("" + i);
        }
        ArrayList<String> parts = new ArrayList<String>();
        for (int i = n.length(); i > 0; i -= 2) {
            parts.add(n.substring(Math.max(i - 2, 0), i));
        }
        for (int i = parts.size() - 1; i >= 0; i--) {
            res = res.multiply(HUNDRED).add(new BigInteger(parts.get(i)));
            for (int j = 9; j >= 0; j--) {
                BigInteger temp = root.multiply(DIGITS[2]).multiply(TEN).add(
                        DIGITS[j]).multiply(DIGITS[j]);
                if (temp.compareTo(res) > 0) {
                    continue;
                }
                root = root.multiply(TEN).add(DIGITS[j]);
                res = res.subtract(temp);
                break;
            }
        }
        return root;
    }

    //Solucion a la expresion b ^ e mod m.
    public static long bigMod(long b, long e, long m) {
        long r = 1L;
        while (e > 0) {
            if ((e & 1L) == 1L) {
                r = (r * b) % m;
            }
            e >>= 1;
            b = (b * b) % m;
        }
        return r;
    }

    //r combinaciones sin repeticion.
    public static int nCr(int n, int r, int[][] triangle) {
        if (n < r) {
            return 0;
        }
        if (triangle[n][r] >= 0) {
            return triangle[n][r];
        }
        if (n == 0 || n == 1 || n == r || r == 0) {
            triangle[n][r] = 1;
        } else {
            triangle[n][r] = nCr(n - 1, r - 1, triangle) + nCr(n - 1, r, triangle);
        }
        return triangle[n][r];
    }

    //Contruir triangulo de pascal.
    public static int[][] getPascalTriangle(int max) {
        int triangle[][] = new int[max + 1][max + 1];
        for (int i = 0; i < triangle.length; i++) {
            Arrays.fill(triangle[i], -1);
        }
        return triangle;
    }

    //Contruir criba para numeros primos, false si es primo.
    public static boolean[] getCriba(int limit) {
        boolean criba[] = new boolean[limit + 1];
        criba[0] = criba[1] = true;
        int max = (int) Math.sqrt(limit);
        for (int i = 2; i < max; ++i) {
            if (criba[i]) {
                continue;
            }
            for (int j = i * 2; j <= limit; j += i) {
                criba[j] = true;
            }
        }
        return criba;
    }

    //Todos los divisores de n en desorden. Hasta 4294967295 unsigned long.
    public static ArrayList<Integer> getAllDivisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i * i < n) {
                    divisors.add(n / i);
                }
            }
        }
        return divisors;
    }

    //Coeficiente binomial para combinaciones y permutaciones.
    public static long[][] getBinomialCoefficient() {
        final int N = 30;
        long choose[][] = new long[N + 1][N + 1];
        for (int i = 0; i <= N; ++i) {
            choose[i][0] = choose[i][i] = 1;
        }
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j < i; ++j) {
                choose[i][j] = choose[i - 1][j - 1] + choose[i - 1][j];
            }
        }
        return choose;
    }

    public static void main(String[] args) {
        System.out.println(nCr(4, 3, getPascalTriangle(20)));
    }
}

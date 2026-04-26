package Security;

import java.util.List;

public class ElGamal {
    public List<Long> encrypt(int q, int alpha, int y, int k, int m) {
        long c1 = modPow(alpha, k, q);
        long s = modPow(y, k, q);
        long c2 = (m * s) % q;
        return List.of(c1, c2);
    }

    public int decrypt(int c1, int c2, int x, int q) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static long modPow(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            exp >>= 1;
            base = (base * base) % mod;
        }
        return result;
    }
}

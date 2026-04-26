package Security;

import java.util.List;

import static Security.ElGamal.modPow;

public class DiffieHellman {
    public List<Integer> getKeys(int q, int alpha, int xa, int xb) {
        long ya = modPow(alpha,xa,q);
        long yb = modPow(alpha,xb,q);
        long ka = modPow(yb,xa,q);
        long kb = modPow(ya,xb,q);
        return List.of((int)ka, (int)kb);
    }
}

package Security;

// p+k%26 = c --> p=c-k%26 nd k=c-p%26
public class RepeatingKey {
    private int[] LPS(String key) {
        int len = key.length();
        int[] lps = new int[len];
        int i = 1, j = 0;
        while (i < len) {
            if (key.charAt(j) == key.charAt(i)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    private String get_key(String repeatedKey) {
        int[] lps = LPS(repeatedKey);
        int n = lps.length;
        int period = n - lps[n - 1];
        return repeatedKey.substring(0, period);
    }

    public String analyse(String plainText, String cipherText) {
        plainText = plainText.toLowerCase().replaceAll("[^a-z]", "");
        cipherText = cipherText.toLowerCase().replaceAll("[^a-z]", "");
        StringBuilder repeatedKey = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            int c = cipherText.charAt(i) - 'a';
            int p = plainText.charAt(i) - 'a';
            repeatedKey.append((char) ((((c - p) % 26 + 26) % 26) + 'a'));
        }
        System.out.println("repeated key:");
        System.out.println(repeatedKey);
        // key is repeated to fit length of plain text -> extract the key
        return get_key(repeatedKey.toString());
    }

    public String decrypt(String cipherText, String key) {
        // Students should complete this part
        key = key.toLowerCase().replaceAll("[^a-z]", "");
        cipherText = cipherText.toLowerCase().replaceAll("[^a-z]", "");
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            int c = cipherText.charAt(i) - 'a';
            int k = key.charAt(i % key.length()) - 'a';
            plainText.append((char) ((((c - k) % 26 + 26) % 26) + 'a'));
        }
        return plainText.toString();
    }

    public String encrypt(String plainText, String key) {
        plainText = plainText.toLowerCase();
        key = key.toLowerCase();
        int plainLen = plainText.length();

        // Repeat key to match plaintext length
        StringBuilder extendedKey = new StringBuilder(key);
        while (extendedKey.length() < plainLen) {
            extendedKey.append(extendedKey.charAt(extendedKey.length() - key.length()));
        }

        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainLen; i++) {
            int p = plainText.charAt(i) - 'a';
            int k = extendedKey.charAt(i) - 'a';
            cipherText.append((char) (((p + k) % 26) + 'a'));
        }

        return cipherText.toString();
    }
}

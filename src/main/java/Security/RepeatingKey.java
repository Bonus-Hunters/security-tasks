package Security;

public class RepeatingKey {
    // p+k%26 = c --> p=c-k%26 nd k=c-p%26
    public String analyse(String plainText, String cipherText) {
        return null;
    }

    public String decrypt(String cipherText, String key) {
        // Students should complete this part
        key = key.toLowerCase().replaceAll("[^a-z]", "");
        cipherText = cipherText.toLowerCase().replaceAll("[^a-z]", "");
        StringBuilder plainText = new StringBuilder();
        for(int i=0; i<cipherText.length(); i++){
            int c = cipherText.charAt(i)-'a';
            int k= key.charAt(i%key.length())-'a';
            plainText.append((char)((((c-k)%26+26)%26)+'a'));
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

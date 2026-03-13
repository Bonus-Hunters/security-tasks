package Security;

public class AutoKey {
    public String analyse(String plainText, String cipherText) {
        // Students should complete this part
        plainText = plainText.toLowerCase();
        cipherText = cipherText.toLowerCase();

        StringBuilder key = new StringBuilder();
        for(int i = 0;i < plainText.length();i++)
        {
            key.append(reverse(cipherText.charAt(i), plainText.charAt(i)));
        }
        
        StringBuilder cur = new StringBuilder();
        boolean valid = false;
        for(int i = key.length() - 1;i >= 0;i--)
        {
            cur.insert(0, key.charAt(i));
            if(plainText.startsWith(cur.toString()))
            {
                valid = true;
            }
            else if(valid)
            {
                key.delete(i + 1, key.length());
                break;
            }
        }
        System.out.println(key.toString());
        return key.toString();
    }

    public String decrypt(String cipherText, String key) {

        cipherText = cipherText.toLowerCase();
        key = key.toLowerCase();
        int len = key.length();

        StringBuilder plain = new StringBuilder();
        for(int i = 0;i < len;i++)
        {
            plain.append(reverse(cipherText.charAt(i), key.charAt(i)));
        }
        int cur = 0;
        while (plain.length() != cipherText.length()) 
        {
            plain.append(reverse(cipherText.charAt(len + cur), plain.charAt(cur)));
            cur++;
        }
        return plain.toString();
    }

    private char reverse(char first,char second)
    {
        int decode_first = first - 'a';
        int decode_second = second - 'a';
        int diff = decode_first - decode_second + 26;
        return(char)(diff % 26 + 'a');
    }

    public String encrypt(String plainText, String key) {
        plainText = plainText.toLowerCase();
        key = key.toLowerCase();
        int len = plainText.length();

        // Extend key using the plaintext
        StringBuilder autoKey = new StringBuilder(key);
        if (autoKey.length() < len) {
            int diffLen = len - autoKey.length();
            for (int i = 0; i < diffLen; i++) {
                autoKey.append(plainText.charAt(i));
            }
        }

        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int p = plainText.charAt(i) - 'a';
            int k = autoKey.charAt(i) - 'a';
            cipherText.append((char) (((p + k) % 26) + 'a'));
        }
        return cipherText.toString();
    }
}

package Security;
import java.util.*;

public class ColumnarCipher {

    public List<Integer> analyse(String plainText, String cipherText) {
        plainText = plainText.replace(" ", "");
        cipherText = cipherText.replace(" ", "");
        int len = cipherText.length();
        for(int col = 2; col <= len; col++)
        {
            if(len % col != 0) continue;
            int row = len / col;

            char[][] grid = new char[row][col];
            
            int idx = 0;
            for(int r = 0; r < row; r++)
            {
                for(int c = 0; c < col; c++)
                {
                    if(idx < len) grid[r][c] = plainText.charAt(idx++);
                    else grid[r][c] = 'x';
                }
            }

            Map<String, Set<Integer>> colid = new HashMap<>();
            for(int c = 0; c < col; c++)
            {
                StringBuilder sb = new StringBuilder();
                for(int r = 0; r < row; r++)
                    sb.append(grid[r][c]);
                String s = sb.toString();
                Set<Integer> set = colid.get(s);
                if(set == null)
                {
                    set = new LinkedHashSet<>();
                    colid.put(s, set);
                }
                set.add(c);
            }

            Boolean valid = true;
            Integer[] key = new Integer[col];
            for(int c = 0; c < col; c++)
            {
                String s = cipherText.substring(c * row, (c + 1) * row);
                Set<Integer> set = colid.get(s);
                if(set == null || set.isEmpty())
                {
                    valid = false;
                    break;
                }
                Iterator<Integer> it = set.iterator();
                Integer keypos = it.next(); 
                it.remove();      
                key[keypos] = c + 1; 
            }
            if(valid) return new ArrayList<>(Arrays.asList(key));
        }
        return new ArrayList<>(); 
    }

    public String decrypt(String cipherText, List<Integer> key) {
        int cipherSize = cipherText.length();
        int rows = (int) Math.ceil((double) cipherSize / key.size());
        char[][] grid = new char[rows][key.size()];
        int count = 0;

        Map<Integer, Integer> keyMap = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            keyMap.put(key.get(i) - 1, i);
        }

        int remainingCols = cipherSize % key.size();
        for (int i = 0; i < key.size(); i++) {
            for (int j = 0; j < rows; j++) {
                if (remainingCols != 0 && j == rows - 1 && keyMap.get(i) >= remainingCols) continue;
                grid[j][keyMap.get(i)] = cipherText.charAt(count++);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < key.size(); j++) {
                result.append(grid[i][j]);
            }
        }
        return result.toString().toUpperCase().trim();
    }

    public String encrypt(String plainText, List<Integer> key) {
        int ptSize = plainText.length();
        int rows = (int) Math.ceil((double) ptSize / key.size());
        char[][] grid = new char[rows][key.size()];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < key.size(); j++) {
                if (count >= ptSize) {
                    grid[i][j] = 'x';
                } else {
                    grid[i][j] = plainText.charAt(count++);
                }
            }
        }

        Map<Integer, Integer> keyMap = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            keyMap.put(key.get(i) - 1, i);
        }

        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < key.size(); i++) {
            for (int j = 0; j < rows; j++) {
                cipherText.append(Character.toUpperCase(grid[j][keyMap.get(i)]));
            }
        }
        return cipherText.toString();
    }
}

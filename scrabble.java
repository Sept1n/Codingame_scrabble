import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        ArrayList<String> tableofWords = new ArrayList<>(N);
        HashMap<String, Integer> wordsWithValues = new HashMap<>();
        int valueOfWord = 0;
        for (int i = 0; i < N; i++) {
            String W = in.nextLine();
            if (W.length() <= 7) {
                tableofWords.add(W);
            }
        }
        String LETTERS = in.nextLine();
        String let = LETTERS;
        for (int i = 0; i < tableofWords.size(); i++) {
            for (int j = 0; j < tableofWords.get(i).length(); j++) {
                if (!LETTERS.contains(String.valueOf(tableofWords.get(i).charAt(j)))) {
                    break;
                }
                else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(LETTERS);
                    char c = tableofWords.get(i).charAt(j);
                    String s = String.valueOf(c);
                    int position = stringBuilder.indexOf(s);
                    stringBuilder.deleteCharAt(position);
                    LETTERS = stringBuilder.toString();

                    if(j + 1 == tableofWords.get(i).length()) {
                        for (int k = 0; k < tableofWords.get(i).length(); k++) {
                            switch(tableofWords.get(i).charAt(k)) {
                                case 'e': case 'a': case 'i': case 'o': case 'n': case 'r': case 't':
                                case 'l': case 's': case 'u':
                                    valueOfWord += 1;
                                    break;
                                case 'd': case 'g':
                                    valueOfWord += 2;
                                    break;
                                case 'b': case 'c': case 'm': case 'p':
                                    valueOfWord += 3;
                                    break;
                                case 'f': case 'h': case 'v': case 'w': case 'y':
                                    valueOfWord += 4;
                                    break;
                                case 'k':
                                    valueOfWord += 5;
                                    break;
                                case 'j': case 'x':
                                    valueOfWord += 8;
                                    break;
                                case 'q': case 'z':
                                    valueOfWord += 10;
                                    break;
                            }
                        }
                        wordsWithValues.put(tableofWords.get(i), valueOfWord);
                        valueOfWord = 0;
                    }
                }

            }
            LETTERS = let;
        }
        HashMap <String, Integer> hm = new HashMap<>();
        int maxValue = Collections.max(wordsWithValues.values());
        String val = "";
        for(Entry<String, Integer> entry : wordsWithValues.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                val = entry.getKey();
                int p = tableofWords.indexOf(val);
                hm.put(val, p);
            }
        }
        int minValue = Collections.min(hm.values());
        for(Entry<String, Integer> entry : hm.entrySet()) {
            if (entry.getValue().equals(minValue)) {
                System.out.println(entry.getKey());
            }
        }
    }
}
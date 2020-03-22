package com.slotvinskiy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {

    public static final String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public static void main(String[] args) {

        String[] words = {"gin", "zen", "gig", "msg"};
        int result = uniqueMorseRepresentations(words);
        System.out.println(result);
    }

    public static int uniqueMorseRepresentations(String[] words) {
        Map<Character, String> map = new TreeMap<>();
        char startChar = 'a';
        for (int i = 0; i < morse.length; i++, startChar++) {
            map.put(startChar, morse[i]);
        }
        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char[] wordChar = words[i].toCharArray();
            for (int j = 0; j < wordChar.length; j++) {
                sb.append(map.get(wordChar[j]));
            }
            result.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return result.size();
    }
}

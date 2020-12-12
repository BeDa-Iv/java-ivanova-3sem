import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssociativeArrays {

    public static void main(String[] args) throws IOException {
        System.out.println(transliteration("История"));
        transliterateFile("rus.txt", "eng.txt");
        System.out.println(charCounter("Environment"));
        System.out.println(charIndexCounter("Environment"));
        frequencyMap("rus.txt");
        System.out.println(" ");
        sortedMap(frequencyMap2("rus.txt"));
    }

    private static Map<Character, String> createTransliterationTable() {
        char[] rus = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
        String[] eng = {"a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "i", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "kh", "ts", "ch", "sh", "shch", "ie", "y", "", "e", "iu", "ia"};
        Map<Character, String> translit = new HashMap<>();
        for (int i = 0; i < rus.length; i++) {
            translit.put(rus[i], eng[i]);
        }
        return translit;
    }

    private static String transliteration(String s) {
        Map<Character, String> translit = createTransliterationTable();
        String normStr = s.toLowerCase();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char symb = normStr.charAt(i);
            String symbResult = translit.get(symb);
            if (Character.isLowerCase(s.charAt(i))) {
                result.append(symbResult);
            }
            else {
                result.append(Character.toUpperCase(symbResult.charAt(i))).append(symbResult.substring(i+1));
            }
        }
        return result.toString();
    }

    private static void transliterateFile(String in, String out) throws IOException {
        Pattern p = Pattern.compile("[А-Яа-я]+");
        try (Scanner reader = new Scanner(new File(in), StandardCharsets.UTF_8);
             PrintStream writer = new PrintStream(new File(out), StandardCharsets.UTF_8)) {
            while (reader.hasNextLine()) {
                String words = reader.nextLine();
                Matcher m = p.matcher(words);
                StringBuilder output = new StringBuilder();
                while (m.find()) {
                    m.appendReplacement(output, transliteration(m.group()));
                }
                m.appendTail(output);
                writer.println(output);
            }
        }
    }


    private static Map<Character, Integer> charCounter(String s) {
        Map<Character, Integer> countSymbol = new HashMap<>();
        String normStr= s.toLowerCase();
        for (int i=0; i<normStr.length(); i++) {
            Character symb = normStr.charAt(i);
            if (countSymbol.containsKey(symb)) {
                countSymbol.put(symb, countSymbol.get(symb) + 1);
            }
            else {
                countSymbol.put(symb, 1);
            }
        }
        return countSymbol;
    }

    private static  Map<Character, List<Integer>> charIndexCounter(String s) {
        Map<Character, List<Integer>> countIndex = new HashMap<>();
        String normStr= s.toLowerCase();
        char[] symb = normStr.toCharArray();
        for (int i=0; i<normStr.length(); i++) {
            if (countIndex.containsKey(symb[i])) {
                countIndex.get(symb[i]).add(i);
            }
            else {
                countIndex.put(symb[i], new ArrayList<>(List.of(i)));
            }
        }
        return countIndex;
    }

    private static void frequencyMap(String filename) throws IOException {
        Map<String, Integer> hash = new HashMap<>();
        Map<String, Integer> tree = new TreeMap<>();
        Map<String, Integer> linkedHash = new LinkedHashMap<>();
        File f = new File(filename);
        try (Scanner in = new Scanner(f, StandardCharsets.UTF_8).useDelimiter("[«»—.,:;()?!\\s]+")) {
            while (in.hasNext()) {
                String word = in.next().toLowerCase();
                hash.put(word, hash.getOrDefault(word, 0) + 1);
                tree.put(word, tree.getOrDefault(word, 0) + 1);
                linkedHash.put(word, linkedHash.getOrDefault(word, 0) + 1);
            }
        }
        System.out.println(hash);
        System.out.println(tree);
        System.out.println(linkedHash);
    }

    private static Map<String, Integer> frequencyMap2(String filename) throws IOException {
        Map<String, Integer> wordFreqMap = new HashMap<>();
        File f = new File(filename);
        try (Scanner in = new Scanner(f, StandardCharsets.UTF_8).useDelimiter("[«»—.,:;()?!\\s]+")) {
            while (in.hasNext()) {
                String word = in.next().toLowerCase();
                wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
            }
        }
        return wordFreqMap;
    }

    public static void sortedMap(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((k1, k2) -> - k1.getValue().compareTo(k2.getValue()));
        System.out.println(list);
    }

}


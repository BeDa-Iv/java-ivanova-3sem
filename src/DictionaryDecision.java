import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DictionaryDecision {
    public static void main(String[] args) throws Exception {
        dictReader("dictionary.txt");
        search("strict-queries.txt", "out.txt");
        fullSearch("full-text-search.txt", "out2.txt");
    }

    private static final List<DictionaryEntry> dict = new ArrayList<>();

    private static void dictReader(String filename) {
        try (Scanner reader = new Scanner(new File(filename), StandardCharsets.UTF_8)) {
            while (reader.hasNextLine()) {
                String[] words = reader.nextLine().split(" ", 2);
                DictionaryEntry newWord = new DictionaryEntry(words[0], words[1]);
                dict.add(newWord);
            }
        } catch (Exception e) {
            System.out.println("проблема при чтении файла");
        }
    }

    private static void search(String in, String out) throws IOException {
        Set<String> hashSet = new HashSet<>();
        try (Scanner reader = new Scanner(new File(in), StandardCharsets.UTF_8);
             PrintStream writer = new PrintStream(new File(out), StandardCharsets.UTF_8)) {
            for (int i = 0; i < 10; i++) {
                String word = reader.next().toUpperCase();
                for (DictionaryEntry d : dict) {
                    if (d.getWord().equals(word))
                        hashSet.add(d.getTranslation());
                }
                for (String s : hashSet) { writer.println(s); }
            }
        }
    }

    private static void fullSearch(String in, String out) throws Exception {
        Set<String> hashSet = new HashSet<>();
        try (Scanner reader = new Scanner(new File(in), StandardCharsets.UTF_8);
             PrintStream writer = new PrintStream(new File(out), StandardCharsets.UTF_8)) {
            for (int i = 0; i < 10; i++) {
                String word = reader.next().toUpperCase();
                for (DictionaryEntry d : dict) {
                    if (d.getWord().contains(word))
                        hashSet.add(d.getWord() + ": " + d.getTranslation());
                }
                for (String s : hashSet) { writer.println(s); }
            }
        }
    }

}
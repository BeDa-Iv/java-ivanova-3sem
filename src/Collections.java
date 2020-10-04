import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import static java.lang.Character.isDigit;

public class Collections {
    public static void main(String[] args) throws IOException {
        System.out.println("Задача 1:");
        System.out.println(chisla());

        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        a.add("ab");
        a.add("cd");
        b.add("ef");
        b.add("gh");
        System.out.println("Задача 2:");
        System.out.println(combi(a, b));

        List<String> c = new ArrayList<>();
        c.add("co");
        c.add("ca");
        c.add("la");
        System.out.println("Задача 4 (чистая функция):");
        System.out.println(backwardsClean(c));
        System.out.println(c);
        System.out.println("Задача 4 (нечистая функция):");
        backwardsNotClean(c);
        System.out.println(c);

        List<String> d = new ArrayList<>();
        d.add("a");
        d.add("b");
        d.add("c");
        d.add("d");
        System.out.println("Задача 5.1 (чистая функция):");
        System.out.println(deleteIndexChetClean(d));
        System.out.println(d);
        System.out.println("Задача 5.1 (нечистая функция):");
        deleteIndexChetNotClean(d);
        System.out.println(d);

        List<String> e = new ArrayList<>();
        e.add("23");
        e.add("4");
        e.add("ccc");
        e.add("92");
        System.out.println("Задача 5.2 (чистая функция):");
        System.out.println(deleteChetClean(e));
        System.out.println(e);
        System.out.println("Задача 5.2 (нечистая функция):");
        deleteChetNotClean(e);
        System.out.println(e);

        List<Integer> f = new ArrayList<>();
        f.add(1);
        f.add(7);
        f.add(54);
        f.add(8);
        System.out.println("Задача 5.3 (чистая функция):");
        System.out.println(deleteChetCleanInteger(f));
        System.out.println(f);
        System.out.println("Задача 5.3 (нечистая функция):");
        deleteChetNotCleanInteger(f);
        System.out.println(f);

        System.out.println("Задача 6:");
        textFile("text.txt");

    }

    public static List<Integer> chisla() {
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            num.add(i + 1);
        }
        return num;
    }

    public static List<String> combi(List<String> a, List<String> b) {
        List<String> res = new ArrayList<>();
        res.addAll(a);
        res.addAll(b);
        return res;
    }

    public static List<String> backwardsClean(List<String> a) {
        List<String> res = new ArrayList<>();
        for (int i = a.size() - 1; i >= 0; i--) {
            res.add(a.get(i));
        }
        return res;
    }

    public static void backwardsNotClean(List<String> a) {
        for (int i = a.size() - 1; i >= 0; i--) {
            a.add(a.get(i));
            a.remove(i);
        }
    }

    public static List<String> deleteIndexChetClean(List<String> a) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (i % 2 == 1) {
                res.add(a.get(i));
            }
        }
        return res;
    }

    public static void deleteIndexChetNotClean(List<String> a) {
        for (int i = 0; i < a.size(); i++) {
            if (i % 2 == 0)
                a.remove(i);
        }
    }

    private static boolean isNumber(String s) {
        char[] sArray = s.toCharArray();
        for (char c : sArray) {
            if (!isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static List<String> deleteChetClean(List<String> a) {
        List<String> res = new ArrayList<>();
        for (String num : a) {
            if (isNumber(num)) {
                if (Integer.parseInt(num) % 2 != 0) {
                    res.add(num);
                }
            } else {
                res.add(num);
            }
        }
        return res;
    }

    public static void deleteChetNotClean(List<String> a) {
        for (int i = 0; i < a.size(); i++) {
            if (isNumber(a.get(i))) {
                if (Integer.parseInt(a.get(i)) % 2 == 0) {
                    a.remove(a.get(i));
                }
            }
        }
    }

    public static List<Integer> deleteChetCleanInteger(List<Integer> a) {
        List<Integer> res = new ArrayList<>();
        for (int num : a) {
            if (num % 2 == 1) {
                res.add(num);
            }
        }
        return res;
    }

    public static void deleteChetNotCleanInteger(List<Integer> a) {
        a.removeIf(x -> x % 2 == 0);
    }

    public static void textFile(String s) throws IOException {
        Set<String> type1 = new HashSet<>();
        Set<String> type2 = new TreeSet<>();
        Set<String> type3 = new LinkedHashSet<>();
        File f = new File(s);
        try (Scanner in = new Scanner(f, StandardCharsets.UTF_8)) {
            while (in.hasNext()) {
                String word = in.next().toLowerCase().replaceAll("[^а-я—А-Яa-zA-Z0-9-\\s]", "");
                    type1.add(word);
                    type2.add(word);
                    type3.add(word);
            }
        }
        System.out.println("HashSet:");
        System.out.println(type1);
        System.out.println("TreeSet:");
        System.out.println(type2);
        System.out.println("LinkedHashSet:");
        System.out.println(type3);
    }

}
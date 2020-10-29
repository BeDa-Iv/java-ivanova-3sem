import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import static java.lang.Character.isDigit;

public class Collections {
    public static void main(String[] args) throws IOException {

        List<Integer> list100 = create100();
        System.out.println("list100 = " + list100);

        List<String> list1 = List.of("abc", "xyz", "ooo");
        printList(list1);

        List<String> list2 = List.of("abc", "xyz", "ooo");
        printListWithIndices(list2);

        List<String> list3 = List.of("aaa", "bbb", "ccc");
        List<String> list4 = List.of("xxx", "yyy", "zzz");
        List<String> list3plusList4 = concatenateLists(list3, list4);
        System.out.println(list3plusList4);
        System.out.println(list3);
        System.out.println(list4);

        List<String> list5 = new ArrayList<>(List.of("first", "middle", "last"));
        List<String> list5rev = reverseList(list5);
        System.out.println("list5rev = " + list5rev + ", but list5 = " + list5);
        reverseListInPlace(list5);
        System.out.println("list5 = " + list5);

        List<String> ints = List.of("11", "22", "33", "55", "66", "88", "100", "3", "4");
        System.out.println("ints = " + ints);
        System.out.println("ints no even indices = " + filterEvenIndices(ints));
        System.out.println("ints without even = " + filterEven(ints));
        List<Integer> ints2 = List.of(11, 22, 33, 55, 66, 88, 100, 3, 4);
        System.out.println("ints without even = " + filterEven2(ints2));
        System.out.println(" ============= mutable lists =================== ");
        List<String> mutableInts = new ArrayList<>(ints);
        mutableFilterEvenIndices(mutableInts);
        System.out.println("ints no even indices = " + mutableInts);
        mutableInts = new ArrayList<>(ints);
        mutableFilterEven(mutableInts);
        System.out.println("ints without even = " + mutableInts);
        List<Integer> mutableInts2 = new ArrayList<>(ints2);
        mutableFilterEven2(mutableInts2);
        System.out.println("ints without even = " + mutableInts2);

        System.out.println("Задача 7:");
        doReadWordsInFile("text.txt");

    }

    public static List<Integer> create100() {
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= 100; i++)
            num.add(i);
        return num;
    }

    public static void printList(List<String> a) {
        System.out.println("Элементов в списке: " + a.size());
        for (String element : a)
            System.out.println(element);
    }

    public static void printListWithIndices(List<String> a) {
        int i = 1;
        System.out.println("Элементов в списке: " + a.size());
        for (String element : a) {
            System.out.println((i) + ": " + element);
            i++;
        }
    }


    public static List<String> concatenateLists(List<String> a, List<String> b) {
        List<String> res = new ArrayList<>();
        res.addAll(a);
        res.addAll(b);
        return res;
    }

    public static List<String> reverseList(List<String> a) {
        List<String> res = new ArrayList<>();
        for (int i = a.size() - 1; i >= 0; i--) {
            res.add(a.get(i));
        }
        return res;
    }

    public static void reverseListInPlace(List<String> a) {
        for (int i = a.size() - 1; i >= 0; i--) {
            a.add(a.get(i));
            a.remove(i);
        }
    }

    public static List<String> filterEvenIndices(List<String> a) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++)
            if (i % 2 == 1)
                res.add(a.get(i));
        return res;
    }

    public static void mutableFilterEvenIndices(List<String> a) {
        for (int i = a.size() - 1; i >= 0; i=i-2) {
            a.remove(i);
        }
    }


    private static boolean isNumber(String s) {
        char[] sArray = s.toCharArray();
        for (char c : sArray)
            if (!isDigit(c))
                return false;
        return true;
    }

    public static List<String> filterEven(List<String> a) {
        List<String> res = new ArrayList<>();
        for (String num : a)
            if (isNumber(num)) {
                if (Integer.parseInt(num) % 2 != 0)
                    res.add(num);
            } else
                res.add(num);
        return res;
    }

    public static void mutableFilterEven(List<String> a) {
        List<String> res = new ArrayList<>();
        for (String s : a)
            if (isNumber(s))
                if (Integer.parseInt(s) % 2 == 0)
                    res.add(s);
            a.removeAll(res);
    }

    public static List<Integer> filterEven2(List<Integer> a) {
        List<Integer> res = new ArrayList<>();
        for (int num : a)
            if (num % 2 == 1)
                res.add(num);
        return res;
    }

    public static void mutableFilterEven2(List<Integer> a) {
        List<Integer> res = new ArrayList<>();
        for (Integer i : a)
            if (i % 2 == 0)
                res.add(i);
        a.removeAll(res);
    }

    public static void doReadWordsInFile(String s) throws IOException {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();
        File f = new File(s);
        try (Scanner in = new Scanner(f, StandardCharsets.UTF_8)) {
            while (in.hasNext()) {
                String word = in.next().toLowerCase().replaceAll("[^а-яa-z0-9]", "");
                if (word.length() != 0) {
                    hashSet.add(word);
                    linkedHashSet.add(word);
                    treeSet.add(word);
                }
            }
        }
        System.out.println("HashSet:");
        System.out.println(hashSet);
        System.out.println("TreeSet:");
        System.out.println(linkedHashSet);
        System.out.println("LinkedHashSet:");
        System.out.println(treeSet);
    }

}
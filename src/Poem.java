public class Poem {

    private final String[] poem;

    Poem(String[] str) {
        this.poem = str;
    }

    public void findRhymes() {
        Punctuation();
        for (int n = 0; n < poem.length; n++) {
            for (int i = 0; i < poem.length && i != n; i++) {
                String str1, str2;
                if (poem[n].length() < 3) {
                    str1 = poem[n];
                }
                else {
                    str1 = poem[n].substring(poem[n].length() - 3);
                }
                if (poem[i].length() < 3) {
                    str2 = poem[i];
                }
                else {
                    str2 = poem[i].substring(poem[i].length() - 3);
                }
                if (str1.equals(str2)) System.out.println("Строка " + (i + 1) + " рифмуется со строкой " + (n + 1));
            }
        }
    }

    private void Punctuation() {
        for (int i=0; i < poem.length; i++) {
            poem[i] = poem[i].replaceAll("[^A-zА-я0-9\\s]","");
        }
    }

}


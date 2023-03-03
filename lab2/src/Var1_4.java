import java.util.Scanner;

public class Var1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of words to input: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter a word: ");
            words[i] = scanner.nextLine();
        }

        String minDistinctWord = words[0];
        int minDistinct = Integer.MAX_VALUE;
        for (String word : words) {
            int distinct = countDistinctCharacters(word);
            if (distinct < minDistinct) {
                minDistinct = distinct;
                minDistinctWord = word;
            }
        }
        System.out.println("Word with smallest number of distinct characters: " + minDistinctWord);

        System.out.println(Var1_3.GetMetaData());

        scanner.close();
    }

    private static int countDistinctCharacters(String word) {
        boolean[] seen = new boolean[256];
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i);
            if (!seen[c]) {
                seen[c] = true;
                count++;
            }
        }
        return count;
    }
}
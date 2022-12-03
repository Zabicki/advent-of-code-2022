import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BackpackChecker {

    private static final String INPUT_PATH = "day_03/src/main/resources/input.txt";

    public static void main(String[] args) throws IOException {
        BackpackChecker checker = new BackpackChecker();
        List<String> lines = Files.readAllLines(Paths.get(INPUT_PATH));

        // first task
        System.out.println(checker.check(lines));
        // second task
        System.out.println(checker.checkGroup(lines));
    }

    public int check(List<String> lines) {
        int sum = 0;

        for (String line : lines) {
            String compartment1 = line.substring(0, line.length() / 2);
            String compartment2 = line.substring(line.length() / 2);

            StringBuilder commonItems = new StringBuilder();
            for (int i = 0; i < compartment1.length(); i++) {
                char item1 = compartment1.charAt(i);
                if (compartment2.contains(String.valueOf(item1))) {
                    boolean isRepeat = false;
                    for (int j = 0; j < commonItems.length(); j++) {
                        if (commonItems.charAt(j) == item1) {
                            isRepeat = true;
                        }
                    }
                    if (!isRepeat) {
                        commonItems.append(item1);
                    }
                }
            }

            for (int i = 0; i < commonItems.length(); i++) {
                char key = commonItems.charAt(i);
                if (key >= 65 && key <= 90) {
                    sum += key - 38;
                } else {
                    sum += key - 96;
                }
            }
        }

        return sum;
    }

    public int checkGroup(List<String> lines) {
        int sum = 0;

        for (int d = 0; d < lines.size(); d += 3) {
            String elf1 = lines.get(d);
            String elf2 = lines.get(d + 1);
            String elf3 = lines.get(d + 2);

            // check for A-Z
            for (char a = 65; a <= 90; a++) {
                String key = String.valueOf(a);
                if (elf1.contains(key) && elf2.contains(key) && elf3.contains(key)) {
                    sum += a - 38;
                }
            }

            // check for a-z
            for (char a = 97; a <= 122; a++) {
                String key = String.valueOf(a);
                if (elf1.contains(key) && elf2.contains(key) && elf3.contains(key)) {
                    sum += a - 96;
                }
            }
        }

        return sum;
    }
}
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CalorieCounter {

    private static final String INPUT_PATH = "day_01/src/main/resources/input.txt";

    public static void main(String[] args) throws IOException {
        CalorieCounter counter = new CalorieCounter();

        // first task
        System.out.println(counter.sumTopCalories(1));
        // second task
        System.out.println(counter.sumTopCalories(3));
    }

    public int sumTopCalories(int n) throws IOException {
        List<Integer> calorieSums = new LinkedList<>();
        calorieSums.add(0);
        int elf = 0;

        for (String line : Files.readAllLines(Paths.get(INPUT_PATH))) {
            if ("".equals(line)) {
                calorieSums.add(0);
                ++elf;
            } else {
                calorieSums.set(elf, calorieSums.get(elf) + Integer.parseInt(line));
            }
        }
        return calorieSums.stream()
                .sorted(Comparator.reverseOrder())
                .limit(n)
                .reduce(Integer::sum).orElse(0);
    }
}

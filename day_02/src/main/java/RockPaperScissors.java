import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RockPaperScissors {

    private static final String INPUT_PATH = "day_02/src/main/resources/input.txt";

    public static void main(String[] args) throws IOException {
        RockPaperScissors calc = new RockPaperScissors();
        List<String> lines = Files.readAllLines(Paths.get(INPUT_PATH));

        System.out.println(calc.strategyA(lines));
        System.out.println(calc.strategyB(lines));
    }

    public int strategyA(List<String> lines) {
        int totalPoints = 0;

        for (String line : lines) {
            String[] shapes = line.split(" ");
            switch (shapes[0]) {
                case "A":
                    switch (shapes[1]) {
                        case "X" -> totalPoints += (1 + 3);
                        case "Y" -> totalPoints += (2 + 6);
                        case "Z" -> totalPoints += (3 + 0);
                    }
                    break;
                case "B":
                    switch (shapes[1]) {
                        case "X" -> totalPoints += (1 + 0);
                        case "Y" -> totalPoints += (2 + 3);
                        case "Z" -> totalPoints += (3 + 6);
                    }
                    break;
                case "C":
                    switch (shapes[1]) {
                        case "X" -> totalPoints += (1 + 6);
                        case "Y" -> totalPoints += (2 + 0);
                        case "Z" -> totalPoints += (3 + 3);
                    }
                    break;
            }
        }

        return totalPoints;
    }

    public int strategyB(List<String> lines) {
        int totalPoints = 0;

        for (String line : lines) {
            String[] shapes = line.split(" ");
            switch (shapes[0]) {
                case "A":
                    switch (shapes[1]) {
                        case "X" -> totalPoints += (3 + 0);
                        case "Y" -> totalPoints += (1 + 3);
                        case "Z" -> totalPoints += (2 + 6);
                    }
                    break;
                case "B":
                    switch (shapes[1]) {
                        case "X" -> totalPoints += (1 + 0);
                        case "Y" -> totalPoints += (2 + 3);
                        case "Z" -> totalPoints += (3 + 6);
                    }
                    break;
                case "C":
                    switch (shapes[1]) {
                        case "X" -> totalPoints += (2 + 0);
                        case "Y" -> totalPoints += (3 + 3);
                        case "Z" -> totalPoints += (1 + 6);
                    }
                    break;
            }
        }

        return totalPoints;
    }
}
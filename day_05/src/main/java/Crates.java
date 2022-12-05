import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Crates {

    private static final String INPUT_PATH = "day_05/src/main/resources/input.txt";

    private final List<Stack<String>> stacks = List.of(
            new Stack<>(),
            new Stack<>(),
            new Stack<>(),
            new Stack<>(),
            new Stack<>(),
            new Stack<>(),
            new Stack<>(),
            new Stack<>(),
            new Stack<>()
    );

    public Crates() {
        stacks.get(0).addAll(List.of("G", "F", "V", "H", "P", "S"));
        stacks.get(1).addAll(List.of("G", "J", "F", "B", "V", "D", "Z", "M"));
        stacks.get(2).addAll(List.of("G", "M", "L", "J", "N"));
        stacks.get(3).addAll(List.of("N", "G", "Z", "V", "D", "W", "P"));
        stacks.get(4).addAll(List.of("V", "R", "C", "B"));
        stacks.get(5).addAll(List.of("V", "R", "S", "M", "P", "W", "L", "Z"));
        stacks.get(6).addAll(List.of("T", "H", "P"));
        stacks.get(7).addAll(List.of("Q", "R", "S", "N", "C", "H", "Z", "V"));
        stacks.get(8).addAll(List.of("F", "L", "G", "P", "V", "Q", "J"));
    }

    public static void main(String[] args) throws IOException {
        Crates crates = new Crates();
        List<String> lines = Files.readAllLines(Paths.get(INPUT_PATH));

        System.out.println(crates.rearrangeStacks(lines));
    }

    public String rearrangeStacks(List<String> lines) {
        for (String line : lines) {
            String[] elems = line.split(" ");
            int quantity = Integer.parseInt(elems[1]);
            int from = Integer.parseInt(elems[3]);
            int to = Integer.parseInt(elems[5]);

            Stack<String> stackFrom = stacks.get(from - 1);
            Stack<String> stackTo = stacks.get(to - 1);

            List<String> popped = new LinkedList<>();
            for (int i = 0; i < quantity; i++) {
                popped.add(stackFrom.pop());
            }

            // reverse for second task
            Collections.reverse(popped);
            stackTo.addAll(popped);
        }

        StringBuilder builder = new StringBuilder();
        stacks.forEach(stack -> builder.append(stack.pop()));

        return builder.toString();
    }
}
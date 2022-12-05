import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CampCleanup {

    private static final String INPUT_PATH = "day_04/src/main/resources/input.txt";

    public static void main(String[] args) throws IOException {
        CampCleanup cleanup = new CampCleanup();
        List<String> lines = Files.readAllLines(Paths.get(INPUT_PATH));

        // first task
        System.out.println(cleanup.findFullOverlaps(lines));
        // second task
        System.out.println(cleanup.findAnyOverlaps(lines));
    }

    public int findFullOverlaps(List<String> lines) {
        int counter = 0;

        for (String line : lines) {
            String[] ranges = line.split(",");
            String[] range1 = ranges[0].split("-");
            String[] range2 = ranges[1].split("-");

            int start1 = Integer.parseInt(range1[0]);
            int end1 = Integer.parseInt(range1[1]);

            int start2 = Integer.parseInt(range2[0]);
            int end2 = Integer.parseInt(range2[1]);

            if (start1 >= start2 && end1 <= end2 ||
                    start2 >= start1 && end2 <= end1) {
                counter++;
            }
        }

        return counter;
    }

    public int findAnyOverlaps(List<String> lines) {
        int counter = 0;

        for (String line : lines) {
            String[] ranges = line.split(",");
            String[] range1 = ranges[0].split("-");
            String[] range2 = ranges[1].split("-");

            int start1 = Integer.parseInt(range1[0]);
            int end1 = Integer.parseInt(range1[1]);

            int start2 = Integer.parseInt(range2[0]);
            int end2 = Integer.parseInt(range2[1]);

            if (start1 <= start2 && end1 >= start2 ||
                    start2 <= start1 && end2 >= start1) {
                counter++;
            }
        }

        return counter;
    }
}
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Developed by Monty");

        List<String> lines = Arrays.asList(
                "Name,Marks",
                "Alice,85",
                "Bob,70",
                "Charlie,90",
                "David,60",
                "Emma,95"
        );

        List<String[]> records = lines.stream()
                .skip(1)
                .map(line -> line.split(","))
                .toList();

        records.forEach(r -> System.out.println(r[0] + " - " + r[1]));

        double avg = records.stream()
                .mapToInt(r -> Integer.parseInt(r[1]))
                .average()
                .orElse(0);

        System.out.println("Average Marks: " + avg);

        records.stream()
                .filter(r -> Integer.parseInt(r[1]) > 80)
                .forEach(r -> System.out.println("Above 80: " + r[0]));
    }
}

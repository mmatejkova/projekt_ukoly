package pro1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvGenerator {
    public static void generateCsv(List<ExamRecord> records, String outputPath) throws IOException {
        try (FileWriter writer = new FileWriter(outputPath)) {
            for (ExamRecord record : records) {
                writer.append(record.getName())
                        .append(",")
                        .append(record.getScore().toString())  // Výsledek zlomku
                        .append("\n");
            }
        }
    }
}
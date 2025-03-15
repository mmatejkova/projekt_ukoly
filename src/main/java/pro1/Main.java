package pro1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // Složka pro vstupy
        File inputDir = new File("/Users/matejkova/Documents/GitHub/data/input");
        File[] inputFiles = inputDir.listFiles((dir, name) -> name.endsWith(".txt")); // Čteme pouze .txt soubory

        // Pokud existují soubory ve složce input
        if (inputFiles != null && inputFiles.length > 0) {
            for (File inputFile : inputFiles) {
                System.out.println("Reading " + inputFile);

                // Zpracování souboru do pole záznamů
                ExamRecord[] records = readInputFile(inputFile.toPath());

                // Generování výstupního souboru v /output
                String outputFilePath = inputFile.getAbsolutePath()
                        .replace("input", "output") // nahrazení složky input za output
                        .replace(".txt", ".csv");  // změna přípony souboru na .csv

                // Ujistíme se, že složka output existuje, pokud ne, vytvoříme ji
                File outputDir = new File("/Users/matejkova/Documents/GitHub/data/output");
                if (!outputDir.exists()) {
                    outputDir.mkdirs();
                }

                // Generování CSV souboru
                CsvGenerator.generateCsv(List.of(records), outputFilePath);
                System.out.println("Output written to " + outputFilePath);
            }
        } else {
            System.out.println("No input files found.");
        }
    }

    // Metoda pro načtení souboru
    public static ExamRecord[] readInputFile(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);  // Načte všechny řádky souboru
        List<ExamRecord> resultList = new ArrayList<>();

        // Zpracování každého řádku
        for (String line : lines) {
            String[] split = line.split("[:=;]");  // Rozdělení podle oddělovačů
            resultList.add(new ExamRecord(
                    split[0], // Jméno
                    Fraction.parse(split[1])  // Výsledek jako zlomek
            ));
        }

        // Vrací pole záznamů
        return resultList.toArray(new ExamRecord[0]);
    }
}

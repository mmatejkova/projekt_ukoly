package pro1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {

    public static void exportDataToCsv(List<String> data)
    {
        String outputFilePath = "C:/data/output/output.csv";
        try (FileWriter writer = new FileWriter(outputFilePath))
        {
            for (String row : data)
            {
                writer.append(row);
                writer.append("\n");
            }
            System.out.println("Data byla úspěšně exportována do " + outputFilePath);
        }
        catch (IOException e)
        {
            System.err.println("Chyba při exportování dat: " + e.getMessage());
        }
    }
}

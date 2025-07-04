package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

    public void write(FileWriter writer, List<CSVable> csvs) throws IOException {
        if (csvs == null)
            return;

        for (CSVable csv : csvs) {
            writer.write(csv.toCsv());
        }
    }
}

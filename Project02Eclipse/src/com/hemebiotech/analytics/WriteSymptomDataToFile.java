package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
/**
 * Implementation of ISymptomWriter that writes symptom data to a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filepath;

    /**
     * Constructor for WriteSymptomDataToFile.
     *
     * @param filepath the file path to write to
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }
    /**
     * Writes symptoms to a file.
     *
     * @param symptoms map of symptom counts
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

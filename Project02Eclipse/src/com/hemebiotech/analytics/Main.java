package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;


/**
 * Main class to run the analytics.
 */
public class Main {

    /**
     * Main method to execute the analytics process.
     *
     * @param args command line arguments
     */

    public static void main(String[] args) {
        try {
            // Instantiate the reader and writer
            ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
            ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

            // Instantiate AnalyticsCounter
            AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

            // Retrieve symptoms
            List<String> symptoms = analyticsCounter.getSymptoms();

            // Count symptom occurrences
            Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptoms);

            // Sort symptoms alphabetically
            Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCounts);

            // Write results to file
            analyticsCounter.writeSymptoms(sortedSymptoms);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


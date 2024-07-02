package com.hemebiotech.analytics;
import java.util.Map;

/**
 * Interface for writing symptom data.
 */

public interface ISymptomWriter {

    /**
     * Writes symptoms to a destination.
     *
     * @param symptoms map of symptom counts
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}

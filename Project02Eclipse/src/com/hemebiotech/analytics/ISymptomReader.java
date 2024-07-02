package com.hemebiotech.analytics;

import java.util.List;
/**
 * Interface for reading symptom data.
 */
public interface ISymptomReader {
/**
 * Reads symptoms from a source.
   * @return a list of symptoms
 */

	List<String> readSymptoms();
}

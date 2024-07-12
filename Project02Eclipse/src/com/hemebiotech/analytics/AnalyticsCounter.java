package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
/**
 * Class responsible for analyzing symptoms data.
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;
	/**
	 * Constructor for AnalyticsCounter.
	 *
	 * @param reader the symptom reader
	 * @param writer the symptom writer
	 */

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Retrieves the list of symptoms.
	 *
	 * @return a list of symptoms
	 */

	public List<String> getSymptoms() {
		return reader.readSymptoms();
	}
	/**
	 * Counts the occurrences of each symptom.
	 *
	 * @param symptoms list of symptoms
	 * @return a map of symptom counts
	 */

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
	Map<String, Integer> mapSymptoms = new HashMap<>();
	for( String symptom: symptoms){

		mapSymptoms.put(symptom,mapSymptoms.getOrDefault(symptom, 0)+1);
	}
	return mapSymptoms;

	}

	/**
	 * Sorts the symptoms by alphabetical order.
	 *
	 * @param symptoms map of symptom counts
	 * @return a sorted map of symptom counts
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}
	/**
	 * Writes the symptoms data to a file.
	 *
	 * @param symptoms map of symptom counts
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}

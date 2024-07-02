package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Implementation of ISymptomReader that reads symptom data from a file.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;
	/**
	 * Constructor for ReadSymptomDataFromFile.
	 *
	 * @param filepath the file path to read from
	 */

	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}
	/**
	 * Reads symptoms from a file.
	 *
	 * @return a list of symptoms
	 */
	@Override
	public List<String> readSymptoms() {
		List<String> result = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				result.add(line);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
}

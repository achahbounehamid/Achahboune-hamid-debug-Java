package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Implémentation de ISymptomReader pour lire les symptômes depuis un fichier

public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;
	

	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

    @Override
	public  Map<String, Integer> countSymptoms() {
		Map<String, Integer> symptomCount = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				symptomCount.put(line, symptomCount.getOrDefault(line, 0) + 1);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return symptomCount;
	}

}

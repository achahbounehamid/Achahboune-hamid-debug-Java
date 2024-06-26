package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Classe principale qui lit les symptômes, les compte et écrit les résultats dans un fichier

public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {
		// Lire les symptômes à partir du fichier
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptoms = reader.getSymptoms();

		// Compter les symptômes
		Map<String, Integer> symptomCounts = new HashMap<>();
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}

		// Écrire les résultats dans un fichier
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		writer.writeSymptoms(symptomCounts);
	}
}

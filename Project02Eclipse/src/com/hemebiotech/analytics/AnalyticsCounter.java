package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	// Constructeur qui prend des objets ISymptomReader et ISymptomWriter comme paramètres
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	// Méthode pour récupérer la liste des symptômes
	public List<String> getSymptoms() {
		return reader.readSymptoms();
	}

	// Méthode pour compter les occurrences de chaque symptôme
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>();
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}
		return symptomCounts;
	}

	// Méthode pour trier les symptômes par ordre alphabétique
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	// Méthode pour écrire les résultats dans le fichier de sortie
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

	// Méthode main refactorisée
	public static void main(String[] args) throws Exception {
		// Initialisation des lecteurs et écrivains de symptômes
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");


	}
}

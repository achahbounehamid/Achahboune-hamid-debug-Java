package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            // Instanciation des objets ISymptomReader et ISymptomWriter
            ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
            ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

            // Instanciation de l'objet AnalyticsCounter
            AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

            // Récupération des symptômes
            List<String> symptoms = analyticsCounter.getSymptoms();

            // Comptage des occurrences de chaque symptôme
            Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptoms);

            // Tri des symptômes par ordre alphabétique
            Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCounts);

            // Écriture des résultats dans le fichier de sortie
            analyticsCounter.writeSymptoms(sortedSymptoms);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


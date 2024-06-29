package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

//Interface pour lire les symptômes à partir d'une source de données
public interface ISymptomReader {

	Map<String, Integer> countSymptoms();
}
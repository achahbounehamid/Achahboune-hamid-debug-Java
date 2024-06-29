package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

//Interface pour écrire les symptômes et leurs comptes dans un fichier


public interface ISymptomWriter {

    void writeSymptomCountsToFile(Map<String, Integer> symptomCount);
}
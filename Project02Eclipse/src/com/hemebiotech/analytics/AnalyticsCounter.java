package com.hemebiotech.analytics;

//Classe principale qui lit les symptômes, les compte et écrit les résultats dans un fichier

public class AnalyticsCounter {

	public static void main(String[] args) throws Exception {

		// read
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		var res = reader.countSymptoms();

        // write
		ISymptomWriter writer = new WriteSymptomDataToFile("resoult.out");
		writer.writeSymptomCountsToFile(res);



	}





}

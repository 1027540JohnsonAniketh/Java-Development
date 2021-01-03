package edu.neu.csye6200.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.neu.csye6200.model.Regulations;

public class RegulationsController {
	
	public static List<Regulations> rules = new ArrayList<>();
	
	private static final File RATIO_RULES_CSV = new File("RatioRules.csv");
	
	public static void createRules() {
		try {
			try (BufferedReader csvReader = new BufferedReader(new FileReader(RATIO_RULES_CSV))) {
				String row;
				while((row = csvReader.readLine()) != null) {
					rules.add(new Regulations(row));
				}
			}
		} catch (IOException e) {
			System.exit(1);
		}
	}
        
}

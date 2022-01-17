package com.bridgelabz.censusanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {

	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndianStatesCensus.csv";
	
	
	@Test
	public void givenIndianCensusCSVFile_WhenCorrectPath_ShouldReturnCorrectRecords() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(33, numOfRecords);
		} 
		catch (CensusAnalyserException e) {
		}
	}

}

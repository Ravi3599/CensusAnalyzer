package com.bridgelabz.censusanalyzer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {

	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndianStatesCensus.csv";
	private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndianStatesCensusData.csv";
	
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
	@Test
	public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
		try {
			CensusAnalyser censusAnalyser = new CensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
		} 
		catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
			e.printStackTrace();
		}
	}
	

}

package com.bridgelabz.indianstatecensus;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/*********************************************
 * @author Pavani
 *
 * This class holds all the test cases,
 * that validates methods present in a project.
 *********************************************/

public class IndianStateCensusAnalyzerTest {
    @Test
    public void givenReadDataFromIndianCensus_ShouldReturnCountDataPresentInFile() {
        String fileName = "/IndiaStateCensusData.csv";
        IndianStateCensusAnalyzer censusService = new IndianStateCensusAnalyzer();
        List<StateCensus> stateCensusList = censusService.readInIndiaStateCensusData(fileName);
        Assert.assertEquals(29, stateCensusList.size());
    }

    @Test
    public void givenWrongFile_ShouldReturnFileNotFound() {
        String fileName = "/IndiaStateCensus.csv";
        IndianStateCensusAnalyzer censusService = new IndianStateCensusAnalyzer();
        try {
            List<StateCensus> stateCensusList = censusService.readInIndiaStateCensusData(fileName);
            Assert.assertEquals(29, stateCensusList.size());
        }
        catch (CustomExceptionService e) {
            Assert.assertEquals(CustomExceptionService.ExceptionType.FILE_NOT_FOUND, e.type);
        }
    }

    @Test
    public void givenWrongFileExtention_ShouldReturnWrongFileType() {
        String fileName = "/IndiaStateCensusData.txt";
        IndianStateCensusAnalyzer censusService = new IndianStateCensusAnalyzer();
        try {
            List<StateCensus> stateCencesList = censusService.readInIndiaStateCensusData(fileName);
            Assert.assertEquals(29, stateCencesList.size());
        }
        catch (CustomExceptionService e)
        {
            Assert.assertEquals(CustomExceptionService.ExceptionType.WRONG_FILE_TYPE, e.type);
        }
    }
}
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
        IndianStateCensusAnalyzer censusService = new IndianStateCensusAnalyzer();
        List<StateCensus> stateCensusList = censusService.readInIndiaStateCensusData();
        Assert.assertEquals(29, stateCensusList.size());
    }
}
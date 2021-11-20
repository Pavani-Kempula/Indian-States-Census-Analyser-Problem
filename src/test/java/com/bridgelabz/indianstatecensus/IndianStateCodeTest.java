package com.bridgelabz.indianstatecensus;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class IndianStateCodeTest {
    @Test
    public void givenReadDataFromIndianCensus_ShouldReturnCountDataPresentInFile()
    {
        String fileName = "/StateCode.csv";
        IndianStateCodeService codeService = new IndianStateCodeService();
        List<StateCode> stateCensusList = codeService.readIndiaStatCode(fileName);
        Assert.assertEquals(37, stateCensusList.size());
    }
}
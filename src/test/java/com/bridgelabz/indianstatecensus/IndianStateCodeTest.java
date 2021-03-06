package com.bridgelabz.indianstatecensus;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class IndianStateCodeTest {
    @Test
    public void givenReadDataFromIndianCensus_ShouldReturnCountDataPresentInFile() {
        String fileName = "/StateCode.csv";
        IndianStateCodeService codeService = new IndianStateCodeService();
        List<StateCode> stateCensusList = codeService.readIndiaStatCode(fileName);
        Assert.assertEquals(37, stateCensusList.size());
    }

    @Test
    public void givenWrongFileExtention_ShouldReturnWrongFileType() {
        String fileName = "/StateCodeData.txt";
        IndianStateCodeService censusService = new IndianStateCodeService();
        try {
            List<StateCode> StateCodeList = censusService.readIndiaStatCode(fileName);
            Assert.assertEquals(37, StateCodeList.size());
        }
        catch (CustomExceptionService e) {
            Assert.assertEquals(CustomExceptionService.ExceptionType.WRONG_FILE_TYPE, e.type);
        }
    }

    @Test
    public void givenWrongFile_ShouldReturnFileNotFound() {
        String fileName = "/StateCodeing.csv";
        IndianStateCodeService censusService = new IndianStateCodeService();
        try {
            List<StateCode> StateCodeList = censusService.readIndiaStatCode(fileName);
            Assert.assertEquals(37, StateCodeList.size());
        }
        catch (CustomExceptionService e) {
            Assert.assertEquals(CustomExceptionService.ExceptionType.FILE_NOT_FOUND, e.type);
        }
    }

    @Test
    public void givenWrongFileHeaders_ShouldReturnWrongHeader() {
        String fileName = "/IndiaStateCensusDataWrongHeaders.csv";
        IndianStateCodeService codeService = new IndianStateCodeService ();
        try {
            List<StateCode> stateCodeList = codeService.readIndiaStatCode(fileName);
            Assert.assertEquals(37, stateCodeList.size());
        }
        catch (CustomExceptionService e) {
            Assert.assertEquals(CustomExceptionService.ExceptionType.WRONG_HEADER, e.type);
        }
    }
}
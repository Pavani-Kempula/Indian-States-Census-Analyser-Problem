package com.bridgelabz.indianstatecensus;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IndianStateCensusAnalyzer {
    private static final String FILE_PATH = "C:\\Users\\Pavani\\IdeaProjects\\IndianStatesCensusAnalyser\\src\\resources";
    private static final String INDIAN_STATE_CENCUS = "/IndiaStateCensusData.csv";

    public List<StateCensus> readInIndiaStateCensusData() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH+INDIAN_STATE_CENCUS));
            CsvToBean<StateCensus> csvToBean;
            csvToBean = new CsvToBeanBuilder<StateCensus>(reader)
                    .withType(StateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
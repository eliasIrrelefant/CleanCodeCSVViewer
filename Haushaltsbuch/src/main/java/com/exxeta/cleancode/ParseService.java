package com.exxeta.cleancode;

import java.util.ArrayList;
import java.util.List;

public class ParseService {

    public List<BankingPosition> parseToPositions(String[] dataset) {
        List<BankingPosition> resultPositions = new ArrayList<>();
        for (String data : dataset) {
            String[] dataEntry = data.split(";");

            resultPositions.add(parseToPosition(dataEntry));
        }
        return resultPositions;
    }

    private BankingPosition parseToPosition(String[] dataEntry) {
        BankingPosition positionEntry = new BankingPosition();
        positionEntry.name = dataEntry[0];
        positionEntry.value = Long.parseLong(dataEntry[1]);
        return positionEntry;
    }

    private String parseToDataEntry(BankingPosition bankingPosition) {
        return bankingPosition.name + ";" + bankingPosition.value;
    }

    public String[] parseToDataSet(List<BankingPosition> positions) {
        String[] resultDataset = new String[positions.size()];

        for (int i = 0; i < positions.size(); i++) {
            resultDataset[i] = parseToDataEntry(positions.get(i));
        }

        return resultDataset;
    }
}

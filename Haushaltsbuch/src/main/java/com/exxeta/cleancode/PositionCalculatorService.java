package com.exxeta.cleancode;

import java.util.ArrayList;
import java.util.List;

public class PositionCalculatorService {

    private BankingPosition subtractValue(BankingPosition bankingPosition, Long newValue) {
        bankingPosition.value -= newValue;
        return bankingPosition;
    }

    private BankingPosition addValue(BankingPosition bankingPosition, Long newValue) {
        bankingPosition.value += newValue;
        return bankingPosition;
    }

    private BankingPosition getCategoryBankingPosition(List<BankingPosition> bankingPositions, String category) {
        return bankingPositions
            .stream()
            .filter(bankingPosition -> bankingPosition.name.equals(category))
            .findFirst()
            .orElse(null);
    }


    public List<BankingPosition> handleDepositAction(List<BankingPosition> bankingPositions, Long depositAmount) {
        List<BankingPosition> resultPositions = new ArrayList<>();

        BankingPosition bankingSummary = getCategoryBankingPosition(bankingPositions, "Kassenbestand");
        addValue(bankingSummary, depositAmount);

        resultPositions.add(bankingSummary);
        return resultPositions;
    }

    public List<BankingPosition> handleWithdrawalAction(List<BankingPosition> bankingPositions, String withdrawalCategory,
        Long withdrawValue) {
        List<BankingPosition> resultPositions = new ArrayList<>();


        BankingPosition categoryPosition = getCategoryBankingPosition(bankingPositions, withdrawalCategory);
        categoryPosition.value -= withdrawValue;


        BankingPosition bankingSummary = getCategoryBankingPosition(bankingPositions, "Kassenbestand");
        bankingSummary.value -= withdrawValue;


        resultPositions.add(categoryPosition);
        resultPositions.add(bankingSummary);


        return resultPositions;
    }

    public List<BankingPosition> updatePositionsListForChangedBankingPositions(List<BankingPosition> oldPositions,
        List<BankingPosition> newPositions) {
        newPositions.forEach(newPosition -> {
            int positionIndex = oldPositions.indexOf(newPosition);
            oldPositions.set(positionIndex, newPosition);
        });

        return oldPositions;
    }
}

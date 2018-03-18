package com.exxeta.cleancode;

import java.util.List;

public class UIService {

    public void printOverview(List<BankingPosition> bankingPositions){
        System.out.print("Overview");
    }

    public void printWithdrawal(List<BankingPosition> bankingPositions){
        System.out.print("Banking");
    }

    public void printDeposit(List<BankingPosition> bankingPosition) {
        System.out.print("Banking");

    }
}

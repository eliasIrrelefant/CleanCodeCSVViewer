package com.exxeta.cleancode;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class OperatorService {
    DataReader dataReader = new DataReader();
    ParseService parseService = new ParseService();
    UIService uiService = new UIService();
    PositionCalculatorService positionCalculatorService = new PositionCalculatorService();
    DataWriter dataWriter = new DataWriter();

    public static ProgramMode applicationMode;

    public void processParameters(String[] args) {
        Date determinedDate = determineDate(args[2]);
        String determinedFilename = determineFilename(determinedDate);


        String[] dataset = dataReader.readDataset(determinedFilename);
        List<BankingPosition> bankingPositionList = parseService.parseToPositions(dataset);


        // #TODO ist es unprofessionell cases ohne break zu machen ?
        switch (setMode(args[1].toLowerCase())) {
            case DEPOSIT:
                Long depositAmount = getAmountFromArguments(determinedDate, args);
                List<BankingPosition> relevantPositionsForUI =
                    positionCalculatorService.handleDepositAction(bankingPositionList, depositAmount);


                List<BankingPosition> updatedList = positionCalculatorService.updatePositionsListForChangedBankingPositions(bankingPositionList, relevantPositionsForUI);
                String[] datasetOfUpdatedList = parseService.parseToDataSet(updatedList);
                dataWriter.writeDataset(datasetOfUpdatedList, determinedFilename);

                uiService.printDeposit(relevantPositionsForUI);
                break;
            case WITHDRAWAL:
                String category = getCategoryFromArguments(determinedDate, args);
                Long withdrawAmount = getAmountFromArguments(determinedDate, args);
                List<BankingPosition> relevantPositionListForUI =
                    positionCalculatorService.handleWithdrawalAction(bankingPositionList, category, withdrawAmount);



                uiService.printWithdrawal(relevantPositionListForUI);
                break;
            case OVERVIEW:
                uiService.printOverview(bankingPositionList);
                break;
            case INVALID:
                break;
            default:
                // #TODO something
        }



    }

    private Long getAmountFromArguments(Date determinedDate, String[] args) {
        // #TODO handle parse exception
        if (determinedDate == null) {
            return Long.parseLong(args[4]);
        } else {
            return Long.parseLong(args[5]);
        }
    }

    private String getCategoryFromArguments(Date determinedDate, String[] args) {
        if (determinedDate == null) {
            return args[3];
        } else {
            return args[4];
        }
    }


    private ProgramMode setMode(String modeArgument) {
        if (modeArgument.equals("auszahlung")) {
            return ProgramMode.WITHDRAWAL;
        } else if (modeArgument.equals("einzahlung")) {
            return ProgramMode.DEPOSIT;
        } else if (modeArgument.equals("übersicht")) {
            return ProgramMode.OVERVIEW;
        }
        return ProgramMode.INVALID;
    }

    private Date determineDate(String secondArgument) {
        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy", Locale.GERMAN);
        try {
            return dateFormat.parse(secondArgument);
        } catch (ParseException e) {
            return null;
        }
    }

    private String determineFilename(Date date) {
        if (date == null) {
            return "overallfilename.csv";
        } else {
            //            #TODO get filename for monthly files
            return null;
        }
    }


}

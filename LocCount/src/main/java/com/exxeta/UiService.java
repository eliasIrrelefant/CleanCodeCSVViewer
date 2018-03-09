package com.exxeta;

import java.util.List;

public class UiService {

    void printLocStats(List<LocStat> locStats) {
        int totalLines = 0;
        int totalLOC = 0;

        for(LocStat locStat : locStats) {
            totalLines += locStat.getTotal();
            totalLOC += locStat.getTotalLoc();
            System.out.println(locStat.toString());
        }
        System.out.println("Total Lines: " + totalLines);
        System.out.println("Total Lines of Code: " + totalLOC);
    }
}

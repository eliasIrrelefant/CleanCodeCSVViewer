package com.exxeta;

import java.util.List;

public class App {
    public static void main(String[] args) {
        LocCountService locCountService = new LocCountService();
        UiService uiService = new UiService();

        List<LocStat> locStats = locCountService.countLoc(args);

        uiService.printLocStats(locStats);
    }
}

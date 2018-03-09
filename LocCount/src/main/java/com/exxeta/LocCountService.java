package com.exxeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class LocCountService {
    private FileReader fileReader = new FileReader();
    private ArgsHelper argsHelper = new ArgsHelper();

    List<LocStat> countLoc(String[] args) {
        String path = argsHelper.getPath(args);
        List<File> files = fileReader.getSourceCodeFiles(path);
        return createLocStats(files);
    }

    void countLoc(String[] args, Consumer<LocStat> onLocStat, Runnable onFinished) throws IOException {
        String path = argsHelper.getPath(args);

        Consumer<File> onFile = file -> onLocStat.accept(createLocStat(file));
        fileReader.getSourceCodeFiles(path, onFile, onFinished);
    }


    List<LocStat> createLocStats(List<File> files) {
        List<LocStat> locStats = new ArrayList<LocStat>();

        for (File file : files) {
            locStats.add(createLocStat(file));
        }
        return locStats;
    }

    LocStat createLocStat(File file) {
        List<String> lines = fileReader.readFile(file);
        LocStat locStat = countLoc(lines);
        locStat.setFilename(file.getName());
        return locStat;
    }

    LocStat countLoc(List<String> lines) {
        LocStat locStat = new LocStat();
        locStat.setTotal(lines.size());

        int totalLoc = 0;
        for (String line : lines) {
            if (isLoc(line)) {
                totalLoc++;
            }
        }
        locStat.setTotalLoc(totalLoc);
        return locStat;
    }

    boolean isLoc(String line) {
        String trimmedLine = line.trim();
        return !trimmedLine.isEmpty() && !trimmedLine.startsWith("//");
    }
}

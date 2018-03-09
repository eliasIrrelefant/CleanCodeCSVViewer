package com.exxeta;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    List<String> readFile(File file) {
        List<String> lines = new ArrayList<>();
        try {
             lines =Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    List<File> getSourceCodeFiles(String path) {
        List<File> files = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            files = paths.filter(Files::isRegularFile)
                .map(Path::toFile)
                .filter(file -> file.getName().endsWith(".java"))
                .collect(Collectors.toList());

        } catch (IOException ex) {

        }

        return files;
    }

    void getSourceCodeFiles(String path, Consumer<File> onFile, Runnable onFinished) throws IOException {

        File file = readSourceCodeFile(path);
        String filePath = file.getCanonicalPath();

        // get files in directory
        if(file.isDirectory()) {
            getSourceCodeFiles(filePath, onFile, onFinished);
        } else {
            onFile.accept(file);
        }




        //if is directory --> recursion
        readSourceCodeFile(path);
        //if is file
        //onFile.accept(file);

        //if is finished
        onFinished.run();
    }

    File readSourceCodeFile(String path) {
        return null;
    }


}

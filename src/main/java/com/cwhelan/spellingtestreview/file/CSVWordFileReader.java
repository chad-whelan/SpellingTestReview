package com.cwhelan.spellingtestreview.file;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by chadwhelan on 1/21/15.
 */
public class CSVWordFileReader implements WordFileReader {

    private List<String> lines;

    public CSVWordFileReader(String fileName) {
        readFile(fileName);
    }

    public List<String> getFileLines() {
        return lines;
    }

    private void readFile(String fileName) {
        try {

            URI fileURI = ClassLoader.getSystemResource(fileName).toURI();
            Path filePath = Paths.get(fileURI);
            lines = Files.readAllLines(filePath, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}

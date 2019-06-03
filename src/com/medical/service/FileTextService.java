package com.medical.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileTextService {
    private static FileTextService ourInstance = new FileTextService();

    public static FileTextService getInstance() {
        return ourInstance;
    }

    private FileTextService() {
    }

    public void writeTextToFile(String textToWrite, String fileNamePath) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileNamePath, true));
            printWriter.println(textToWrite);
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException var4) {
            var4.printStackTrace();
        }

    }
}

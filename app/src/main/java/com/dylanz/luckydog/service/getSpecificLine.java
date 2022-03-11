package com.dylanz.luckydog.service;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class getSpecificLine {
    public String readLineVarFile(InputStream inputStream, int lineNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                inputStream));
        String line = reader.readLine();

        int num = 0;
        while (line != null) {
            if (lineNumber == ++num) {
                System.out.println("line     " + lineNumber + ":     " + line);
            break;
            }
            line = reader.readLine();
        }
        reader.close();
        return line;
    }

    // 文件内容的总行数。
 public int getTotalLines(InputStream inputStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                inputStream));
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }

}


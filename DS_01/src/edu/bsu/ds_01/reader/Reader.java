package edu.bsu.ds_01.reader;

import java.io.FileNotFoundException;

public interface Reader {
    String readFile(String fileName) throws FileNotFoundException;
}

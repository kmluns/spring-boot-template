package com.uns.template.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ExcelReader {

    public static Iterator<Row> read(File file) throws IOException, InvalidFormatException {
        Workbook workbook;
        workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.rowIterator();
        return rowIterator;
    }

    public static Row readAt(File file, int rowIndex) throws IOException, InvalidFormatException {
        Workbook workbook;
        workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        return sheet.getRow(rowIndex);
    }
}



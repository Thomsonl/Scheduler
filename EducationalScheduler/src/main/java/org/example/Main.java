package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        List<Account> AccountInfo = new ArrayList<>();
        AccountInfo.add(new Account("Jane123","12345678","Jane Doe","02/02/1996","A123"));
        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("Account Information");//Create a new sheet
            //Write header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Username");
            headerRow.createCell(1).setCellValue("Password");
            headerRow.createCell(2).setCellValue("Name");
            headerRow.createCell(3).setCellValue("DateOfBirth");
            headerRow.createCell(4).setCellValue("ID");

            //Write account information to the sheet
            int rowIndex = 1;
            for(Account account:AccountInfo)
            {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(account.getUsername());
                row.createCell(1).setCellValue(account.getPassword());
                row.createCell(2).setCellValue(account.getName());
                row.createCell(3).setCellValue(account.getDateOfBirth());
                row.createCell(4).setCellValue(account.getID());
            }
            //Save the workbook to a file
            try(FileOutputStream fileOutputStream = new FileOutputStream("/resources/sheet.xlsx")){
                workbook.write(fileOutputStream);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}

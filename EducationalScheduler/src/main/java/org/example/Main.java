package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void slowprint(String string) {
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(30);
            }
            catch (Exception e) {
            }
        }
    }

    public static String filePath(){
        String relativePath = "EducationalScheduler\\src\\main\\resources\\sheet.xlsx";
        String filePath = System.getProperty("user.dir") + File.separator + relativePath;
        return filePath;
    }

    public static void createaccount(){ //TODO: Needs to create a itemblock object and database row as well.
        try(Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath()))){
            if (workbook.getSheet("Account Information") == null) {
                workbook.createSheet("Account Information");//Create a new sheet
            }
            Sheet sheet = workbook.getSheetAt(0);
            //Write header row
            Row header = sheet.getRow(0);
            if (header == null) {
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Username");
                headerRow.createCell(1).setCellValue("Password");
                headerRow.createCell(2).setCellValue("Email");
                headerRow.createCell(3).setCellValue("Name");
                headerRow.createCell(4).setCellValue("DateOfBirth");
                headerRow.createCell(5).setCellValue("ID");
            }
            //Dialogue
            String username, password, email, name, dob;
            slowprint("CREATING ACCOUNT\n");
            boolean unique = true;
            do {
                slowprint("Enter a username: "); 
                username = scanner.nextLine();
                for (Row row : sheet) {
                    Cell cell = row.getCell(0);
                    if (cell != null && cell.getCellType() == CellType.STRING && username.equals(cell.getStringCellValue())) {
                        slowprint("Username already exists. Please try again.\n\n");
                        unique = false;
                        break;
                    }
                    else {
                        unique = true;
                    }
                }
            } while (!unique);
            slowprint("Enter a password: ");
            password = scanner.nextLine();
            slowprint("Enter your email: ");
            email = scanner.nextLine();
            System.out.println();

            slowprint("Now that we got that settled, lets get to know you a bit more.\n");
            slowprint("Enter your name: ");
            name = scanner.nextLine();
            slowprint("Enter your date of birth: ");
            dob = scanner.nextLine();
            System.out.println();

            slowprint("Alright, you're all set. Let's login to your new account!\n");
            Account account = new Account(username, password, email, name, dob);
            timeslot timeslotInfo = new timeslot();
            //Write account information to the sheet
            int rowIndex = 1;
            while (sheet.getRow(rowIndex) != null){
                rowIndex++;
            }
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(account.getUsername());
            row.createCell(1).setCellValue(account.getPassword());
            row.createCell(2).setCellValue(account.getEmail());
            row.createCell(3).setCellValue(account.getName());
            row.createCell(4).setCellValue(account.getDateOfBirth());
            row.createCell(5).setCellValue(account.getID());
            
            if (workbook.getSheet("Timeslot Information") == null) {
                workbook.createSheet("Timeslot Information");
            }
            Sheet sheet_timeslot = workbook.getSheetAt(1);
            //Write header row
            Row headerRow_timeSlot = sheet_timeslot.createRow(0);
            headerRow_timeSlot.createCell(0).setCellValue("ID");
            headerRow_timeSlot.createCell(1).setCellValue("Class ID"); //TODO: I am thinking of saving all the class IDs in a list and sperating them by commas when stored in excel, should be able to parse when being read back

            //Write timeslot information to the sheet
            rowIndex = 1;
            while (sheet_timeslot.getRow(rowIndex) != null){
                rowIndex++;
            }
            row = sheet_timeslot.createRow(rowIndex++);
            row.createCell(0).setCellValue(timeslotInfo.getID());
            row.createCell(1).setCellValue(timeslotInfo.getlist());

            //Save the workbook to a file
            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath())) {
                workbook.write(fileOutputStream);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Account login(){
        Account account = null;
        try (Workbook workbook = WorkbookFactory.create(new File(filePath()))) {
            Sheet sheet = workbook.getSheet("Account Information");

            boolean loginB = false;
            String username, password;
            System.out.println();
            slowprint("LOGIN\n");
            slowprint("Username: ");
            username = scanner.nextLine();
            slowprint("Password: ");
            password = scanner.nextLine();

            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.STRING && username.equals(cell.getStringCellValue()) && password.equals(row.getCell(1).getStringCellValue())) {
                    slowprint("Login successful. Welcome, " + row.getCell(3).getStringCellValue() + "!\n");
                    loginB = true;
                    account = new Account(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue(), row.getCell(4).getStringCellValue(), row.getCell(5).getNumericCellValue()); //TODO: NEEDS TO BE FIXED, ID number gets weird in excel
                    return account;
                }
            }
            if (!loginB) {
                slowprint("Incorrect username or password. Please try again.\n");
                return login();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return account;
    }

    public static timeslot timeslots(long ID) {
        timeslot timeslot = null;
        try (Workbook workbook = WorkbookFactory.create(new File(filePath()))) {
            Sheet sheet = workbook.getSheet("Timeslot Information");
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC && ID == (long) cell.getNumericCellValue()) {
                    slowprint("LOADING CLASSES\n");
                    //TODO: Timeslot needs a better constructor and ability to import all data from excel
                    //timeslot = new timeslot(row.getCell(0).getNumericCellValue());
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return timeslot;
    }

    public static void classes() {
        //print all classes
    }

    public static void main(String[] args) {
        System.out.println();

        slowprint("Welcome to The Education Management System.\n");
        System.out.println();

        slowprint("Designed and written by:\n");
        slowprint("Thomson Lee, Ling Lin, and Chang Luo\n");
        System.out.println();

        int ans;
        slowprint("Would you like to create an account or login?\n");
        slowprint("1: Create a New Account | 2: Login\n");
        ans = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        if (ans == 1) {
            createaccount();
        }
        Account account = login();
        timeslot timeslot = timeslots(account.getID());
        //timeslot.print();
        //WHILE LOOP
        //Add or drop classes?
        //Add
            //What day?
            //Display all classes
            //Enter what class you want - string
            //timeslot.addcourse(day, class)
            //timeslot.print();
        //Drop
            //What day?
            //Display classes for that day already enrolled in
            //Which class to drop? - string
            //timeslot.dropcourse(day, class)
        
        //TODO: Maybe an account settings option to change email, password and username
        scanner.close();
    }
}
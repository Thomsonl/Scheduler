package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        //Dialogue
        String username, password, email, name, dob;
        slowprint("CREATING ACCOUNT\n");
        slowprint("Enter a username: ");
        username = scanner.nextLine();
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

        //Adds info into database
        List<Account> AccountInfo = new ArrayList<>();
        AccountInfo.add(new Account(username, password, email, name, dob));
        try(Workbook workbook = new XSSFWorkbook()){//TODO: Change so it does not overwrite the file and instead checks if there is one already
            Sheet sheet = workbook.createSheet("Account Information");//Create a new sheet
            //Write header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Username");
            headerRow.createCell(1).setCellValue("Password");
            headerRow.createCell(2).setCellValue("Email");
            headerRow.createCell(3).setCellValue("Name");
            headerRow.createCell(4).setCellValue("DateOfBirth");
            headerRow.createCell(5).setCellValue("ID");

            //Write account information to the sheet
            int rowIndex = 1;
            for(Account account:AccountInfo)
            {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(account.getUsername());
                row.createCell(1).setCellValue(account.getPassword());
                row.createCell(2).setCellValue(account.getEmail());
                row.createCell(3).setCellValue(account.getName());
                row.createCell(4).setCellValue(account.getDateOfBirth());
                row.createCell(5).setCellValue(account.getID());
            }
            //Save the workbook to a file
            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath())) {
                workbook.write(fileOutputStream);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void login(){
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
                    break;
                }
            }
            if (!loginB) {
                slowprint("Incorrect username or password. Please try again.\n");
                login();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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
        login();
        scanner.close();
    }
}
package org.example;

import java.io.File;
import java.io.FileInputStream;
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

    //All scanner usages
    private static Scanner scanner = new Scanner(System.in);

    //Writes to console with delays
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

    //File path for sheet.xlsx
    public static String filePath(){
        String relativePath = "EducationalScheduler" + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "sheet.xlsx";
        String filePath = System.getProperty("user.dir") + File.separator + relativePath;
        return filePath;
    }

    //Creates Account and writes to sheet.xlsx
    public static void createaccount(){
        try(Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath()))){
            if (workbook.getSheet("Account Information") == null) {
                workbook.createSheet("Account Information");//Create a new sheet
            }
            Sheet sheet = workbook.getSheet("Account Information");
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
            timeslot timeslotInfo = new timeslot(account.getID());
            account.setSlot(timeslotInfo);

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
            headerRow_timeSlot.createCell(1).setCellValue("Monday");
            headerRow_timeSlot.createCell(2).setCellValue("Tuesday");
            headerRow_timeSlot.createCell(3).setCellValue("Wednesday");
            headerRow_timeSlot.createCell(4).setCellValue("Thursday");
            headerRow_timeSlot.createCell(5).setCellValue("Friday");
            headerRow_timeSlot.createCell(6).setCellValue("Saturday");
            headerRow_timeSlot.createCell(7).setCellValue("Sunday");

            //Write timeslot information to the sheet
            rowIndex = 1;
            while (sheet_timeslot.getRow(rowIndex) != null){
                rowIndex++;
            }
            row = sheet_timeslot.createRow(rowIndex++);
            row.createCell(0).setCellValue(account.getID());
            row.createCell(1).setCellValue(timeslotInfo.getmonday());
            row.createCell(2).setCellValue(timeslotInfo.gettuesdayday());
            row.createCell(3).setCellValue(timeslotInfo.getwednesdayday());
            row.createCell(4).setCellValue(timeslotInfo.getthursday());
            row.createCell(5).setCellValue(timeslotInfo.getfriday());
            row.createCell(6).setCellValue(timeslotInfo.getsaturdday());
            row.createCell(7).setCellValue(timeslotInfo.getsunday());       

            //Save the workbook to a file
            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath())) {
                workbook.write(fileOutputStream);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    //Updates the timeslot information in sheet.xlsx
    private static void updateTimeSlot(Account account)
    {
        try(Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath()))){
            Sheet sheet_timeslot = workbook.getSheet("Timeslot Information");
            timeslot timeslot = account.getSlot();
            int rowIndex = 1;
            if (sheet_timeslot == null) {
                slowprint("Sheet created");
                sheet_timeslot = workbook.createSheet("Timeslot Information");
            }
            Row row = sheet_timeslot.getRow(1);
            while (account.getID() != (long) row.getCell(0).getNumericCellValue()){
                rowIndex++;
                row = sheet_timeslot.getRow(rowIndex);
            }
            row.createCell(0).setCellValue(account.getID());
            row.createCell(1).setCellValue(timeslot.getmonday());
            row.createCell(2).setCellValue(timeslot.gettuesdayday());
            row.createCell(3).setCellValue(timeslot.getwednesdayday());
            row.createCell(4).setCellValue(timeslot.getthursday());
            row.createCell(5).setCellValue(timeslot.getfriday());
            row.createCell(6).setCellValue(timeslot.getsaturdday());
            row.createCell(7).setCellValue(timeslot.getsunday());
            
            //Save the workbook to a file
            try(FileOutputStream fileOutputStream = new FileOutputStream(filePath())){
                workbook.write(fileOutputStream);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    //Allows user to access their account information
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
                    account = new Account(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue(), row.getCell(4).getStringCellValue(), row.getCell(5).getNumericCellValue());
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

    //Reads and creates timeslot object from sheet.xlsx
    public static timeslot timeslots(long ID) {
        timeslot timeslot = null;
        try (Workbook workbook = WorkbookFactory.create(new File(filePath()))) {
            Sheet sheet = workbook.getSheet("Timeslot Information");
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.NUMERIC && ID == (long) cell.getNumericCellValue()) {
                    slowprint("LOADING CLASSES\n");
                    timeslot = new timeslot((int) row.getCell(0).getNumericCellValue(), row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue(), row.getCell(4).getStringCellValue(), row.getCell(5).getStringCellValue(), row.getCell(6).getStringCellValue(), row.getCell(7).getStringCellValue());
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return timeslot;
    }
    
    //Reads all courses from sheet
    public static List<classes> readClassesFromSheet() {
        File file = new File(filePath());
        if(!file.exists()){
            try (Workbook workbook = new XSSFWorkbook()){
                Sheet sheet = workbook.createSheet("Class Information");//Create a new sheet
                //Write header row
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Class Name");
                headerRow.createCell(1).setCellValue("Time Spend");
                headerRow.createCell(2).setCellValue("Class ID");
                headerRow.createCell(3).setCellValue("Professor");
                headerRow.createCell(4).setCellValue("Room");
                headerRow.createCell(5).setCellValue("Max Occupancy");
                headerRow.createCell(6).setCellValue("Current Occupancy");
                //Save the workbook to a file
                try(FileOutputStream fileOutputStream = new FileOutputStream(filePath())){
                    workbook.write(fileOutputStream);
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        List<classes> classesInfo = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(filePath())){
           
            // data is in the sheet starts from index0
            Sheet sheet = workbook.getSheet("Class Information");

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                String className = row.getCell(0).getStringCellValue();
                String timeSpend = row.getCell(1).getStringCellValue();
                int classID = (int) row.getCell(2).getNumericCellValue();
                String professor = row.getCell(3).getStringCellValue();
                String room = row.getCell(4).getStringCellValue();
                int maxOccupancy = (int) row.getCell(5).getNumericCellValue();
                int currentOccupancy = (int) row.getCell(6).getNumericCellValue();

                classes newclasses = new classes(className,timeSpend,classID,professor,room,maxOccupancy,currentOccupancy);
                classesInfo.add(newclasses);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classesInfo;
    }
    
    //Prints class information
    public static void printClassesInfo(List<classes> classInfo){
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "Class Name","Time Spend","Class ID","Professor","Room","Max Occupancy","Current Occupancy");
        for(classes c :classInfo)
        {
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n",c.getCN(),c.gettime(),c.getCID(),c.getPro(),c.getRN(),c.getMO(),c.getCO());
        }
    }

    //Searches and then outputs Class
    public static classes findClass(String classString) {
        classes theClass = null;
        try (Workbook workbook = WorkbookFactory.create(new File(filePath()))) {
            Sheet sheet = workbook.getSheet("Class Information");
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.STRING && classString.toUpperCase().equals(cell.getStringCellValue().toUpperCase())) {
                    theClass = new classes(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), row.getCell(2).getNumericCellValue(), row.getCell(3).getStringCellValue(), row.getCell(4).getStringCellValue(), row.getCell(5).getNumericCellValue(), row.getCell(6).getNumericCellValue());
                    break;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return theClass;
    }

    //Update Class occupancy in excel
    public static void updateClassOccupancy(classes corse) {
        try(Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath()))){
            Sheet sheet = workbook.getSheet("Class Information");
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.STRING && corse.getCN().equals(cell.getStringCellValue())) {
                    row.getCell(6).setCellValue(corse.getCO());
                }
            }
            //Save the workbook to a file
            try(FileOutputStream fileOutputStream = new FileOutputStream(filePath())){
                workbook.write(fileOutputStream);
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
        if (ans == 1) {
            createaccount();
        }
        Account account = login();
        timeslot timeslot = timeslots(account.getID());
        account.setSlot(timeslot);
        //timeslot timeslot = account.getSlot();
        timeslot.printcourse();
        boolean cont = true;
        while (cont) { //WHILE LOOP
            slowprint("Would you like to add or drop classes?\n");//Add or drop classes?
            slowprint("1: Add | 2: Drop | 3: Exit\n");
            ans = scanner.nextInt();
            switch (ans){
                case 3:
                    cont = false;
                    break;
                case 1: //Add
                    String day, course;
                    slowprint("What day would you like to modify?\n");    
                    scanner.nextLine();
                    day = scanner.nextLine();
                    printClassesInfo(readClassesFromSheet()); 
                    slowprint("Which class would you like to add?\n"); 
                    course = scanner.nextLine();
                    classes classes = findClass(course);
                    if (classes.getMO() <= classes.getCO()) {
                        slowprint("The class is full. Please try again.\n");
                        break;
                    }
                    classes.setCO(classes.getCO() + 1);
                    timeslot.addcourse(day, classes); //Needs a uniform system with time
                    updateTimeSlot(account);
                    updateClassOccupancy(classes);
                    slowprint("Your updated schedule is:");
                    timeslot.printcourse(); 
                    break;
                case 2: //Drop
                    slowprint("What day would you like to modify?\n");
                    scanner.nextLine();
                    day = scanner.nextLine();
                    slowprint("Which class would you like to drop?\n"); 
                    course = scanner.nextLine();
                    classes = findClass(course);
                    classes.setCO(classes.getCO() - 1);
                    timeslot.deletecourse(day, classes); //Needs classes object as argument
                    updateTimeSlot(account);
                    updateClassOccupancy(classes);
                    slowprint("Your updated schedule is:");
                    timeslot.printcourse(); 
                    break;
                default:
                    slowprint("Invalid input. Please try again.\n");
                    break;
            }
        }
        //TODO: Maybe an account settings option to change email, password and username
        scanner.close();
    }
}

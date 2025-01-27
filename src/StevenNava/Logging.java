package StevenNava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logging {

    private static String logfilepath = "log.txt"; //where you put the log file path

    public void writeLog(String newLogEntry) {

        // getting the timestamp using localdatetime and datetimeformatter libraries
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy: HH:mm:ss");
        String stamp = now.format(format);

        // formatting the new entry
        String log = stamp + " - " + newLogEntry;

        // writing the new entry to the file using bufferedwriter library
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(logfilepath, true))) {
            writer.write(log);
            writer.newLine();
        }
        catch (IOException e) {
            System.err.println("error: " + e.getMessage());
        }

    }
    public void createLog(String filePath) {
        //creates a new object of file which is the new log file
        File newLogFile = new File(filePath);
        //creates the new file if it does not already exist
        try {
            if(newLogFile.createNewFile()) {
                System.out.println("Log file created: " + filePath);
            }
            else {
                System.out.println("Log file exists: " + filePath);
            }
            logfilepath = filePath;
        }
        catch(IOException e) {
            System.err.println("error creating log file: " + e.getMessage());
        }
    }
    public void deleteLog(String filePath) {
        //same as before creating an object of file called logFile
        File logFile = new File(filePath);
        //checks if the file exists and if it does it will be deleted
        if (logFile.exists()) {
            if (logFile.delete()) {
                System.out.println("Log file deleted: " + filePath);
            } else {
                System.err.println("Failed to delete the log file: " + filePath);
            }
        } else {
            System.err.println("Log file does not exist: " + filePath);
        }
    }
}


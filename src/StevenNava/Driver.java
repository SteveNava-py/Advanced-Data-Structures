package StevenNava;

public class Driver {
    public static void main(String[] args) {
        Logging log = new Logging();
        log.createLog("new_log.txt");
        log.writeLog("Username: lee20, logged into the system for 20 minutes");
        log.deleteLog("new_log.txt");
    }
}

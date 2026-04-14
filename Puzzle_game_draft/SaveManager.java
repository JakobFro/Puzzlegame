import greenfoot.*;  
import java.io.*;    

public class SaveManager {

    private static final String SAVE_FILE = "savegame.txt";

    /**
     * Save a string (e.g., score or level) to a file.
     */
    public static void saveData(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE))) {
            writer.write(data);
            writer.newLine();
            //System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    /**
     * Load the saved string from the file.
     */
    public static String loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))) {
            String line = reader.readLine();
            //System.out.println("Data loaded successfully.");
            return line != null ? line : "";
        } catch (FileNotFoundException e) {
            System.err.println("No save file found.");
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
        return "";
    }
}
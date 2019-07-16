package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWorker {

    public static String readFile(String filePath) {
        File file = new File(filePath);

        return readFile(file);
    }

    public static String readFile(File file) {

        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        if (sc != null) {
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine()).append("\n");
            }
        }

        return sb.toString();
    }

    public static void writeToFile(File f, String text){
        try(FileWriter writer = new FileWriter(f, false))
        {
            writer.write(text+"\n");
            writer.flush();
            writer.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}

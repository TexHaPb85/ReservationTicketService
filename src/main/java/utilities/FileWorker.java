package utilities;

import java.io.*;
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


    public static void writeToFile(File f, String text) {
        try (FileWriter fileWriter = new FileWriter(f, true)) {
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(text);
            writer.close();
            System.out.println(text + " appended to file " + f.getPath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

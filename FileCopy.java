import java.io.*;

public class FileCopy {
    public static void main(String[] args) {

        String source = "input.txt";
        String destination = "output.txt";

        try {
            FileInputStream in = new FileInputStream(source);
            FileOutputStream out = new FileOutputStream(destination);

            int data;

            while ((data = in.read()) != -1) {
                out.write(data);
            }

            in.close();
            out.close();

            System.out.println("File copied successfully.");
            System.out.println("Destination File Created: " + destination);

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}

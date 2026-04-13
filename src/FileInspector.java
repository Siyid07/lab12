import javax.swing.JFileChooser;
import java.io.File;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir") + "/src");
        chooser.setCurrentDirectory(workingDirectory);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            try {
                java.util.Scanner scanner = new java.util.Scanner(selectedFile);

                int lineCount = 0;
                int wordCount = 0;
                int charCount = 0;

                System.out.println("--- File Contents ---");

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);

                    lineCount++;
                    charCount += line.length();

                    String[] words = line.split("\\s+");
                    if (!line.trim().isEmpty()) {
                        wordCount += words.length;
                    }
                }

                scanner.close();

                System.out.println("\n--- Summary Report ---");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Total Lines: " + lineCount);
                System.out.println("Total Words: " + wordCount);
                System.out.println("Total Characters: " + charCount);

            } catch (java.io.IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("No file was selected. Program closing.");
        }
    }
}

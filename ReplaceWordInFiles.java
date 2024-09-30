// import java.io.FileWriter;
// import java.io.IOException;

// public class CreateHTMLFiles {
//     public static void main(String[] args) {
//         String htmlContent = "<!DOCTYPE html>\n" +
//                 "<html lang=\"en\">\n" +
//                 "<head>\n" +
//                 "    <meta charset=\"UTF-8\">\n" +
//                 "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
//                 "    <title>Document</title>\n" +
//                 "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
//                 "    <link rel=\"stylesheet\" href=\"cont_style.css\">\n" +
//                 "    <link rel=\"stylesheet\" href=\"front-end_style.css\">\n" +
//                 "    <link rel=\"stylesheet\" href=\"course_day_style.css\">\n" +
//                 "</head>\n" +
//                 "<body>\n" +
//                 "    <header>\n" +
//                 "        <nav class=\"navbar_1\">\n" +
//                 "            <a href=\"./index.html\" class=\"logo\"> <img src=\"./Images/logo.png\" alt=\"\"> </a>\n" +
//                 "            <ul class=\"nav-links\">\n" +
//                 "                <li><a href=\"#\">About Us</a></li>\n" +
//                 "                <li><a href=\"#\">Contact</a></li>\n" +
//                 "            </ul>\n" +
//                 "        </nav>\n" +
//                 "    </header>\n" +
//                 "    <div class=\"space_div\"></div>\n" +
//                 "    <div class=\"course_name\">\n" +
//                 "        <p>Front-End_Domination: Create</p>\n" +
//                 "        <p>Anything with code</p>\n" +
//                 "    </div>\n" +
//                 "    <div class=\"course_day\">\n" +
//                 "        <p>Day 54</p>\n" +
//                 "    </div>\n" +
//                 "    <iframe class=\"styled-iframe\" src=\"https://short.ink/NFhX2Rf6D\" frameborder=\"0\" scrolling=\"0\" allowfullscreen=\"\"></iframe>\n" +
//                 "</body>\n" +
//                 "</html>";

//         for (int i = 1; i <= 155; i++) {
//             String fileName = "Back_Day_" + i + ".html";
//             try (FileWriter writer = new FileWriter(fileName)) {
//                 writer.write(htmlContent);
//                 System.out.println("Created: " + fileName);
//             } catch (IOException e) {
//                 System.err.println("Error creating file: " + fileName);
//                 e.printStackTrace();
//             }
//         }
//     }
// }





// import java.io.*;
// import java.nio.charset.StandardCharsets;
// import java.nio.file.*;
// import java.util.*;

// public class ReplaceWordInHTML {
//     public static void main(String[] args) {
//         String directoryPath = "/Users/harsh/Desktop/programming/Projects/Gyaan";
//         String targetWord = "code";
//         String replacementWord = " ";

//         try {
//             Files.walk(Paths.get(directoryPath))
//                 .filter(Files::isRegularFile)
//                 .filter(path -> path.toString().matches(".*Back_Day_\\d+\\.html"))
//                 .forEach(path -> {
//                     try {
//                         replaceWordInFile(path.toFile(), targetWord, replacementWord);
//                     } catch (IOException e) {
//                         System.err.println("Error processing file: " + path);
//                         e.printStackTrace();
//                     }
//                 });
//         } catch (IOException e) {
//             System.err.println("Error walking through directory: " + directoryPath);
//             e.printStackTrace();
//         }
//     }

//     private static void replaceWordInFile(File file, String targetWord, String replacementWord) throws IOException {
//         List<String> lines = new ArrayList<>();
//         try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 lines.add(line.replace(targetWord, replacementWord));
//             }
//         }

//         try (PrintWriter writer = new PrintWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
//             for (String line : lines) {
//                 writer.println(line);
//             }
//         }
//     }
// }




import java.io.*;
import java.nio.file.*;

public class ReplaceWordInFiles {
    public static void main(String[] args) {
        String directoryPath = "/Users/harsh/Desktop/programming/Projects/Gyaan";
        String wordToReplace = "two";
        String replacementCode = "<script>\n" +
                                 "var preloader = document.getElementById('pre_pencil');\n" +
                                 "function Pencil_Preloader(){\n" +
                                 "preloader.style.display = 'none';\n" +
                                 "}\n" +
                                 "</script>";
                                 

        for (int i = 42; i <= 155; i++) {
            String fileName = "Back_Day_" + i + ".html";
            Path filePath = Paths.get(directoryPath, fileName);
            replaceWordInFile(filePath, wordToReplace, replacementCode);
        }
    }

    private static void replaceWordInFile(Path filePath, String wordToReplace, String replacementCode) {
        try {
            String content = new String(Files.readAllBytes(filePath));
            content = content.replaceAll(wordToReplace, replacementCode);
            Files.write(filePath, content.getBytes());
            System.out.println("Replaced in file: " + filePath.getFileName());
        } catch (IOException e) {
            System.err.println("Error processing file: " + filePath.getFileName());
            e.printStackTrace();
        }
    }
}

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: rrd09
 * Date: 14/08/13
 * Time: 10:27
 */
public class Main {

    public static void main(String[] args) throws IOException {
        scanMaster("cross-validation");
    }

    public static void scanMaster(String keyword) throws IOException {
        File master = new File(Registry.root + File.separator + "thesis.tex");
        Scanner scanner = new Scanner(master);
        String currentLine;
        while (scanner.hasNext()) {
            currentLine = scanner.nextLine();
            if (currentLine.contains("\\include")) {
                int leftIndex = currentLine.indexOf("{");
                int rightIndex = currentLine.indexOf("}");
                String path = currentLine.substring(leftIndex + 1, rightIndex);
                String[] splits = path.split("/");
                File chapter = new File(Registry.root + splits[0] + File.separator + splits[1] + ".tex");
                Scanner chapterScanner = new Scanner(chapter);
                String chapterLine;
                int currentLineNumber = 0;
                boolean pathPrinted = false;
                while (chapterScanner.hasNext()) {
                    currentLineNumber++;
                    chapterLine = chapterScanner.nextLine();
                    if (chapterLine.contains(keyword)) {
                        if (!pathPrinted) {
                            pathPrinted = true;
                            System.out.println("- - - " + splits[1] + " - - -");
                        }
                        System.out.println(currentLineNumber + "\t" + chapterLine);
                    }
                }
                chapterScanner.close();
            }
        }
        scanner.close();
    }

    @Deprecated
    public static void getTex() throws IOException {
        File root = new File(Registry.root);
        for (String subDirectory : root.list()) {
            //System.out.println(subDirectory);
            if (new File(Registry.root + subDirectory).isDirectory()) {
                File parent = new File(Registry.root + subDirectory);
                for (String subSubDirectory : parent.list()) {
                    if (subSubDirectory.endsWith("001.tex")) {
                        File texFile = new File(parent.getAbsolutePath() + File.separator + subSubDirectory);
                        scan(texFile);
                    }
                }
            }
            if (subDirectory.endsWith("001.tex")) {
                File texFile = new File(Registry.root + subDirectory);
                scan(texFile);
            }
        }
    }

    @Deprecated
    public static void scan(File texFile) throws IOException {
        System.out.println("------------------- Scanning " + texFile.getName());
        Scanner scanner = new Scanner(texFile);
        String currentLine;
        ArrayList<String> labels = new ArrayList<String>();
        while (scanner.hasNext()) {
            currentLine = scanner.nextLine();
            int leftIndex = currentLine.indexOf("\\label{");
            int rightIndex;
            String label;
            while (leftIndex >= 0) {
                leftIndex += 7;
                //System.out.println(currentLine);
                //System.out.println("left " + leftIndex);
                rightIndex = currentLine.indexOf("}", leftIndex);
                //System.out.println("right " + rightIndex);
                label = currentLine.substring(leftIndex, rightIndex);
                System.out.println(label);
                labels.add(label);
                leftIndex = currentLine.indexOf("\\label{", rightIndex);
            }
        }
        scanner.close();
        //for (String label : labels) System.out.println(label);
        if (labels.size() > 0) change(texFile, labels);
    }

    @Deprecated
    public static void change(File texFile, ArrayList<String> labels) throws IOException {
        //System.out.println(texFile.getAbsolutePath());
        int beginIndex = texFile.getAbsolutePath().indexOf("001.tex");
        String rename = texFile.getAbsolutePath().substring(0, beginIndex) + "002.tex";
        //System.out.println(rename);

        String prefix = texFile.getName();
        beginIndex = prefix.indexOf("001.tex");
        prefix = prefix.substring(0, beginIndex);
        //System.out.println(prefix);

        Scanner scanner = new Scanner(texFile);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(rename)));
        String currentLine;
        String newLine;
        while (scanner.hasNext()) {
            currentLine = scanner.nextLine();
            newLine = currentLine;
            for (int l = 0; l < labels.size(); l++) {
                if (newLine.contains("\\label{" + labels.get(l) + "}")) {
                    newLine = newLine.replace("\\label{" + labels.get(l) + "}", "\\label{" + prefix + labels.get(l) + "}");
                    System.out.println(newLine);
                } else if (newLine.contains("\\ref{" + labels.get(l) + "}")) {
                    newLine = newLine.replace("\\ref{" + labels.get(l) + "}", "\\ref{" + prefix + labels.get(l) + "}");
                }
            }
            bufferedWriter.write(newLine);
            bufferedWriter.newLine();
        }
        scanner.close();
        bufferedWriter.close();
        System.out.println("Output new file : " + rename);
    }
}

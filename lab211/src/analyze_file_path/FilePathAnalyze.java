package analyze_file_path;

import java.util.Arrays;
import java.util.Scanner;

public class FilePathAnalyze {
    private String filePath;

    public FilePathAnalyze(String filePath) {
        this.filePath = filePath;
    }

    public String getPath() {
        int indexLast = filePath.lastIndexOf("\\");
        return filePath.substring(0, indexLast);
    }

    public String getFileName() {
        int indexLast = filePath.lastIndexOf("\\");
        int dotIndex = filePath.lastIndexOf(".");
        return filePath.substring(indexLast + 1, dotIndex);
    }

    public String getFileExtension() {
        int dotIndex = filePath.lastIndexOf(".");
        return filePath.substring(dotIndex + 1);
    }

    public String getDisk() {
        int indexLast = filePath.lastIndexOf(":");
        return filePath.substring(0, indexLast+1);
    }

    public String[] getFolders() {
        String pathWithoutFileName = getPath();
        String[] folders = pathWithoutFileName.split("\\\\");
        int startIndex = 0;
        if (folders[0].contains(":")) {
            startIndex = 1;  // Bỏ phần ổ đĩa
        }
        String[] resultFolders = new String[folders.length - startIndex];
        for (int i = 1; i < folders.length; i++) {
            resultFolders[i - startIndex] = folders[i];
        }
        return resultFolders;
    }

    public void displayFileInfo() {
        System.out.println("===== Result Analysis =====");
        System.out.println("Disk: " + getDisk());
        System.out.println("Extension: " + getFileExtension());
        System.out.println("File Name: " + getFileName());
        System.out.println("Path: " + getPath());
        System.out.println("Folders: " + Arrays.toString(getFolders()));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        System.out.println("enter file path: ");
        String filePath = sc.nextLine();
        FilePathAnalyze filePathAnalyze = new FilePathAnalyze(filePath);
        filePathAnalyze.displayFileInfo();
    }

}

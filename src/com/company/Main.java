package com.company;
import java.io.File;
import java.util.Scanner;
public class Main {
    public static boolean hasFoundWord = false;
    public static void main(String[] args) {
        File startingFolder = new File("C:\\Users\\mona_\\LABB2\\testdata");
        Scanner sc = new Scanner(System.in);
        System.out.println("sök efter ett ord");
        String word = sc.next();
        printInfo(startingFolder, word);
        if (hasFoundWord != true) {
            System.out.println();
        }
    }

    public static void Readfile (File file, String wordfile){
        file = new File("testdata/1.txt");
        try {
            Scanner sc = new Scanner(file);
            String word;
            while (sc.hasNext()) {
                word = (sc.next());
                if (wordfile.equals(sc.next())) {
                    System.out.println(file.getAbsolutePath());
                    hasFoundWord = true;
                }
            }
            sc.close();
        }catch (Exception e){

        }
    }
    public static void printInfo (File file, String word){
        if (file.isFile()) {
            Readfile(file, word);
        } else if (file.isDirectory()) {

            try {
                File[] folderContents = file.listFiles();
                for (File f : folderContents) {
                    printInfo(f, word);
                }
            } catch (Exception e) {
                System.out.println("Ooops");
            }
        }
        if (file.canRead()){
            System.out.println();

        } else {
            System.out.println("System error");
        }
    }
}


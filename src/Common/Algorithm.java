/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author hieu
 */
public class Algorithm {
    Library l = new Library();
    public void countWordInFile() {
        String fileSource = l.getString("Enter path: ");
        String word = l.getString("Enter word: ");
        int count = countWordInFile(fileSource, word);
        if (count != -1)
            System.out.println("Boat: " + count);
    }
    public int countWordInFile(String fileSource, String word) {
        FileReader fr = null;
        try {
            fr = new FileReader(fileSource);
            BufferedReader br = new BufferedReader(fr);
            int count = 0;
            String line = br.readLine();
            while (line != null) {
                String[] str = line.split(" ");
                for (String w : str) {
                    if (w.equalsIgnoreCase(word))
                        count++;
                }
                line = br.readLine();
            }
            fr.close();
            return count;
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            return -1;
        }
        catch (IOException e) {
            return -1;
        }
    }
    public void findFileByWord() {
        String source = l.getString("Enter path: ");
        String word = l.getString("Enter word: ");
        findFileByWord(source, word);
    }
    public void findFileByWord(String source, String word) {
        try {
            File folder = new File(source);
            File[] listOfFiles = folder.listFiles();

            for (File file : listOfFiles)
                if (file.isFile())
                    if (countWordInFile(file.getAbsolutePath(), word) != 0)
                        System.out.println("file name: " + file.getName());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

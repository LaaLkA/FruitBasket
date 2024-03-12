package core;

import java.io.*;

public class FileProcessor {
    File file;

    public FileProcessor(String fileName){
        this.file = new File(fileName);
    }

    public String[] read() throws FileNotFoundException {
        String[] data = new String[]{};
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String lineInFile;
            while ((lineInFile = bufferedReader.readLine()) != null) {
                data = lineInFile.split(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void write(String[] dataToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String word : dataToWrite) {
                bufferedWriter.write(word.trim() + " ");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

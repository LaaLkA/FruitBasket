package core;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DataOperations {

    public void mostRepeatedWord(String[] data) {
        HashMap<String, Integer> dataMap = new HashMap<>();
        for (String word : data) {
            dataMap.put(word, dataMap.getOrDefault(word, 0) + 1);
        }

        int maxCount = -1;
        String mostRepeatedWord = null;

        for (Map.Entry<String, Integer> entry : dataMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostRepeatedWord = entry.getKey();
            }
        }
        System.out.printf("Больше всего повторений у слова: %s\n" +
                "Колличество повторений: %s\n", mostRepeatedWord, maxCount);
    }

    public void LongestWord(String[] data) {
        String longestWord = null;
        int maxLengthOfWord = 0;

        for(String word : data) {
            if(maxLengthOfWord < word.length()) {
                maxLengthOfWord = word.length();
                longestWord = word;
            }
        }
        System.out.printf("Самое длинное слово: %s \n" +
                "Его длина: %s\n", longestWord, maxLengthOfWord);
    }

    public void totalNumberOfWords(String[] data) {
        System.out.printf("Колличество слов в файле: %s \n", data.length);
    }

    public void dataView(String[] data){
        System.out.println("Слова в файле: " + String.join(", ", data) + "\n");
    }

    public String[] addWord(String[] data, String wordToAdd) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : data) {
            stringBuilder.append(word).append(" ");
        }
        stringBuilder.append(wordToAdd);
        String strData = stringBuilder.toString();

        return strData.split(" ");
    }
}

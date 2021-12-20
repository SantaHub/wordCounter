package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordCounter {

    public static void main(String args[]) {
        WordCounter wordCounter = new WordCounter();

        String data = wordCounter.readFile("src/contentFile.txt");
        data = wordCounter.cleanUpData(data);
        wordCounter.printMap(wordCounter.countWords(data));
    }

    private String readFile(String filePath) {
        String data = "";
         try{
             data = Files.readString(Paths.get(filePath), StandardCharsets.US_ASCII);
         } catch (IOException exception){
             System.out.println("Current Directory : " + System.getProperty("user.dir"));
             System.out.println("Please provide a valid file path.");
         }
         return data;
    }

    private String cleanUpData(String data){
        data = data.toLowerCase(Locale.ROOT);
        data = data.replaceAll("[^a-zA-Z0-9]+"," ");
        return data;
    }


    private Map<String, Integer> countWords(String data ){
        Map<String, Integer> countMap  = new HashMap<>();
        List<String> wordList = getWords(data);
        for(String word : wordList) {
            if(countMap.containsKey(word)) {
                int count = countMap.get(word);
                countMap.put(word, count +1 );
            } else {
                countMap.put(word, 1);
            }
        }
        return countMap;
    }
    private List<String> getWords(String data){
        List<String> wordsList =  new ArrayList<>();
        wordsList = Arrays.stream(data.split(" ")).toList();
        return wordsList;
    }

    private void printMap(Map<String, Integer> map) {
        map.forEach((word, count) -> System.out.println(word + " : " + count) );
    }
}

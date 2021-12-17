import java.lang.reflect.Array;
import java.util.*;

public class WordCounter {

    public static void main(String args[]) {
        String test = "Hey how are you you are how";
        WordCounter wordCounter = new WordCounter();

        wordCounter.printMap(wordCounter.countWords(test));
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

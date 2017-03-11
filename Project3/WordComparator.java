import java.util.Comparator;

public class WordComparator implements Comparator<String> {

   public int compare (String word1, String word2){
      return word1.compareTo(word2);
      /*this class allows for the comparison of words in the tree map. Words in the tree map
      get sorted by the key*/
   }
}

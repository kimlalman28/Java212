
public abstract class  Word { //cannot be instantiated 
   protected String theWord;

   public Word(String w){
      
      theWord = w;

   }
      
   public String getWord(){ //will return word when this is called
      return theWord;
   }
   
 public int compareTo (Word d) { //compareTo for class Word
      
      if (theWord.compareToIgnoreCase(d.getWord()) > 0) 
          return 1;
      else {
          if (theWord.compareToIgnoreCase(d.getWord()) == 0)
              return 0;
          if (theWord.compareToIgnoreCase(d.getWord()) < 0)
              return 1;
          else
              return 0;
      }

   
  }
}
 

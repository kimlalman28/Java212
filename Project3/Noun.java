
public class Noun extends Word {
   
   public Noun(String n){
      super(n); // super passes word to Word class
   }
   

   public String toString(){ //will return word current word with a string that informs that it is a noun
      return theWord + "(N)";
      
   }
   
}

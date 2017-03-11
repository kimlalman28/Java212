
public class Verb extends Word {

   
   public Verb (String v){ 
      super (v); //super passes the word to the Word class 
   }

   public String toString(){ // returns a string that informs that the word is a verb
      return theWord + "(V)";
      
   }
   
}

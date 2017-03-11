/*
 *  Kimberly Lalmansingh
 *  Project 4
 *  Dr. Lord and Lab Professor Di Wu
 *  
 *  For this project, the program first creates a hashmap and a tree map which hold key/value pairs in the main function.
 *  The program then reads in a file using TextFileInput and the words and read in line by line.
 *  As each line is read in, it is decided if it is a noun or a verb using the Noun/Verb classes which extends
 *  class word. The program then takes each word and splits it meaning, the key is the word and the value is 
 *  either (N) or (V) for the sake of the project. The tree map uses a Comparator in order to sort the words
 *  that are in it while the position in a hashmap is randomized. Finally the hashmap and treemap are passed into
 *  the GUI. There, the GUI will display the hashmap on the left and the tree map on the right.
 */

import java.util.HashMap;
import java.util.TreeMap;

public class Project4 {
   public static void main(String[] args){
      
      HashMap<String, String> hash = new HashMap<String, String>(); //new hashmao
      TreeMap<String, String> tree = new TreeMap<String, String>(new WordComparator()); //new tree map using comparator
      TextFileInput input = new TextFileInput("wordsfile.txt"); //read in text file
      
      
      int index;
       String nextLine = input.readLine(); 
       while(nextLine != null){ //loop that goes through each line in the file
       index = nextLine.indexOf('('); //would get word until '('
       char p = nextLine.charAt(index+1);
       if(p=='N'){ //check if noun
          String w = nextLine.substring(0,index);
          Noun n = new Noun(w); //if it is a noun, create new instance
         //n.toString();
          hash.put(w,"(N)" ); //put word into hashmap
          tree.put(w, "(N)"); //put word into treemap

       }
          
         if (p=='V'){ //checks if word is verb
             String w = nextLine.substring(0,index);
             Verb v = new Verb(w); //if it is a verb, instantiate new verb
             //v.toString(); 
             hash.put(w, "(V)"); //put word into hashmap
             tree.put(w, "(V)"); //put word into treemap

            
          }
      nextLine = input.readLine(); //read in next line
   }
      
      Project4GUI display = new Project4GUI("Project4", hash, tree); //create empty GUI so user can select a file
      //call on GUI in order to display hashmap and treemap 
   }
}

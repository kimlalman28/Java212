/*
 * Kimberly Lalmansingh
 * CS212 - 11D
 * Project2
 * Dr. Lord & Lab Professor Di Wu
 * 
 * The program first reads in a set of words from a file. Words that contain characters other than letters are 
 * printed to the console and the rest are stored in an array. The words then get sorted and stored in another 
 * array. The words are then appended to a linked list. The two arrays of words and the linked list is 
 * displayed on the GUI and the user can now enter commands to modify the words in the arrays and linked list.
 * The add command will add the inputed words to the first array, sort the words in the seconds array and linked
 * list. The delete command removes the inputed word from both arrays and the linked list. the stop command
 * will terminate the program. After commands are given, the changes are updated to the GUI. This will loop
 * until the user types stop to terminate the program.
 */

import java.awt.*;
import java.util.*; 

import javax.swing.JOptionPane;

public class Project2 {
   
   public static int index = 0; // had to instantiate outside of main so it can be used globally by any method
   
   public static void main(String[] args){
    
      String[] wordArray = new String[100]; //create array to hold words
      String[] sortedwordArray = new String[100];// array of sorted words
      WordList nl = new WordList(); //linked list
      
      TextFileInput input = new TextFileInput("wordsfile.txt"); //read in file using textfileinput and running with configurations
      
      String line = input.readLine();
      while (line != null && index <100){ //loops through each line in the textfile 
         if(validWord(line)){ //pass word into a method which checks if it is valid or not
            wordArray[index] = line; //put word into array
            sortedwordArray[index] = line;
            index++;
            line = input.readLine();
         }
         else {  //if word is invalid, it is printed to the console
            System.out.println(line);
            line = input.readLine();
         }
      } //read in line loop end
      
      sortWords(sortedwordArray); //sort array
      for(int i=0; i<index; i++){ //add words to the linked list
         nl.append(sortedwordArray[i]);
      }
      
      while (true){ //will loop until user inputs stop into JOPane
     // wordArraytoGUI(myGUI, wordArray, sortedwordArray, nl);
      Project2GUI myGUI = new Project2GUI("Project 2", wordArray, sortedwordArray, nl); //create GUI and passing one parameter which is the title
      myGUI.setDefaultCloseOperation(Project2GUI.DISPOSE_ON_CLOSE);
      myGUI.setVisible(true);
      
      Commands(wordArray, sortedwordArray, nl); //method to accept commands
      
      sortWords(sortedwordArray); //resort array with new words
      
      }//ends when user enters stop
   
   }//main end
    
  // public static void wordArraytoGUI (Project2GUI myGUI, String[] wordArray, String[] sortedwordArray, WordList nodeList){
       
        
   private static void sortWords(String[] sortWordArray){
      for (int i = 0; i<index-1; i++){
         int lowestIndex = i;
         for(int j=i+1; j<index; j++)
            if((sortWordArray[j].compareTo(sortWordArray[lowestIndex])<0)) //compare both words by unicode value
            lowestIndex = j;
         
          String temp = sortWordArray[lowestIndex]; //create temp so lowestindex is not overwritten
          sortWordArray[lowestIndex] = sortWordArray[i];
          sortWordArray[i] = temp;
      }
   }
         
   private static boolean validWord (String word) {
         for(int i = 0; i<word.length(); i++){
            if (! Character.isLetter(word.charAt(i))){ //checks to make sure each letter is a letter and not a digit/special character
               return false;
            }
         }    
         return true;
    }//vaildWord end
   
public static void Commands(String[] wordArray, String[] sortedwordArray, WordList n){
   StringTokenizer myTokens;
   String input;
 
   
   input = JOptionPane.showInputDialog(null, "Enter a command (Add, Delete or Stop): ");
   
   String[] commands = input.split(" "); //will create an array that allows access to the first word in input - the command
   
   if(commands[0].equalsIgnoreCase("stop")){
      System.exit(0);
   }//end if command is stop
   
   myTokens = new StringTokenizer(commands[1], ","); //tokens are the words inputed after command 
   String[] words = new String[myTokens.countTokens()];
   
   int j=0;
   while (myTokens.hasMoreTokens()) { //store tokens in an array
      words[j]=myTokens.nextToken();
      j++;
   }//end filling array with tokens
   
   if(commands[0].equalsIgnoreCase("add")){ 
      for(int i=0; i<words.length; i++){ //add each word in the array of tokens to both arrays and the linked list  
         wordArray[index] = words[i]; 
         sortedwordArray[index] = words[i];
            n.newWord(words[i]);
      
         index++;
      }
   }//end if command is add
   
   if(commands[0].equalsIgnoreCase("delete")){
      for(int i=0; i<index; i++){ //delete word by overwriting it in the arrays
         if(wordArray[i].equals(commands[1])){
              for(int m=i; m<index; m++){
                 wordArray[m]=wordArray[m+1];
              }
              break;
         }
         
      }//for loop end for wordArray
       for(int q=0; q<index; q++){
          if(sortedwordArray[q].equals(commands[1])){
               for(int m=q; m<index; m++){
                    sortedwordArray[m]=sortedwordArray[m+1];
                 }
               break;
         }
       }//for loop end for sortedwordArray
     
      n.delete(commands[1]); //delete from linked list
      
      index--;
   }//end if command is delete
   
}//commands end
   
    }//project2 end
  

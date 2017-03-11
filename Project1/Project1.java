/*
 * Kimberly Lalmansingh
 * CS212 - 11D
 * Project1
 * Dr. Lord & Lab Professor Di Wu
 * 
 * The program first reads in a file using textfileinput which contains some words that consist of only letter 
 * some words that contain special characters or digits. The program finds the valid words that contain only letters
 * and puts the words into an array. The invalid words are printed to the console. The program then creates a GUI
 * in which the words are separated into two columns. The column on the left contains the valid words. The column on 
 * the left contains valid words that have been sorted into alphabetical order.
 */

import java.awt.*;

public class Project1 {
   public static void main(String[] args){
    
      String[] wordArray = new String[100]; //create array to hold words
      
      TextFileInput input = new TextFileInput(args[0]); //read in file using textfileinput and running with configurations
      
      String line = input.readLine();
      int index = 0;
      while (line != null && index <100){ //loops through each line in the textfile 
         if(validWord(line)){ //pass word into a method which checks if it is valid or not
            wordArray[index] = line; //put word into array
            index++;
            line = input.readLine();
         }
         else {  //if word is invaild, it is printed to the console
            System.out.println(line);
            line = input.readLine();
         }
      }
      String title = "Project1";
      Project1GUI myGUI = new Project1GUI(title); //create GUI and passing one parameter which is the title
      
      wordArraytoGUI(myGUI , wordArray, index); //method to create GUI and add words into content pane
    
   
   }//main end
    
   public static void wordArraytoGUI (Project1GUI myGUI, String[] wordArray, int size){
        myGUI.setSize(400,200);
        myGUI.setLocation(100,100);
        
        Container myContentPane = myGUI.getContentPane(); 
        TextArea goodWords = new TextArea(); //unsorted words
        TextArea sortedArray = new TextArea(); //sorted words 
        myGUI.setLayout (new GridLayout(1,2));
        myGUI.setDefaultCloseOperation(Project1GUI.EXIT_ON_CLOSE);
        
        myContentPane.add(goodWords); //add words from unsorted array to GUI
        for(int i=0; i<size; i++){
        goodWords.append(wordArray[i]);
        goodWords.append("\n");
        }
        
        sortWords(wordArray, size); //method to sort words alphabetically
        myContentPane.add(sortedArray); //add words from newly sorted array to GUI
        for(int i=0; i<size; i++){
        sortedArray.append(wordArray[i]);
        sortedArray.append("\n");
        }
        myGUI.setVisible(true);
    
   }//wordArraytoGUI end
        
   private static void sortWords(String[] sortWordArray, int size){
      for (int i = 0; i<size-1; i++){
         int lowestIndex = i;
         for(int j=i+1; j<size; j++)
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
   
   
    }//project1 end
  

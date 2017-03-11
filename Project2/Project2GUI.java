import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JFrame;

public class Project2GUI extends JFrame {
    
   public Project2GUI(){}; 
   
   public Project2GUI(String title,String[] wordArray,String[] sortedwordArray, WordList nl ){  //create GUI
      setTitle(title);
      setSize(500,500);
      setLocation(100,100);
      setLayout (new GridLayout(1,3));
      Container myContentPane = getContentPane(); 
      
      TextArea goodWords = new TextArea(); //unsorted words
      TextArea sortedArray = new TextArea(); //sorted words 
      TextArea nodeWords = new TextArea();
      
      myContentPane.add(goodWords); //add words from unsorted array to GUI
         for(int i=0; i<Project2.index; i++){
            goodWords.append(wordArray[i]);
            goodWords.append("\n");
         }
      
      myContentPane.add(sortedArray); //add words from newly sorted array to GUI
         for(int i=0; i<Project2.index; i++){
            sortedArray.append(sortedwordArray[i]);
            sortedArray.append("\n");
         }
      
   /*   myContentPane.add(nodeWords);
         WordListIterator wli = nodeList.reset(); //using an iterator, while loop will go through each node in linked list
         while(wli.hasNext()){
            nodeWords.append(wli.next());
            nodeWords.append("\n");
      }
       */   
         
         setDefaultCloseOperation(Project2GUI.EXIT_ON_CLOSE);
     setVisible(true);
  
     
   }
   
}//end class GUI
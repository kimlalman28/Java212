import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Project4GUI extends JFrame {

   public Project4GUI(String title, HashMap<String, String> hash, TreeMap<String, String> tree){  //create GUI
      //GUI created passing a title, hashmap and tree map as parameters
      setTitle(title);
      setSize(500,500);
      setLocation(100,100);
      setLayout (new GridLayout(1,2));
      
      Container myContentPane = getContentPane();
      JTextArea right = new JTextArea(); //right of GUI for tree map
      JTextArea left= new JTextArea(); //left of GUI for hash map
      myContentPane.add(left, BorderLayout.WEST);
      myContentPane.add(right, BorderLayout.EAST);    
      
      hashToTextArea(hash, left); //method to display hashmap on GUI
      treeToTextArea(tree, right); //method to display treemap on GUI
      
      setDefaultCloseOperation(Project4GUI.EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   public void hashToTextArea(HashMap<String, String> hash, JTextArea l){
      Set<Entry<String, String>> set = hash.entrySet();
      Iterator<Entry<String, String>> i = set.iterator(); //use of iterator to iterate through each key
      Map.Entry<String, String> me;
      
      while (i.hasNext()){ //loops to go through each key in the map
         me = (Entry<String, String>)i.next(); 
         
         l.append(me.getKey()+" "); //append the key to GUI
         l.append(me.getValue()); //append value to GUI
         /*
          * For the sake of the project, I made the actual word the key and I decided to use (N/V)
          * as the value of the key in order to implement the use of both the key/value
          */
         l.append("\n");
     }
   }
      
    public void treeToTextArea(TreeMap<String, String> tree, JTextArea r){
       Set<Entry<String, String>> set = tree.entrySet();
       Iterator<Entry<String, String>> i = set.iterator(); //use of iterator with treemap
       Map.Entry<String, String> me;
       
       while (i.hasNext()){
          me = (Entry<String, String>)i.next();
          
          r.append(me.getKey()+" "); //append key to GUI
          r.append(me.getValue()); //append value to GUI
          r.append("\n");

       }
    }
      
}//end class GUI
public class WordNode {
   public String data;
   public WordNode next;
     
   public WordNode(String data){ //constructor for one parameter 
      this.data = data;
      this.next = null;
   }
   
   public WordNode(String data, WordNode next)  { //constructor for 2 parameters
      this.data = data;
      this.next = next;
   } 
   
   public WordNode()  { //constructor for no parameters
      this.data = null;
      this.next = null;
   }  
}//end class WordNode

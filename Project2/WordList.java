public class WordList {
   private WordNode first;
   private WordNode last;
   private int length;
   
public WordList () { //create linked list of words
    WordNode ln = new WordNode();
         first = ln;
         last = ln;
         length = 0;
         }
      
      public int getLength(){
      return length;
   }
   
   public void append(String newWord){ //add words to end of linked list
      WordNode n = new WordNode(newWord);
      last.next = n;
      last = n;
      length++;
      
   }
   
   public void newWord(String newWord){ //add words in sorted order in linked list
      WordNode w = new WordNode(newWord);
      WordNode current = first; //start at dummy node
      while(!(((current.next).data).compareTo(newWord)>0)){ //will loop until node data is bigger than new word
         current = current.next;
         if(current.next==null) break; 
      }
      if(current.next==null){ //if given word needs to be last in linked list, must set .next pointer = null
         w.next=null;
      }
      else{
      w.next = current.next;
      }
      current.next = w;
      length++;
      
   }
   
   public void delete(String r){
      WordNode p = first.next;
      WordNode q = first;
      if (find(r) == null)
         throw new IllegalArgumentException("Null Pointer.");
      
      while(p!=null && !(p.data.equals(r))){
         p = p.next;
         q = q.next;
      }
      q.next = p.next; //will cause deletion of q.data 
      
      length--;
      
   }
   
   public WordNode find(String word){
      WordNode p = first.next;
      while(p!=null && !(p.data.equals(word))){
         p = p.next;
      }
      return p;
   }
   
   public WordListIterator reset(){ //iterator
      return new WordListIterator(first.next);
   }
}

public class WordListIterator {
   private WordNode node;
   
   public WordListIterator(WordNode first){
      node = first;
   }
   
   public boolean hasNext(){ //check if next is null 
      return (node !=null);
   }
   
   public String next(){
      if (node == null)
         throw new NullPointerException("Word List empty.");
         
         String currentData = node.data;
         node = node.next;
         return currentData;
   }
 
}

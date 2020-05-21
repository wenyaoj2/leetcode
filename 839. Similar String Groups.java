import java.util.*;

class NumSimilarGroups {
    public int numSimilarGroups(String[] A) {
       HashSet<String> visited = new HashSet();
       Queue<String> queue = new LinkedList();
       int res = 0;
       for(String word : A) {
           if(visited.contains(word)) {
               continue;
           }
           res++;
           queue.offer(word);
           visited.add(word);
           while(!queue.isEmpty()) {
               String cur = queue.poll();
               for(String otherWord : A) {
                   if(visited.contains(otherWord)) {
                       continue;
                   }
                   if(isSimilar(cur, otherWord)) {
                       // System.out.println(otherWord + " " + res);
                       queue.offer(otherWord);
                       visited.add(otherWord);
                   }
               }
           }
       }
       return res;
   }
   
   
//  judge similar or not
   public  boolean isSimilar(String s1, String s2) {
       int num = 0;
       for(int i = 0; i < s1.length(); i++) {
           if(s1.charAt(i) != s2.charAt(i)) {
               num++;
           }
       }
       return num == 2;
   }
}
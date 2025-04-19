import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class reverseList {
   public List<Integer> reverse(List<Integer> data) {
       List<Integer> list = new ArrayList<>();
       for (int i = data.size()-1; i >=0; i--) {
           list.add(data.get(i));
       }
       return list;
   }
   public LinkedList <Integer> reverseLinkedList(List <Integer> data) {
       LinkedList <Integer> list = new LinkedList <>();
       for (int i = data.size()-1; i >=0; i--) {
           list.add(data.get(i));
       }
       return list;
   }
   public static void main(String[] args) {
       List<Integer> data = List.of(1,2,3,4,5,6,7,8,9);
       reverseList obj = new reverseList();
       System.out.println(obj.reverse(data));
       System.out.println(obj.reverseLinkedList(data));
   }
}
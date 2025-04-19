
import java.util.HashSet;
import java.util.Set;

public class setCompare{
    public static boolean areEqual(Set <Integer> set1,Set <Integer> set2){
        if(set1.equals(set2)){
            return true;
        }else return false;
    }
    public static void main (String [] args){
        Set <Integer> set1 = new HashSet <> ();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set <Integer> set2 = new HashSet <> ();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        System.out.println(areEqual(set1,set2));
    
    }
}


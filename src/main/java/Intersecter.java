import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Intersecter {


    public static Set intersectLists(List a, List b,boolean left){

        HashSet<Integer> c = new HashSet<>();
        //put left list (a) into HashSet if true, then intersect
        if(left){
            c.addAll(a);
            return intersect(b,c);
        }else {
            c.addAll(b);
            return intersect(a,c);
        }
    }


    private static Set intersect(List list,HashSet set){
        return (HashSet<Integer>) list.stream().filter(set::contains).collect(Collectors.toSet());
    }



}

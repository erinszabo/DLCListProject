import static java.lang.System.out;
import java.lang.Exception;
import java.util.Arrays;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//to see what main prints for him go to 00:09:51
public class Main
{
    //removed  String[] args  ans static
    public void main() {
        intExample();
        personExample();
    }
    
    public static void intExample() {
        DLCList<Integer> theList = new DLCList<>();
        theList.addAll(Arrays.asList(new Integer[]{1,6,9,3,4}));
        theList.addFirst(67);
        
        out.println("int list tests: \n");
        
        out.println(theList);
        
        //print each item
        for (Integer item : theList) {
            out.println(item);
        }
        
        //test getter
        out.println("Node 2 data in int list is: " + theList.get(2));
        
        //test deleteFirst method
        theList.deleteFirst();
        out.println(theList);
        
        //test deleteLast method
        theList.deleteLast();
        out.println(theList);
        
        //test delete method
        theList.delete(1);
        out.println(theList);
        
        //test contains method
        out.println(theList.contains(1));
        out.println(theList.contains(99));
        
        //insert 44 in slot 1
        theList.insert(1,44);
        out.println(theList);
    }
    
    // 00:06:24
    public static void personExample() {
        DLCList<Person> pList = new DLCList<>();
        Person p = new Person("Aunt","Jemima","11313");
        Person q = new Person("Mary","Jane","2222");
        Person r = new Person("Rouge","Cat","3333");
        Person s = new Person("Santa","Claus","444");
        Person t = new Person("Cursed","Muffin","5555");
        pList.addAll(Arrays.asList(new Person[]{p,q,r,s,t}));
        pList.addFirst(r);
        
        out.println("\n\nPerson list tests: \n");
        
        out.println(pList);
        
        for (Person per : pList) {
            out.println(per);
        }
        
        out.println("Node 2 data in Person list is: " + pList.get(2));
        
        out.println(pList.toString());
        
        pList.deleteFirst();
        out.println(pList);
        
        out.println(pList.toString());
        
        pList.clear();
        
        out.println(pList);

    }
    
    // 00:06:31
    public static void testRAList() {}
}

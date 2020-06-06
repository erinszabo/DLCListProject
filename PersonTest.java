

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static java.lang.System.out;
import java.util.Arrays;

/**
 * The test class PersonTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonTest
{
    DLCList<Person> pList = new DLCList<>();
    private Person p;
    private Person q;
    private Person r;
    private Person s;
    private Person t;
    
    
    /**
     * Default constructor for test class PersonTest
     */
     public PersonTest()
     {
        //DLCList<Person> pList = new DLCList<>();
        Person p = new Person("Aunt","Jemima","11313");
        Person q = new Person("Mary","Jane","2222");
        Person r = new Person("Rouge","Cat","3333");
        Person s = new Person("Santa","Claus","444");
        Person t = new Person("Cursed","Muffin","5555");        
     }
    
    @Test
    public void addTests() {
        Person p = new Person("Aunt","Jemima","11313");
        Person q = new Person("Mary","Jane","2222");
        Person r = new Person("Rouge","Cat","3333");
        Person s = new Person("Santa","Claus","444");
        Person t = new Person("Cursed","Muffin","5555");     
        
        //addAll
        pList.addAll(Arrays.asList(new Person[]{p,q,r,s,t}));
        
        //addFirst
        pList.addFirst(r);
        
        pList.addLast(new Person("Newbie","Last","9999"));
        
        out.println(pList);

        for (Person per : pList) {
            out.println(per);
        }

    }
     
    @Test     
    public void personTestMethod() {
        Person p = new Person("Aunt","Jemima","11313");
        Person q = new Person("Mary","Jane","2222");
        Person r = new Person("Rouge","Cat","3333");
        Person s = new Person("Santa","Claus","444");
        Person t = new Person("Cursed","Muffin","5555");
        pList.addAll(Arrays.asList(new Person[]{p,q,r,s,t}));
        
        // pList.addFirst(r);
                
        // out.println(pList);
        
        for (Person per : pList) {
            out.println(per);
        }
        
        out.println("Node 2 data in Person list is: " + pList.get(2));
        
        out.println(pList.toString());
        
        //RIP Aunt Jemima
        pList.deleteFirst();
        out.println(pList);
        
        //pointless test just to see
        out.println(pList.toString());
                
        out.println(pList);
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        out.println("\n\nNew Person list test: \n");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        //pList.clear();
    }

}


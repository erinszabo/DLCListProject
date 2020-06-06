
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static java.lang.System.out;
import java.util.Arrays;


/**
 * The test class DLCListTest.
 *  00:07:57
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DLCListTest
{
    /**
     * Default constructor for test class DLCListTest
     */
    public DLCList<Person> listOne;
    private Person[] people;
    private Person aPerson;

    public DLCListTest()
    {
        people = new Person[]{
            new Person("Bob","Smith","123456789"),
            new Person("Puala","Thomas","678910"),
            new Person("Gina","Roberts","11121314"),
        };
        
        aPerson = new Person("New", "Person", "1234345543");
        String toFind = "Gina";
    }
    
    @Before
    public void setUp() {
        listOne = new DLCList<>();
        listOne.add(people[0]);
        listOne.add(people[1]);
        listOne.add(people[2]);  
    }
    
    @Test
    public void testLength() {
        assertTrue(people.length == listOne.size());
    }
    
    @Test
    public void testAdd() {
        listOne.add(aPerson);
        assertTrue(listOne.size() == people.length + 1);
    }
    
    @Test
    public void testGetFirst() {
        assertTrue(listOne.getFirst().getID().equals("123456789"));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
     @After
     public void tearDown()
     {
        
     }
}

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static java.lang.System.out;
import java.util.Arrays;

/**
 * The test class NodeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NodeTest
{
    private Node[] nodes;
    private DLCList<Node> nSet;
    private Node n;
    
    
    /**
     * Default constructor for test class NodeTest
     */
    public NodeTest()
    {
        n = new Node("555");
        nodes = new Node[]{ new Node("9999"),
                            new Node("8888"),
                            new Node("7777"),
                            new Node("6666")};
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        nSet = new DLCList<>();
        nSet.add(nodes[0]);
        nSet.add(nodes[1]);
        nSet.add(nodes[2]); 
        
    }
    
    @Test
    public void testNode() {
        out.println(nSet);
        out.println(n);
    }
    
    //test set and get, 
    //double check that assertTrue works the way I think it does
    @Test
    public void testSetData() {
        n.setData("666");
        assertTrue(n.getData().equals("666"));
        out.println(n + " = 666?");

    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        nSet.clear();
        assertTrue(nSet.size() == 0);
    }
}

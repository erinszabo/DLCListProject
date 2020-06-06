
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String ID;
    private String first;
    private String last;
    
    public Person(String first, String last, String ID)
    {
        this.ID = ID;
        this.first = first;
        this.last = last;
    }
    
    public String toString() {
        return "Name: " + first + " " + last + "  ID: " + ID + "\n";
    }
    
    public String getFirstName() {
        return first;
    }
    
    public String getLastName() {
        return last;
    }
    
    public String getID() {
        return ID;
     }
}

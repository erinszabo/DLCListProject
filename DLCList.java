import java.util.Iterator;
import java.util.List;


/**
 * Write a description of class DLCList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class DLCList<T> implements IList<T>, Iterable<T>
{
    private Node<T> start;
    private int size;
    
    /**
     * Constructor for objects of class DLCList
     */
    public DLCList()
    {
        //instance variables
        start = null;
        size = 0;
        
    }
    
    //just so it'll override properly.
    //I won't really use this method. Maybe improve later
    public boolean add(int index, T element) {
        if (start == null) {
            start = new Node<>(element);
        }
        else {
            Node<T> temp = new Node<>(element, start.getPrev(), start);
            Node<T> last = start.getPrev();
            last.setNext(temp);
            start.setPrev(temp);
        }
        
        size++;
        return true;
    }
    
    public boolean add(T element) { 
        if (start == null) {
            start = new Node<>(element);
        }
        else {
            Node<T> temp = new Node<>(element, start.getPrev(), start);
            Node<T> last = start.getPrev();
            last.setNext(temp);
            start.setPrev(temp);
        }
        
        size++;
        return true;
    }
    
    public boolean addAll(List<T> items) {
        for (T item : items) {
            add(item);
        }
        return true;
    }
   
    public boolean addFirst(T element) {
        // Node<T> node = new Node(type);
        if (size == 0){
            add(element);
        }
        else {
            Node<T> temp =  new Node<>(element, start.getPrev(),start);
            start.getPrev().setNext(temp);
            start.setPrev(temp);
            start = temp;
            size++;
        }
        return true;
    }
    
    public boolean addLast(T element) { 
        add(element);
        return true;
    }
    
    public void delete(int index) {
        if (index == 0) {
            deleteFirst();
        }
        else if (index == size() - 1) {
            deleteFirst();
        }
        else {
            Node<T> node = getNode(index);
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            node.setNull();
        }
        
        size--;
    }
    
    public void deleteFirst() {
        if (size() < 1) {
            throw new IndexOutOfBoundsException("No first node to delete");
        }
        else if (size() == 1) {
            start.setNull();
            start = null;
        }
        else {
            Node<T> last = start.getPrev();
            Node<T> first = start;
            start = start.getNext();
            start.setPrev(last);
            last.setNext(start);
            first.setNull();
        }
    
        size--;
    }

    public void deleteLast() {
        if (size() < 1) {
            start.setNull();
            start = null;
        }
        else {
            Node<T> last = start.getPrev();
            last.getPrev().setNext(start);
            start.setPrev(last.getPrev());
            last.setNull();
        }
        
        size--;
    }
    
    public int size() {
        return size;
    }
    
    /**
     * clears the list, maybe improve later
     * will garbage collector get rid of the rest?? not sure.
     * 
     * Found out if its unreachable then it will be garbage 
     * collected so I don't need to deal with it
     */
    public void clear() {
        start = null;
        //maybe iterate to set all data on each node to null
        size = 0;
    }
    
    public boolean contains(T target) {
        boolean found = false;
        int index = 0;
        
        while (index < size() && !found) {
            if(get(index).equals(target)){
                found = true;
            }
            index++;
        }
        
        return found;
    }
    
    /**
     * Get node by index
     * @param index of the node to get
     * @return the node at the index
     * @throws IndexOutOfBoundsException 
     */
    public Node<T> getNode(int index) {
        if (index >= size || index <0) {
            throw new IndexOutOfBoundsException("bad index: " + index);
        }
        
        Node<T> cursor = start;
        
        for (int i = 0; i < index; i += 1) {
            cursor = cursor.getNext();
        }
        
        return cursor;
    }
    
    public T get(int index) {
        Node<T> node = getNode(index);
        return node.getData();
    }
    
    public T getFirst() {
        return start.getData();
    }
    
    public T getLast() {
        return start.getPrev().getData();
    }
    
    
    public void set(int index, T data) {
        Node<T> node = getNode(index);
        node.setData(data);
    }
    
    public void insert(int index, T item) {
        if (index == 0){
            addFirst(item);
        }
        else if (index == size()) {
            addLast(item);
        }
        else {
            Node<T> location = getNode(index);
            Node<T> node = new Node<>(item, location.getPrev(), location);
            location.getPrev().setNext(node);
            location.getNext().setPrev(node);
            size++;
        }
    }
    
    public Iterator<T> iterator() {
        return new DLCLIterator(start);
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Node<T> cursor = start;
        
        for (int i = 0; i < size - 1; i += 1) {
            sb.append(cursor.getData() + ", ");
            cursor = cursor.getNext();
        }
        
        if (size > 0) {
            sb.append(cursor.getData());
        }
        
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Iterator class to use within DLCList class
     */
    private class DLCLIterator<T> implements Iterator {
        private Node<T> cursor;
        private int size;
        
        public DLCLIterator(Node<T> start) {
            this.cursor = start;
            this.size = DLCList.this.size;
        }
        
        public boolean hasNext() {
            return size > 0;
        }
        
        //dont want to bother with this
        public void remove() {
            throw new UnsupportedOperationException("Not yet implemented");
        }
        
        public T next() {
            Node<T> item = cursor;
            size--;
            cursor = cursor.getNext();
            return item.getData();
        }
    }  
}

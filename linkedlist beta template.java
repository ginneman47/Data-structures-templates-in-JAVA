import java.util.*;

public class LinkedList {
    static Node head = null;
    static Node temp = null;
    static Node printer = null;
    static Node backer = new Node(-1);
    static Node mover = null;
    static int counter = 0;
    
    static class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    
    public void addNode(Node obj){// call this method to append node at the ending of the list ex:- LinkedList.addNode(data);
        if(head == null){
            head = obj;
            temp = obj;
        }
        else{
            temp.next = obj;
            temp = obj;
        }
    }
    
    public void traverseList(){//call this method to prints the list ex: - LinkedList.traverseList();
        printer = head;
        while(printer!=null){
            System.out.print(printer.data+" ");
            printer = printer.next;
        }
    }
    
    public void removeNode(int position){// call this method to remove node at a particular position
        mover = head;
        backer.next = head;
        counter = 1;
        
        while(counter<=position){
            if(counter == position){
                backer.next = mover.next;
                mover.next = null;
                return;
            }
            else{
                mover = mover.next;
                backer = backer.next;
            }
            
            counter = counter+1;
        }
        
        
    }
    
    public void positionAddNode(int value,int position){// call this method to add node at a particular position
        mover = head;
        counter =1;
        int replace;
        while(counter<=position){
            if(counter == position){
                break;
            }
            else{
                counter+=1;
                mover = mover.next;
                System.out.println(mover.data);
            }
        }
        
        replace = mover.data;
        mover.data = value;
        Node obj = new Node(-1);
        obj.data = replace;
        obj.next = mover.next;
        mover.next = obj;
        
        return;
        
    }
    
    public void addAtBeginning(int data){// call this method add node at the beginning ex :- LinkedList.addAtBeginning(data);
        Node obj = new Node(data);
        obj.next = head;
        head = obj;
    }
    
    public void addAtEnd(int data){// call this method add node at the end ex :- LinkedList.addAtEnd(data);
        Node obj = new Node(data);
        
        mover = head;
        
        while(mover.next!=null){
            mover = mover.next;
        }
        mover.next = obj;
        obj.next = null;
    }
    
    public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    LinkedList l1 = new LinkedList();
    int testcases = sc.nextInt();
    int data;
    while(testcases-->0){
        data = sc.nextInt();
        Node n1 = new Node(data);
        l1.addNode(n1);
    }
    
    }
}
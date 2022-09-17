import java.util.*;
import java.io.*;

public class LinkedList{
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
    
    
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
		private final BufferedWriter bw;

		public FastWriter() {
			this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(Object object) throws IOException {
			bw.append("" + object);
		}

		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            LinkedList l1 = new LinkedList();
            int testCases=in.nextInt();
            while(testCases-- > 0){
                // write code here
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
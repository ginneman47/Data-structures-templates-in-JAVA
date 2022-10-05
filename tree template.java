//You might see me printing "here" to the console. Those are just for de-bugging purposes
//In this implementation the root deletion is not included.

public class BST {
    static Node root = null;
    static Node successor = null;
    static Node ref = null;

    static int replace;
    static int direction = 0;
    
    static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    public void addNode(Node obj,Node temp){
        if(root == null){
            root = obj;
            return;
        }
        
        else{
            if(obj.data<=temp.data){
                if(temp.left == null){
                    temp.left = obj;
                    return;
                }
                
                else{
                    addNode(obj,temp.left);
                }
            }
            else if(obj.data>temp.data){
                if(temp.right==null){
                    temp.right = obj;
                }
                else{
                    addNode(obj,temp.right);
                }
                
            }
        }
    }
    
    public void preOrder(Node rootus){
        if(rootus!=null){
            System.out.println(rootus.data);
            preOrder(rootus.left);
            preOrder(rootus.right);
        }
    }
    
    public void inOrder(Node rootus){
        if(rootus!=null){
            inOrder(rootus.left);
            System.out.println(rootus.data);
            inOrder(rootus.right);
        }
    }
    
    public void postOrder(Node rootus){
        if(rootus!=null){
            postOrder(rootus.left);
            postOrder(rootus.right);
            System.out.println(rootus.data);
        }
    }
    
    //deletion
    public void deleteNode(Node node,int value){
        //System.out.println("here1");
        if(node == root && node.data == value){
            System.out.println("cant do root deletion for now");
        }
        
        else{
            //System.out.println("here2");
            if(value<= node.data){
                //System.out.println("here3");
        
                if(node.left.data == value){
                    if(node.left.left == null && node.left.right == null){
                        node.left = null;
                    }
                    else if(node.left.left==null || node.left.right == null){
                        Node temp = node.left;
                        temp = (temp.left == null) ? temp.right: temp.left;
                        node.left = temp;
                    }
                    else{
                        Node greatest = node.left.left;
                        while(greatest.right!=null){
                            greatest = greatest.right;
                        }
                        greatest.right = node.left.right;
                        
                        //final connection here
                        node.left = node.left.left;
                    }
                }
                else{
                    //System.out.println("here--left");
                    deleteNode(node.left,value);
                }
            }
            else if(value >= node.data){
                //System.out.println("here4");

                if(node.right.data == value){
                    if(node.right.left == null && node.right.right == null){
                        
                        node.right = null;
                        
                    }
                    else if(node.right.left == null || node.right.right == null){
                        Node temp = node.right;
                        temp = (temp.left == null)? temp.right : temp.left;
                        node.right = temp;
                    }
                    
                    else{
                        Node greatest = node.left.left;
                        
                        while(greatest.right!=null){
                            greatest = greatest.right;
                        }
                        greatest.right = node.right.right;
                        
                        
                        //final connection here
                        node.right = node.right.left;
                    }
                }
                else{
                    //System.out.println("here--right");
                    deleteNode(node.right,value);
                }
            }
        }
    }
    
    public static void main(String args[]) {
     BST b1 = new BST();
     Node n1 = new Node(50);
     b1.addNode(n1,root);
     Node n2 = new Node(30);
     b1.addNode(n2,root);
     Node n3 = new Node(70);
     b1.addNode(n3,root);
     Node n4 = new Node(20);
     b1.addNode(n4,root);
     Node n5 = new Node(40);
     b1.addNode(n5,root);
     Node n6 = new Node(60);
     b1.addNode(n6,root);
     Node n7 = new Node(80);
     b1.addNode(n7,root);
     
     //b1.postOrder(root);
     b1.deleteNode(root,60);
     b1.inOrder(root);
    }
}
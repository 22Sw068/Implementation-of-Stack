import java.util.EmptyStackException;
public class Stack_BY_LinkedList {
    static  class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
     static class Stack {
         public static Node head;// linked list->head  and stack -> top

         public static boolean isEmpty() {
             return head == null;
         }

         public static void push(int data) {
             Node newNode = new Node(data);
             if (isEmpty()) {
                 head = newNode;
                 return;
             }
             newNode.next = head;
             head = newNode;
         }

         public static int pop() {
             if (isEmpty()) {
                 return -1;
             }
             int top = head.data;// new element top jis mian head k data hona chai
             head = head.next;// new head would be old head next
             return top;// return top
         }

         public static int peek() {
             if (isEmpty()) {
                 return -1;
             }
             return head.data;
         }
         public String toString() {
             StringBuilder s = new StringBuilder("[");
             Node current = head;
             while (current != null) {
                 s.append(current.data);
                 if (current.next != null) {
                     s.append(", ");
                 }
                 current = current.next;
             }
             s.append("]");
             return s.toString();
         }

         public String toString(int[] arr) {
             StringBuilder str = new StringBuilder("{");
             Node currNode = head;
             while (currNode != null) {
                 str.append(currNode.data);
                 if (currNode.next != null) {
                     str.append(", ");
                 }
                 currNode = currNode.next;
             }
             str.append("}");
             return str.toString();
         }

         public Boolean Search(Stack s1, int element) {
             Stack_BY_LinkedList st = new Stack_BY_LinkedList();
             boolean check = false;

             if (s1.isEmpty()) {
                 return check;
             }

             Stack tempStack = new Stack();  // Create a temporary stack to store popped elements
             while (!s1.isEmpty()) {
                 int currentElement = s1.pop();
                 tempStack.push(currentElement);  // Push the popped element to the temporary stack

                 if (currentElement == element) {
                     check = true;
                     break;  // Element found, exit the loop
                 }
             }

             // Restore the original stack by pushing elements back from the temporary stack
             while (!tempStack.isEmpty()) {
                 s1.push(tempStack.pop());
             }

             return check;
         }


         public static int[] toArrayStack() {
             int[] res = new int[size()];
             Node current = head;
             int index = 0;
             while (current != null) {
                 res[index++] = current.data;
                 current = current.next;
             }
             return res;
         }

         public Boolean equals(Stack stack1, Stack stack2) {
             if (stack1.size() != stack2.size()) {
                 return false;
             }

             int[] arr1 = stack1.toArrayStack();
             int[] arr2 = stack2.toArrayStack();

             for (int i = 0; i < arr1.length; i++) {
                 if (arr1[i] != arr2[i]) {
                     return false;
                 }
             }

             return true;
         }

         public static int size() {
             int count = 0;
             Node current = head;
             while (current != null) {
                 count++;
                 current = current.next;
             }
             return count;
         }

         public static void RemoveBottom(Stack top) {
             if (top == null) {
                 throw new EmptyStackException(); // Use the 'throw' keyword
             }

             if (top.head == null) {
                 throw new EmptyStackException(); // Throw the exception if the stack is empty
             }

             if (top.head.next == null) {
                 top.head = null;
             } else {
                 Node current = top.head;
                 while (current.next.next != null) {
                     current = current.next;
                 }
                 current.next = null;
             }
         }

     }

         public static void main(String[] args) {
      Stack s1= new Stack();
      Stack s2= new Stack();

        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);
        s1.push(50);
        s2.push(100);
        s2.push(200);
        s2.push(30);
        s2.push(40);
        s2.push(500);
        s1.Search(s1,30);

//        System.out.println(s2.toString());
//        int[] arrayStack = s1.toArrayStack();
//        System.out.println( s1.toString(arrayStack));
//
//        System.out.println( s1.equals(s1, s2));
    }

}

//      while(!s.isEmpty()){
//          System.out.println(s.peek());
//          s.pop();
//      }

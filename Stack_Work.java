import java.util.Stack;

class Node6{
    int data;
    Node6 next;
    Node6(int data){
        this.data=data;

    }
}
 class stack{
    public  static Node6 head;// node ka head and top of the stack
    public static boolean isEmplty(){
        return head==null;
    }
    public void push(int data){
        Node6 newNode= new Node6(data);
        if(isEmplty()){
            head=newNode;
            return;
        }
        newNode.next= head;
        head=newNode;

    }
    public int top(){
        if(isEmplty()){
            return -1;
        }
        int top= head.data;
        head=head.next;
        return top;
    }
    public int peek(){
        if(isEmplty()){
            return -1;
        }
        return head.data;

    }

}
public class Stack_Work {
    public static void main(String[] args) {
        Stack friutKart = new Stack();
        Stack Coldrink = new Stack();
        friutKart.push(" Lemon");
        friutKart.push(" Orange");
        friutKart.push("Banana");
        friutKart.push(" Mango");
        Coldrink.push(" Pepsi");
        Coldrink.push("7up");
        Coldrink.push(" DEW");
        Coldrink.push(" Sting");

        while (!friutKart.isEmpty()) {
            Coldrink.push(friutKart.pop());
        }
        while (!Coldrink.isEmpty()) {
            System.out.println(Coldrink.pop());
        }
        while(!Coldrink.isEmpty()){
            friutKart.push(Coldrink);
        }

    }
}

//        st.push(1);
//        st.push(4);
//        st.push(5);
//        st.push(6);
//        while(!st.isEmpty()){
//            System.out.println(st.peek());
//            st.pop();




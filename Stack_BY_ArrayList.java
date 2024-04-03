
import java.util.ArrayList;

public class Stack_BY_ArrayList {
    static class Stack1 {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        public static void push(int data) {
            list.add(data);
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size()) - 1;

        }
        public String toString() {
            StringBuilder str2 = new StringBuilder("{");
            for (int i = 0; i < list.size(); i++) {
                str2.append(list.get(i));
                if (i < list.size() - 1) {
                    str2.append(", ");
                }
            }
            str2.append("}");
            return str2.toString();
        }
    }

    public static void main(String[] args) {
        Stack_BY_LinkedList.Stack s1 = new Stack_BY_LinkedList.Stack();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);
        System.out.println(s1.toString()+" ");

    }
}
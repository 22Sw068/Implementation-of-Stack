interface Stack{
    public Object peek();
    public Object pop();
    public void push(Object obj);
    public int size();
}
class ArrayStack implements Stack{
    private Object[] a;
    private int size;
    public ArrayStack(int capacity){
        a = new Object[capacity];
    }
    public boolean isEmpty(){
        return (size==0);
    }
    //// -------------|> peek() method <|----------------\\\\
    @Override
    public Object peek() {
        if (size==0) {
            throw new IllegalStateException("Stack is empty");
        }
        return a[size-1];
    }

    //// -------------|> pop() method <|----------------  \\\\
    @Override
    public Object pop() {
        Object temp = a[--size];
        a[size] = null;
        return temp;
    }
    ////-------------|> push() method <|----------------\\\\

    @Override
    public void push(Object obj) {
        if (size==a.length){
            resize();
        }
        a[size++] = obj;
    }
    ////-------------|> size() method <|----------------\\\\
    @Override
    public int size() {
        return size;
    }

    private void resize(){
        Object[] aa = a;
        a = new Object[2*aa.length];
        //   System.arraycopy(aa,0,a,0,size); // Or
        for(int i=0;i<aa.length;i++){
            a[i] = aa[i];
        }
    }

}

public class Stack_By_Array {
    public static void main(String[] args) {
        ArrayStack fruitKrat = new ArrayStack(10);
        fruitKrat.push("Oranges");
        fruitKrat.push("Kewi");
        fruitKrat.push("Chiku");
        fruitKrat.push("Tomato");
        System.out.println(fruitKrat.peek());

        ArrayStack ColdDrink = new ArrayStack(10);

        ColdDrink.push("Cola Next");
        ColdDrink.push("Pakola");
        ColdDrink.push("7Up");
        ColdDrink.push("Mountain Dew");

        while (fruitKrat.size()>0){
            ColdDrink.push(fruitKrat.pop());
        }

        while(ColdDrink.size()>0) {
            System.out.print(ColdDrink.pop()+"    ");
    }
    }
}
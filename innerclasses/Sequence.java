//: innerclasses/Sequence.java
// Holds a sequence of Objects.

//  迭代器设计模式，在接口中定义好相关方法，子类按照的自己的迭代方式进行实现
interface Selector {
  boolean end();
  Object current();
  void next();
}	

public class Sequence {
  private Object[] items;
  private int next = 0;
  public Sequence(int size) { items = new Object[size]; }
  public void add(Object x) {
    if(next < items.length)
      items[next++] = x;
  }
  private class SequenceSelector implements Selector {
    private int i = 0;
	  // 内部类直接使用外部类的私用属性items
    public boolean end() { return i == items.length; }
    public Object current() { return items[i]; }
    public void next() { if(i < items.length) i++; }
  }
  public Selector selector() {
    return new SequenceSelector();
  }	
  public static void main(String[] args) {
    Sequence sequence = new Sequence(10);
    for(int i = 0; i < 10; i++)
      sequence.add(Integer.toString(i));
    Selector selector = sequence.selector(); 
    while(!selector.end()) {
      System.out.print(selector.current() + " ");
      selector.next();
    }
  }
} 

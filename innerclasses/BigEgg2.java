//: innerclasses/BigEgg2.java
// Proper inheritance of an inner class.
import static net.mindview.util.Print.*;

class Egg2 {
  protected class Yolk {
    public Yolk() { print("Egg2.Yolk()"); }
    public void f() { print("Egg2.Yolk.f()");}
  }
  private Yolk y = new Yolk();
  public Egg2() { print("New Egg2()"); }
  public void insertYolk(Yolk yy) { y = yy; }
  public void g() { y.f(); }
}	

public class BigEgg2 extends Egg2 {
  public class Yolk extends Egg2.Yolk {
    public Yolk() { print("BigEgg2.Yolk()"); }
    public void f() { print("BigEgg2.Yolk.f()"); }
  }
  // 在调用此方法时 发生了向上转型BigEgg2将自己的Yolk对象向上转型为Egg2中的引用y
  public BigEgg2() { insertYolk(new Yolk()); }

  public static void main(String[] args) {
    Egg2 e2 = new BigEgg2();
    e2.g();
  }
} /* Output:
Egg2.Yolk() 
New Egg2()
Egg2.Yolk()
BigEgg2.Yolk()
BigEgg2.Yolk.f()
*///:~
/*
结果输出分析：当执行new BigEgg2()时，程序走到BigEgg2的无参构造器
进入无参构造器之后，调用父类的无参构造器，进入父类的无参构造器之后
发现私有变量y,于是调用Yolk类的构造器给y变量进行实例化
*/

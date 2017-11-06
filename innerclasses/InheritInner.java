//: innerclasses/InheritInner.java
// Inheriting an inner class.

class WithInner {
  class Inner {
  	
  	/*当被继承的内部类只有非默认构造器时应该怎么办呢？
  	public Inner(int i){
      System.out.println(i);
    }
    */
  }

}
/*
Java内部类的构造器必须连接到指向其外围类对象的引用，所以在继承内部类的时候，
需要在导出类(继承类)的构造器中手动加入对基类构造器的调用。
因为，在导出类(继承类)实例化时，并不存在一个外围类对象，以让导出类(继承类)的实例去连接到它。
所以，我们需要创建一个外围类，然后用一个特定的语法来表明内部类与外围类的关系。
在下例子中，需要给导出类InheritInner一个来自内部类的外围类中的引用。
普通的继承，只需在导出类构造器中加入super();，而内部类则需要外围类对象引用.super()；
*/
public class InheritInner extends WithInner.Inner {
  //! InheritInner() {} // Won't compile
  InheritInner(WithInner wi) {
    wi.super();
    //如代码所示，当被继承的构造器需要参数时，应把参数传递给这个super函数
    /*
    int i=0;
    wi.super(i);
    */
  }
  public static void main(String[] args) {
    WithInner wi = new WithInner();
    InheritInner ii = new InheritInner(wi);
  }
} ///:~

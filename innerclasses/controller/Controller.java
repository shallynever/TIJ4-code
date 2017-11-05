//: innerclasses/controller/Controller.java
// The reusable framework for control systems.
package innerclasses.controller;
import java.util.*;

public class Controller {
  // A class from java.util to hold Event objects:
  private List<Event> eventList = new ArrayList<Event>();
  public void addEvent(Event c) { eventList.add(c); }
  public void run() {
    while(eventList.size() > 0)
      // Make a copy so you're not modifying the list
      // while you're selecting the elements in it:
      /*
        设计模式总是将变化的事物与保持不变的事物分离开,在这个设计模式中
        模板方法是保持不变的事物，而可覆盖的方法就是变化的事物
        注意：在目前的设计中，并不知道Event到底做了什么。这正是此设计的
        关键所在，“是变化的事物与不变的事物相互分离”。“变化事物”就是各种
        不同的Event对象所具有的不同行为，不同的行为是通过创建不同的Event
        子类表现出来。
      */
      for(Event e : new ArrayList<Event>(eventList))
        if(e.ready()) {
          System.out.println(e);
          e.action();
          eventList.remove(e);
        }
  }
} ///:~

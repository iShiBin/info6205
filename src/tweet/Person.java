package tweet;
import java.time.LocalTime;
import java.util.function.*;

class Person implements Consumer<Message>, Supplier<Message>{
  String name;
  int age;
  String location;
  
  Person(String name, int age, String location){
    this.name=name;
    this.age=age;
    this.location=location;
  }
  
  Person(String name, int age){
    this.name=name;
    this.age=age;
  }

  @Override
  public void accept(Message msg) {
    System.out.println(this.name + "received a tweet: "+ msg.toString());
  }

  @Override
  public Message get() {
    return new Message(this.name + " sent a tweet.");
  }
}

package tweet;

import java.time.*;

class Message {
  private String msg;
  private LocalDateTime time;
  
  LocalDateTime getTime() {
    return time;
  }

  String getMsg() {
    return msg;
  }

  void setMsg(String msg) {
    this.msg = msg;
  }

  Message(String message){
    this.msg=message;
    this.time=LocalDateTime.now();
  }
  
  @Override
  public String toString(){
    return this.msg + time.toString();
  }
}

using System;

class TweetMessage: EventArgs{
    public string Message { get; set; }
    public DateTime time { get; set; }

    public TweetMessage(string Message){
        this.Message = Message;
        this.time = DateTime.Now;

    }

}
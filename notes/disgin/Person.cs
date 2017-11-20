using System;

class Person{

    public string Name { get; set; }
    public int Age { get; set; }
    public string Location { get; set; }


    public Person(string Name, int Age, string Location){
        this.Name = Name;
        this.Age = Age;
        this.Location = Location;
    }

    public event EventHandler<TweetMessage> tweetEvent;

    public void SendTweet(string message){

        TweetMessage tweet = new TweetMessage(message);

        if(tweetEvent != null){
            tweetEvent(this, tweet);
        }
    }

    public void PrintTweet(object sender, TweetMessage e){

        Person tweeter = (Person) sender;

        Console.WriteLine(this.Name + ": " + tweeter.Name + " Tweeted This Message: " + e.Message + " at " +
            e.time.ToString());

    }

    public void Follow(Person person){
        person.tweetEvent += PrintTweet;
    }

    public void UnFollow(Person person){
        person.tweetEvent -= PrintTweet;
    }

}

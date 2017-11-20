using System;
using System.Threading;

namespace Twitter
{

    class Program
    {
        static Person trump;
        static Person hillary;

         private static void TweetFunc(object obj){
            Random rand = new Random();
            int wait = 0;
            while(true){
                wait = rand.Next(1000, 10000);
                Thread.Sleep(wait);
                trump.SendTweet("Some Random Tweet " + wait.ToString());

                wait = rand.Next(1000, 10000);
                Thread.Sleep(wait);
                hillary.SendTweet("Another Meaningless Random Tweet " + wait.ToString());
            }
        }
        static void Main(string[] args)
        {
            trump = new Person("@DonaldTrump", 67, "Washington DC");
            hillary = new Person("@Hillary", 65, "NY");

            Person ashish = new Person("@Ashish", 16, "Seattle");
            Person siva = new Person("@Siva", 18, "Seattle");
            Person nan = new Person("@Nan", 21, "Seattle");
            Person yalin = new Person("@Yalin", 20, "Seattle");


            ashish.Follow(trump);
            ashish.Follow(hillary);
            ashish.UnFollow(trump);
          /*  siva.Follow(trump);
            nan.Follow(trump);
            yalin.Follow(trump);
            hillary.Follow(trump);

            ashish.Follow(hillary);
            siva.Follow(hillary);
            nan.Follow(hillary);
            yalin.Follow(hillary);
            trump.Follow(hillary);*/



            Thread th = new Thread( new ParameterizedThreadStart(TweetFunc));

            th.Start("abc");

            while(true){
                Console.WriteLine("Main Function");
                Thread.Sleep(5000);
            }
        }
    }
}

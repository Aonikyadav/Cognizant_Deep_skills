package WEEK1.DesignPattern.DecoratorPatternExample;

public class EmailNotifier  implements  Notifier{

    @Override
    public  void  send(String message){
        System.out.println("Sending Emial Notification" + message);
    }
}

package WEEK1.DesignPattern.SingletonPatternExample;

public class SingletonTest {

    public static void main(String[] args) {
        
        Logger l1 = Logger.getInstance();    // this is not an object, it is a reference variable

        Logger l2 = Logger.getInstance();


        l1.log("Application has started");
        l2.log("Application is currently running");

        if(l1 == l2){
            System.out.println("Both references point to the same Logger instance");
        }
        else{
            System.out.println("Different logger instances were created");
        }
        
    }
    
}

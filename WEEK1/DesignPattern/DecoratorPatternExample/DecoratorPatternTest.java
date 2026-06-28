package WEEK1.DesignPattern.DecoratorPatternExample;

public class DecoratorPatternTest {

    public static void main(String[] args) {

        String msg = "Your payment was successful. Thank you!";

        System.out.println("Only Email Notification:");
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send(msg);

        System.out.println();

        System.out.println("Email and SMS Notification:");
        Notifier emailSmsNotifier =
                new SMSNotifierDecorator(new EmailNotifier());

        emailSmsNotifier.send(msg);

        System.out.println();

        System.out.println("Email, SMS and Slack Notification:");
        Notifier allChannelNotifier =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()
                        )
                );

        allChannelNotifier.send(msg);
    }
}
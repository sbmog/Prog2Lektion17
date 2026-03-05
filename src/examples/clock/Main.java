package examples.clock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ConcreteTimeSubject subject = new ConcreteTimeSubject();

        TimeObserver digitalTimeObserver = new DigitalTimeObserver();
        subject.registerTimeObserver(digitalTimeObserver);
        TenSeconds(subject);

        TimeObserver analogTimeObserver = new AnalogTimeObserver();
        subject.registerTimeObserver(analogTimeObserver);
        TenSeconds(subject);

        subject.removeTimeObserver(digitalTimeObserver);
        TenSeconds(subject);
    }

    private static void TenSeconds(ConcreteTimeSubject subject) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            subject.changeTime();
            Thread.sleep(1000);
        }
    }
}

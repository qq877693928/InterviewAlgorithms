public class SynchronizedTest1 {

    private static volatile SynchronizedTest1 instance = null;

    private SynchronizedTest1() {

    }

    public static SynchronizedTest1 getInstance() {
        if(instance == null) {
            synchronized (SynchronizedTest1.class) {
                if (instance == null) {
                    instance = new SynchronizedTest1();
                }
                return instance;
            }
        }
        return instance;
    }
}

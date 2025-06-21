package algorithms;

import java.util.concurrent.atomic.AtomicInteger;

public class _100MutliThreadPrinter {

    public static void main(String[] args) {

        AtomicInteger flag = new AtomicInteger(1);
        AtomicInteger count = new AtomicInteger(0);

        Object lock = new Object();

        Thread thread3 = new Thread() {
            private final int state = 3;
            @Override
            public void run() {
                while (count.get() < 100) {
                    synchronized (lock) {
                        while (flag.get() != state) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println("==================" + count.incrementAndGet());
                        flag.set(1);
                        lock.notifyAll();
                    }
                }
            }
        };

        Thread thread2 = new Thread() {
            private final int state = 2;
            @Override
            public void run() {
                while (count.get() < 100) {
                    synchronized (lock) {
                        while (flag.get() != state) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println("==================" + count.incrementAndGet());
                        flag.set(3);
                        lock.notifyAll();
                    }
                }
            }
        };

        Thread thread1 = new Thread() {
            private final int state = 1;
            @Override
            public void run() {
                while (count.get() < 100) {
                    synchronized (lock) {
                        while (flag.get() != state) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println("==================" + count.incrementAndGet());
                        flag.set(2);
                        lock.notifyAll();
                    }
                }
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

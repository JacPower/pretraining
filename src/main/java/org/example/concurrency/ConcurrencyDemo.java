package org.example.concurrency;

import java.util.concurrent.*;

public class ConcurrencyDemo {

    public static void demonstrateConcurrency() {
        demonstrateThreadCreation();
        demonstrateRunnableInterface();
        demonstrateSynchronization();
        demonstrateExecutorService();
    }



    private static void demonstrateThreadCreation() {
        System.out.println("\n>>> Thread Creation (extending Thread class):");

        class MyThread extends Thread {
            private final String threadName;



            public MyThread(String name) {
                this.threadName = name;
            }



            @Override
            public void run() {
                for (int i = 1; i <= 3; i++) {
                    System.out.println(threadName + " - Count: " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println(threadName + " interrupted");
                    }
                }
                System.out.println(threadName + " finished");
            }
        }

        MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    private static void demonstrateRunnableInterface() {
        System.out.println("\n>>> Runnable Interface:");

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is running");
            for (int i = 1; i <= 3; i++) {
                System.out.println(threadName + " - Processing: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " completed");
        };

        Thread t1 = new Thread(task, "Runnable-1");
        Thread t2 = new Thread(task, "Runnable-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    private static void demonstrateSynchronization() {
        System.out.println("\n>>> Synchronization:");

        class Counter {
            private int count = 0;



            // Synchronized method
            public synchronized void increment() {
                count++;
            }



            public int getCount() {
                return count;
            }
        }

        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count (with synchronization): " + counter.getCount());
        System.out.println("Expected: 2000 (synchronized access prevents race conditions)");
    }



    private static void demonstrateExecutorService() {
        System.out.println("\n>>> ExecutorService (Thread Pool):");

        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Task " + taskId + " is running on " + threadName);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskId + " completed");
            });
        }

        // Shutdown executor
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
            System.out.println("✓ All tasks completed");
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        // Callable and Future
        demonstrateCallableAndFuture();
    }



    private static void demonstrateCallableAndFuture() {
        System.out.println("\n>>> Callable and Future:");

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            System.out.println("Calculating sum...");
            Thread.sleep(500);
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            return sum;
        };

        Future<Integer> future = executor.submit(task);

        try {
            System.out.println("Waiting for result...");
            Integer result = future.get(); // Blocking call
            System.out.println("Sum of 1 to 10: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}

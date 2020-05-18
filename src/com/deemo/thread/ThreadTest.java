package com.deemo.thread;

import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {

    @Test
    public void forTest() {
        List<Integer> a = new ArrayList<Integer>() {
            {
                this.add(1);
                this.add(2);
                this.add(3);
                this.add(4);
                this.add(5);
                this.add(6);
                this.add(7);
                this.add(8);
                this.add(9);
            }
        };

        System.out.println(a);

        for (Integer integer : a) {
            System.out.println(integer);
            if (integer > 2) {
                a.remove(integer);
            }
        }

        System.out.println(a);
    }

    @Test
    // 测试子父线程相互终结
    public void testThread() {
        final Thread parentThread = Thread.currentThread();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("==========子线程..., i = " + i + ", isInterrupted = " + Thread.currentThread().isInterrupted());

                    if (i++ > 2) {
                        parentThread.interrupt();
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }).start();

        try {
            // 子线程强行停止父线程，当父线程处于sleep阶段时，会强行抛出异常
            Thread.sleep(100 * 1000);
            System.out.println("==========父线程..., isInterrupted = " + Thread.currentThread().isInterrupted());
        } catch (InterruptedException e) {
            // The interrupted status of the current thread is cleared when this exception is thrown.
            System.out.println("error..., isInterrupted = " + Thread.currentThread().isInterrupted());
        }

    }

    // 多线程数量的问题，一般情况下，多线程数量要等于机器CPU核数-1.
    @Test
    public void testListWithOutThread() throws Exception {

        // 开始时间
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 3100; i++) {
            list.add(i + "");
        }

        for (String s : list) {
            Thread.sleep(10);
            System.out.println(Thread.currentThread().getName() + "线程：" + s);
        }

        // 关闭线程池
        System.out.println("线程任务执行结束");
        System.err.println("执行任务消耗了 ：" + (System.currentTimeMillis() - start) + "毫秒");
    }

    @Test
    public void testListWithThreadButNothing() {
        List<String> list = new ArrayList<>();
        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < 3000; i++) {
            list.add("" + i);
        }

        int pcount = Runtime.getRuntime().availableProcessors();
        long start = System.currentTimeMillis();
        System.out.println(pcount);
        for (int i = 0; i < pcount; i++) {

            Thread t = new MyThread(list, map);
            map.put(t.getId(), i);
            t.start();
            System.out.println("continue...");
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("----" + (System.currentTimeMillis() - start));
    }

    public static void handleList(List<String> list, int threadNum) {
        int totalSize = list.size();
        int threadSize = totalSize % threadNum == 0 ? totalSize / threadNum : totalSize / threadNum + 1;
        int end;

        for (int i = 0; i < threadNum; i++) {
            end = (i + 1) * threadSize;
            new HandleThread("Thread: " + i, list, i * threadSize, end > totalSize ? totalSize : end).start();
        }

    }

    @Test
    public void testListWithThread() {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 300000; i++) {
            list.add("" + i);
        }

        handleList(list, 1000);

    }

    @Test
    public void testListWithThreadTask() throws Exception {

        // 开始时间
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 3100; i++) {
            list.add(i + "");
        }
        // 每500条数据开启一条线程
        int threadSize = 500;
        // 总数据条数
        int dataSize = list.size();
        // 线程数
        int threadNum = dataSize / threadSize + 1;
        // 定义标记,过滤threadNum为整数
        boolean special = dataSize % threadSize == 0;

        // 创建一个线程池
        ExecutorService exec = Executors.newFixedThreadPool(threadNum);
        // 定义一个任务集合
        List<Callable<Integer>> tasks = new ArrayList<>();
        Callable<Integer> task;
        List<String> cutList;

        // 确定每条线程的数据
        for (int i = 0; i < threadNum; i++) {
            if (i == threadNum - 1) {
                if (special) {
                    break;
                }
                cutList = list.subList(threadSize * i, dataSize);
            } else {
                cutList = list.subList(threadSize * i, threadSize * (i + 1));
            }
            // System.out.println("第" + (i + 1) + "组：" + cutList.toString());
            final List<String> listStr = cutList;
            task = new Callable<Integer>() {

                @Override
                public Integer call() throws InterruptedException {
                    for (String s : listStr) {
                        Thread.sleep(10);
                        System.out.println(Thread.currentThread().getName() + "线程：" + s);
                    }
                    return 1;
                }
            };
            // 这里提交的任务容器列表和返回的Future列表存在顺序对应的关系
            tasks.add(task);
        }

        List<Future<Integer>> results = exec.invokeAll(tasks);

        for (Future<Integer> future : results) {
            System.out.println(future.get());
        }

        // 关闭线程池
        exec.shutdown();
        System.out.println("线程任务执行结束");
        System.err.println("执行任务消耗了 ：" + (System.currentTimeMillis() - start) + "毫秒");
    }

    // ========================== 多线程访问同一个List，保证线程安全 ========================================
    private final static List<String> asList = Collections.synchronizedList(new ArrayList<>(Arrays.asList("a","b")));

    @Test
    public void testListWithThreads() {

        /*List<String> strings = Arrays.asList("a", "b");
        strings.set(0, "c");
        strings.add("c");

        System.out.println(strings);*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                }
                reload();
            }
        }).start();
        synchronized (asList) {
            for (String e : asList) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                }

                System.out.println(e);
            }

        }
    }

    public static void reload() {
        System.out.println("reload...");
        asList.clear();
        asList.addAll(Arrays.asList("a", "b", "c"));
        System.out.println(asList);
    }
}

class MyThread extends Thread {
    private List<String> list;
    private Map<Long, Integer> map;

    MyThread(List<String> list, Map<Long, Integer> map) {
        this.list = list;
        this.map = map;
    }

    @Override
    public void run() {
        // super.run();
        int pcount = Runtime.getRuntime().availableProcessors();
        int i = map.get(Thread.currentThread().getId());

        for (; i < list.size(); i += pcount) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(list.get(i));
        }
    }
}

class HandleThread extends Thread {
    private String threadName;
    private List<String> list;
    private int start;
    private int end;

    HandleThread (String threadName, List<String> list, int start, int end) {
        this.threadName = threadName;
        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        List<String> subList = list.subList(start, end);

        System.out.println(threadName + ": " + subList);

        /*for (String s : subList) {
            System.out.println(threadName + ": " + s);
        }*/
    }
}
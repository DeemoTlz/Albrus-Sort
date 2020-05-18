package com.deemo.thread;

/**
 *
 * 从join方法的源码来看，join方法的本质调用的是Object中的wait方法实现线程的阻塞。
 * 但是我们需要知道的是，调用wait方法必须要获取锁，所以join方法是被synchronized修饰的，synchronized修饰在方法层面相当于synchronized(this), this就是previousThread本身的实例。
 * 有很多人不理解join为什么阻塞的是主线程呢? 不理解的原因是阻塞主线程的方法是放在previousThread这个实例作用，让大家误以为应该阻塞previousThread线程。
 * 实际上主线程会持有previousThread这个对象的锁，然后调用wait方法去阻塞，而这个方法的调用者是在主线程中的。所以造成主线程阻塞。
 *
 * 第二个问题，为什么previousThread线程执行完毕就能够唤醒住线程呢？或者说是在什么时候唤醒的？
 * 要了解这个问题，我们又得翻jdk的源码，但是如果大家对线程有一定的基本了解的话，通过wait方法阻塞的线程，需要通过notify或者notifyall来唤醒。
 * 所以在线程执行完毕以后会有一个唤醒的操作，只是我们不需要关心。
 * 接下来在hotspot的源码中找到 thread.cpp: ensure_join方法中，调用 lock.notify_all(thread); 唤醒所有等待thread锁的线程，意味着调用了join方法被阻塞的主线程会被唤醒；
 *
*/
public class JoinDemo extends Thread {
	private int i;
	// 上一个线程
	private Thread previousThread;

	private JoinDemo(Thread previousThread, int i) {
		this.previousThread = previousThread;
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println(previousThread + " join...");
		try {
			// 调用上一个线程的join方法，大家可以自己演示的时候可以把这行代码注释掉
			previousThread.join();
			// Thread.currentThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("num:" + i);
	}

	public static void main(String[] args) {
		Thread previousThread = Thread.currentThread();
		for (int i = 0; i < 10; i++) {
			JoinDemo joinDemo = new JoinDemo(previousThread, i);
			joinDemo.start();
			previousThread = joinDemo;
		}

		System.out.println("====================================");
	}
}
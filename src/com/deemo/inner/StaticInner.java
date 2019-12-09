package com.deemo.inner;

public class StaticInner {

	private int a = 1;
	public int b = 2;
	private static int c = 1;
	public static int d = 2;

	public static class Inner {
		private int a = 3;
		public int b = 4;
		private static int c = 1;
		public static int d = 2;

		public void print() {
			System.out.println("a = " + a);
			// new StaticInner().a;
			// System.out.println("StaticInner.a = " + StaticInner.a);
			System.out.println("StaticInner.c = " + StaticInner.c);
			System.out.println("b = " + b);
			System.out.println("StaticInner.d = " + StaticInner.d);
		}

		public static void prints() {
			System.out.println("c = " + c);
			System.out.println("StaticInner.c = " + StaticInner.c);
			System.out.println("d = " + d);
			System.out.println("StaticInner.d = " + StaticInner.d);
		}
	}

	public void print() {
		System.out.println("a = " + a);
		System.out.println("new Inner().a = " + new StaticInner.Inner().a);
		System.out.println("b = " + b);
		System.out.println("new Inner().b = " + new Inner().b);
		System.out.println("c = " + c);
		System.out.println("new Inner().c = " + Inner.c);
	}

	public void constrator() {
		Inner inner = new Inner();
	}

	public static void constrators() {
		Inner inner = new Inner();
	}
}

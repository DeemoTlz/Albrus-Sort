package com.deemo.foundation.inner;

public class MethodOuter {

	private int a = 1;
	public int b = 2;
	private static int c = 1;
	public static int d = 2;

	public void print() {
		class Inner {
			private int a = 3;
			public int b = 4;

			private void print() {
				int a = MethodOuter.this.a;
				a = this.a;
			}
		}
	}

	public static void prints() {
		class Inner {
			private int a = 3;
			public int b = 4;

			private void print() {
				// int a = MethodInner.a;
				int a = new MethodOuter().a;
				int c = MethodOuter.c;
				int d = MethodOuter.d;
			}

		}
	}
}

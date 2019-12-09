package com.deemo.tlz;

import com.deemo.inner.MemberOuter;
import com.deemo.inner.StaticOuter;

public class InnerTest {

	public static void main(String[] args) {
		MemberOuter memberInner = new MemberOuter();
		memberInner.print();
		System.out.println("=========================");
		MemberOuter.Inner inner = memberInner.new Inner();
		inner.b = 0;
		MemberOuter.Inner inner1 = new MemberOuter().new Inner();
		System.out.println(inner.b);
		System.out.println(inner1.b);


		StaticOuter staticOuter = new StaticOuter();
		int c = StaticOuter.d;
		int d = StaticOuter.Inner.d;

		StaticOuter.Inner inner2 = new StaticOuter.Inner();

	}
}

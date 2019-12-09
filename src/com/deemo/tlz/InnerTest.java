package com.deemo.tlz;

import com.deemo.inner.MemberInner;
import com.deemo.inner.StaticInner;

public class InnerTest {

	public static void main(String[] args) {
		MemberInner memberInner = new MemberInner();
		memberInner.print();
		System.out.println("=========================");
		MemberInner.Inner inner = memberInner.new Inner();
		inner.b = 0;
		MemberInner.Inner inner1 = new MemberInner().new Inner();
		System.out.println(inner.b);
		System.out.println(inner1.b);


		StaticInner staticInner = new StaticInner();
		int c = StaticInner.d;
		int d = StaticInner.Inner.d;

		StaticInner.Inner inner2 = new StaticInner.Inner();

	}
}

package com.deemo.foundation.inner;

public class AnonymousOuter {

	private int a = 1;
	public int b = 2;
	private static int c = 1;
	public static int d = 2;
	String gameClass = "三男一狗";

	public void print(final String gameMethodParam, final GTA gtaMethodParam) {
		/*new C() {
			@Override
			public void shopping() {

			}

			@Override
			void a() {

			}

			@Override
			public void game() {
				System.out.println(game);
				System.out.println(myGame);
			}

			@Override
			public void work() {

			}

			@Override
			public void walk() {

			}
		}.game();*/

		final String gameMethod = "三男一狗";
		final GTA gtaMethod = new GTA();
		String games = "三男一狗";

		new Super() {
			@Override
			public void eat() {

			}

			@Override
			public void thought() {

			}

			@Override
			public void save() {
			}

			@Override
			public void shopping() {

			}

			@Override
			public void playGame(String games, GTA gta) {
				System.out.println("外部类 调用方法的形参：" + gameMethodParam);
				System.out.println("外部类 成员变量：" + AnonymousOuter.this.gameClass);
				System.out.println("外部类 成员变量：" + AnonymousOuter.c);
				gtaMethodParam.play();
				gtaMethodParam.setName("给他爱5");

				System.out.println("==========================");

				System.out.println("外部类 方法成员变量：" + gameMethod);
				System.out.println("外部类 方法成员变量：" + gtaMethod);

				System.out.println("==========================");

				System.out.println("匿名内部类 方法参数：" + games);
				// 修改形参，对实参没有影响
				games = "给他爱5";
				// 将形参指向新对象时，会中断对实参的引用
				// gta = new GTA();
				// 通过引用地址修改，会同步修改
				gta.setName("GTA 5");

				System.out.println("==========================");
			}
		}.playGame(games, gtaMethod);

		System.out.println("修改形参：games 后：" + games);
		System.out.println("修改形参：gta 后：" + gtaMethod);
	}

	public static void main(String[] args) {
		AnonymousOuter anonymousOuter = new AnonymousOuter();

		GTA gta = new GTA();
		anonymousOuter.print("三男一狗", gta);
		gta.play();
	}

}

class GTA {
	private String name = "三男一狗";

	public void play() {
		System.out.println("Play " + name);
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "GTA{" +
				"name='" + name + '\'' +
				'}';
	}
}

interface Animal {
	void eat();
}

interface Person extends Animal {
	void thought();
}

interface Man extends Person {
	void playGame(String games, GTA gta1);
}

interface Woman extends Person {
	void shopping();
}

interface Super extends Man, Woman {
	void save();
}

/*abstract class A {
	abstract void a();
}

abstract class B {
	abstract void b();
}

abstract class C extends A implements Man, Woman {

}

class D extends A {

	@Override
	void a() {

	}
}*/

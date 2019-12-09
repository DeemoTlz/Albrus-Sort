package com.deemo.inner;

public class AnonymousOuter {

	private int a = 1;
	public int b = 2;
	private static int c = 1;
	public static int d = 2;
	String game = "三男一狗";

	public void print(final String game, final GTA gta) {
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

		final String myGame = "三男一狗";
		final GTA myGta = new GTA();
		String games = "三男一狗";

		new Super() {
			@Override
			public void save() {
			}

			@Override
			public void shopping() {

			}

			@Override
			public void game(String games, GTA gta1) {
				// 修改形参，对实参没有影响
				games = "给他爱5";
				// 通过引用地址修改，会同步修改
				gta1.setName("GTA 5");
				// 将形参指向新对象时，会中断对实参的引用
				// gta1 = new GTA();
				System.out.println("外部类调用方法形参：" + game);
				System.out.println("匿名内部类方法参数：" + games);
				System.out.println("匿名内部类成员变量：" + myGame);
				System.out.println("匿名内部类成员变量：" + myGta);
				System.out.println("外部类成员变量：" + AnonymousOuter.this.game);

				gta.play();
				gta.setName("给他爱5");
			}

			@Override
			public void work() {

			}

			@Override
			public void walk() {

			}
		}.game(games, myGta);
		System.out.println("修改形参：games 后：" + games);
		System.out.println("修改形参：myGta 后：" + myGta);

		new D() {
			@Override
			void a() {

			}
		};
	}

	public static void main(String[] args) {
		AnonymousOuter AnonymousOuter = new AnonymousOuter();

		GTA gta = new GTA();
		AnonymousOuter.print("三男一狗", gta);
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
}

interface Animal {
	void walk();
}

interface Person extends Animal {
	void work();
}

interface Man extends Person {
	void game(String games, GTA gta1);
}

interface Woman extends Person {
	void shopping();
}

interface Super extends Man, Woman {
	void save();
}

abstract class A {
	abstract void a();
}

/*abstract class B {
	abstract void b();
}

abstract class C extends A implements Man, Woman {

}*/

class D extends A {

	@Override
	void a() {

	}
}


package basic.io.decorator;

import basic.io.decorator.coffee.Coffee;
import basic.io.decorator.coffee.EtiopiaAmericano;
import basic.io.decorator.coffee.KenyaAmericano;
import basic.io.decorator.decorator.Latte;
import basic.io.decorator.decorator.Mocha;
import basic.io.decorator.decorator.WhippingCream;

public class CoffeTest {
	public static void main(String[] args) {
		Coffee etiopiaCoffee = new EtiopiaAmericano();
		etiopiaCoffee.brewing();

		System.out.println();

		Coffee etiopiaLatte = new Latte(etiopiaCoffee);
		etiopiaLatte.brewing();

		System.out.println();

		Coffee etiopiaMocha = new Mocha(new Latte(new EtiopiaAmericano()));
		etiopiaMocha.brewing();

		System.out.println();

		Coffee whippingCream = new WhippingCream(new Latte(new Mocha(new KenyaAmericano())));
		whippingCream.brewing();
	}
}

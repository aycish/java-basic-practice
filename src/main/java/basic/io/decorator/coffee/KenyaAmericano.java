package basic.io.decorator.coffee;

import basic.io.decorator.coffee.Coffee;

public class KenyaAmericano extends Coffee {

	@Override
	public void brewing() {
		System.out.println("Kenya Americano brewing");
	}
}

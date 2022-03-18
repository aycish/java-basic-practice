package basic.io.decorator.decorator;

import basic.io.decorator.coffee.Coffee;
import basic.io.decorator.decorator.Decorator;

public class Mocha extends Decorator {

	public Mocha(Coffee coffee) {
		super(coffee);
	}

	public void brewing() {
		super.brewing();
		System.out.println("Adding Mocha syrup ... ");
	}
}

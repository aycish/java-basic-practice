package basic.io.decorator.decorator;

import basic.io.decorator.coffee.Coffee;
import basic.io.decorator.decorator.Decorator;

public class WhippingCream extends Decorator {

	public WhippingCream(Coffee coffee) {
		super(coffee);
	}

	public void brewing() {
		// super를 통해, 본래의 기능 호출 + @를 구현
		super.brewing();
		System.out.println("Adding whipping cream ... ");
	}
}

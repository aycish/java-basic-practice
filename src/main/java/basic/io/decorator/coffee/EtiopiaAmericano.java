package basic.io.decorator.coffee;

import basic.io.decorator.coffee.Coffee;

/* ConcreteComponent 역할 */
public class EtiopiaAmericano extends Coffee {

	@Override
	public void brewing() {
		System.out.println("Etiopia Americano brewing");
	}
}

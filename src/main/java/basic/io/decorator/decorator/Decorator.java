package basic.io.decorator.decorator;

import basic.io.decorator.coffee.Coffee;

/* 단독으로 쓰이는 클래스가 아니기 때문에, abstract로 선언 */
public abstract class Decorator extends Coffee {

	Coffee coffee;

	public Decorator(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public void brewing() {
		coffee.brewing();
	}
}

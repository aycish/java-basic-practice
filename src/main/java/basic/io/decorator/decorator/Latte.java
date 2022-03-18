package basic.io.decorator.decorator;

import basic.io.decorator.coffee.Coffee;
import basic.io.decorator.decorator.Decorator;

public class Latte extends Decorator {

	/* 상위 클래스에서 디폴트 생성자가 존재하지 않아 추가 필요
	*  조상의 멤버를 초기화해서 사용하기 위함
	*/
	public Latte(Coffee coffee) {
		super(coffee);
	}

	public void brewing() {
		super.brewing();
		System.out.println("Adding milk to make Latte ...");
	}
}

package designpattern.decorator;

public class DecoratorTest {

	public static void main(String[] args) {
		ICar kia = new Kia(500);

		kia.showPrice();

		//K3
		ICar k3 = new K3(kia, "K3");
		k3.showPrice();

		//K5
		ICar k5 = new K5(kia, "K5");
		k5.showPrice();

		//K7
		ICar k7 = new K7(kia, "K7");
		k7.showPrice();
	}
}

package basic.stream.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PackageTravelTest {

	public static void main(String[] args) {
		List<Customer> customerList = new ArrayList<>();

		Customer customerLee = new Customer("이순신", 40, 100);
		Customer customerKim = new Customer("김유신", 20, 100);
		Customer customerHong = new Customer("홍길동", 13, 50);

		customerList.add(customerLee);
		customerList.add(customerKim);
		customerList.add(customerHong);

		/* 고객 명단 출력 */
		customerList.stream().forEach(customer -> System.out.println(customer));
		System.out.println();

		/* 고객 명단 중, 이름만 출력 */
		customerList.stream().map(customer -> customer.getName()).forEach(s -> System.out.println(s));
		System.out.println();

		/* 여행 총 경비 출력 */
		System.out.println(customerList.stream().mapToInt(customer -> customer.getPrice()).sum());
		System.out.println();

		/* 나이가 20세 이상인 고객만 출력 */
		customerList.stream().filter(customer -> customer.getAge() >= 20)
			.forEach(customer -> System.out.println(customer));
		System.out.println();

		/* 나이가 20세 이상인 고객들을 정렬하여 출력 */
		customerList.stream().filter(customer -> customer.getAge() >= 20)
			.sorted(Comparator.comparing(Customer::getName))
			.forEach(customer -> System.out.println(customer));

	}
}

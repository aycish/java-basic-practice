## 람다식(Lambda expression)

---

### [함수형 프로그래밍과 람다식]

- 자바
    - 기능을 수행하기 위해서 객체를 생성
    - 객체 내부에 멤버 변수를 선언 및 필요한 기능을 구현한 메서드를 구현
- 함수형 프로그래밍
    - 순수 함수를 구현하고 호출하여 외부 자료에 부수적인 영향을 주지 않도록 구현하는 방식
        - 순수 함수 : 매개변수만을 사용하여 만드는 함수로, 외부 변수를 사용하지 않기 대문에 함수가 수행되,더라도 외부에는 영향이 없음
    - 여러 자료가 동시에 수행되는 병렬처리가 가능
        - 즉, 함수의 기능이 데이터에 독립적임
        - 동일한 자료에 대해 동일한 결과를 보장  
           
### [람다식 문법]  

- 익명 함수 만들기  
- 매개 변수와 매개변수를 이용한 실행문(매개변수) → {실행문;}  

**두 수를 입력받아 더하는 add() 함수 예**  

```java
/* 기본 메서드 형식 */
int add(int x, int y) {
	return x + y;
}

/* 람다식 표현 */
(int x, int y) -> {return x+y};
```

**람다식 표현의 특징**

- 매개 변수가 하나인 경우, 자료형과 괄호 생략 가능

```java
str->{System.ouyt.println(str);}
```

- 매개 변수가 두 개 이상인 경우, 괄호를 생략할 수 없음

```java
x,y -> {System.out.println(x+y);} // 오류
```

- 실행문이 한 문장인 경우 중괄호 생략 가능

```java
str-> System.out.println(str);
```

- 실행문이 한 문장이라도 return문이 존재하면 중괄호를 생략할 수 없음

```java
str-> return str.length(); // 오류 발생
```

- 실행문이 한 문장의 반환문인 경우엔 return과 중괄호를 모두 생략할 수 있음

```java
(x, y) -> x * y;
str -> str.length;
```


## 함수형 인터페이스와 람다식

---

### [함수형 인터페이스 선언하기]

- 람다식을 선언하기 위한 인터페이스
- 익명 함수와 매개 변수만으로 구현되므로 인터페이스는 단 하나의 메서드만을 선언해야함
- @FunctionalInterface annotation 사용
    - 함수형 인터페이스라는 의미로, 단 하나의 메서드만 정의할 수 있다.


**어노테이션 사용 예시**

```java
@FunctionalInterface
public interface Add {
		public int add(int x, int y);
		// public int sub(int x, int y); 에러 발생
}
```

**호출 예시**

```java
public class TestMyNumber {

		public static void main(String[] args) {
				MyNumber add= (x,y) -> x + y;
				System.out.println(add.add(x,y)); 
		}
}
```

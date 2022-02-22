## 예외 처리 (Exception)

---

### 프로그램에서의 오류

---

#### 오류의 종류

- 컴파일 오류 (Compile error)
    - 프로그램 작성 중 발생하는 문법적 오류
- 실행 오류 (Runtime error)
    - 실행 중인 프로그램이 의도하지 않은 동작을 하거나, 프로그램이 중지되는 오류
    - 실행 중, 비정상 종료도 해당된다.

#### 예외처리의 중요성

- 프로그램의 비정상 종료를 핸들링하여 시스템을 통제할 수 있도록 함

#### 오류와 예외 클래스

- 시스템 오류
    - 가상 머신에서 발생, 프로그래머가 처리할 수 없는 오류
    - ex ) stack overflow, heap memory 관련 오류
- 예외(Exception)
    - 프로그램에서 제어할 수 있는 오류
    - ex) File not found, DB connection error
- 대부분 프로그램에서 발생하는 오류에 대해 사전에 문법적으로 예외처리를 하도록 하는것이 중요

### 예외 클래스

- 모든 예외 class의 최상위 클래스는 Exception Class이다.
- 자바에서는 다양한 예외들을 처리할 수 있도록 각각의 클래스를 제공하고 있다.
- 예시
    - IOException(입출력 관련), RuntimeException(실행 오류 예외 처리관련), NullPointerException 등

### 예외 핸들링

---

#### try-catch 문

- try 블럭에는 예외가 발생할 가능성이 있는 코드를 작성
- try 블럭안에서 예외가 발생할 경우, catch 블럭의 내용이 실행됨

**사용 예시**

```java
    try{
	/* 수행할 코드 작성 */
	}catch(예외 클래스 e){
	/* 예외 핸들링과 관련된 코드 작성 */
	}
```

#### try-catch-finally 문

- finally 블럭에서 파일을 닫거나 커넥션을 해제하는 등의 리소스 해제를 보통 수행
- finally 블럭은 항상 수행된다.

**사용 예시**

```java
    try{
	fp=new FileInputStream("test.text");
	}catch(FileNotFoundException e){
	System.out.println(e.toString());
	}finally{
	if(fp!=null){
	try{
	fp.close();
	}catch(IOException e){
	e.printStackTrace();
	}
	}
	/* 항상 수행되는 블럭 */
	}
```

#### try-with-resource 문

- 리소스를 사용하는 경우, close를 명시적으로 호출하지 않아도 자동으로 해제(정상인 경우, 예외 발생한 경우 모두)되도록 함
- 자바 7부터 제공
- 리소스를 try 내부에서 선언해야한다.
- 해당 리소스 클래스가 AutoCloseable 인터페이스를 구현해야한다.
- 자바 9부터 리소스는 try 외부에서 선언하고, 변수만을 try(obj)와 같이 사용할 수 있다.

**사용 예시**

```java
        try(FileInputStream fileInputStream2=new FileInputStream("test.txt")){
	System.out.println("Do something ... ");
	}catch(FileNotFoundException e){
	e.printStackTrace();
	}catch(IOException e){
	e.printStackTrace();
	}
```

**사용자 정의 클래스 (AutoCloseable 인터페이스를 구현한) 예시**

### 예외처리 미루기

---

- 예외처리 방법 중 하나
- thows를 이용하여 예외가 발생할 수 있는 부분을 호출하는 시점에서 예외 처리할 수 있도록 설정 가능

**사용 예시**

```java
    /* 이 메서드를 호출하는 시점에 Exception을 핸들링하는 예제 */
public Class loadClass(String fileName,String className)throws ClassNotFoundException,FileNotFoundException{
	FileInputStream fileInputStream=new FileInputStream(fileName);
	Class c=Class.forName(className);

	return c;
	}

public static void main(String[]args){
	ThrowsException test=new ThrowsException();

	try{
	test.loadClass("test.text","testClass");
	}catch(ClassNotFoundException e){
	System.out.println("Class Not found exception ... !");
	}catch(FileNotFoundException e){
	System.out.println("File Not found exception ... !");
	}... // 혹은 Multi exception 처리를 사용해도 된다.
	}
```

### 사용자 정의 예외 클래스 활용

---

#### 사용자 정의 예외 클래스 구현하기

- 자바에서 제공되는 예외 클래스외에 개발자가 직접 예외를 만들 수 있음
- 기존 예외 클래스중 가장 유사한 예외 클래스에서 상속 받아 사용자 정의 예외 클래스 생성
- 또는 최상위 클래스인 Exception 클래스를 상속해서 생성할 수 있음

**사용자 정의 예외 클래스 구현 예시**

```java

public class UserException extends Exception {

	public PasswordException(String message) {
		/* do somthing */
	}
}
```


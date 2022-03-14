## 자바 입출력. I/O Stream

---

### [입출력 스트림]

#### 정의

- 자바는 다양한 입출력 장치에 독립적으로 일관성있는 입출력을 보장하기 위해 스트림을 제공한다.
- 대상 : 파일 디스크, 키보드, 마우스, 네트워크, 메모리 등 모든 데이터가 입력/출력 되는 곳

#### 입출력 스트림의 구분

- 대상 기준 : 입력 / 출력 스트림
- 자료의 종류 : 바이트 / 문자 (인코딩 지정 가능)
- 기능 : 기반(대상에 대해서 직접 IO) / 보조 (실제로 직접 IO하진 않고, 다른 Stream을 wraping 해서 사용하는 느낌)

#### 입력 스트림 / 출력 스트림

- 입력 스트림 : 대상으로부터 자료를 읽어 들이는 스트림
- 출력 스트림 : 대상으로 자료를 출력하는 스트림

**스트림의 종류**

|종류|예시|
|---|---|
|입력 스트림|FileInputStream, FileReader, BufferInputStream, BufferedReader 등|
|출력 스트림|FileOutputStream, FileWriter, BufferedOutputStream, BufferedWriter 등|

#### 바이트 단위 스트림과 문자 단위 스트림

- 바이트 단위 : 동영상, 음악 파일, 실행 파일등의 자료를 IO할 때 사용
- 문자 단위 스트림 : 바이트 단위로 자료를 처리하면 문자는 깨질 수 있다. 따라서 인코딩에 맞게 2바이트 이상으로 처리하도록 구현된 스트림
- 종류
    - 바이트 스트림 : FileInputStream, FileOutputStream, BufferedInputStream, BufferedOutputStream 등
    - 문자 스트림 : FileReader, FileWriter, bufferedReader, BufferedWriter 등

#### 기반 스트림, 보조 스트림

- 기반 스트림 : 대상에 직접 자료에 대해 I/O하는 스트림
- 보조 스트림 : 직접 I/O하지 않고, 추가적인 기능을 더해주는 스트림
- 보조 스트림은 항상 기반 스트림이나 또 다른 보조 스트림을 생성자의 매개 변수로 포함한다.
- 종류
    - 기반 스트림 : FileInputStream, FileOutputStream, FilerReader, FileWriter 등
    - 보조 스트림 : InputStreamReader, OutputStreamWriter, BufferedInputStream, BufferedOutputStream 등

---

## 표준 입출력 스트림

---

### [System 클래스의 표준 입출력 멤버]


```java
public class System {
	public static PrintStream out;
	public static InputStream in;
	public static PrintStream err;
}
```

- System.out : 표준 출력 스트림 (C의 stdout 느낌)
- System.in  : 표준 입력 스트림 (C의 stdin 느낌)
- System.err : 표준 에러 출력 스트림 (C의 stderr 느낌)

---

## 문자 단위 입출력 스트림

---

### [Reader]

#### 정의

- 문자 단위 입력 스트림 최상위 추상 클래스
- 많은 추상 메서드가 선언되어 있고, 하위 스트림이 이를 구현
- 주요 하위 클래스

|클래스|설명|
|-----|-----|
|FileReader| 파일에서 문자 단위로 읽는 스트림 클래스|
|InputStreamReader| 바이트 단위로 읽은 자료를 문자로 변환해주는 보조 스트림 클래스|
|BufferedReader| 문자로 읽을 때 배열을 제공하여 한꺼번에 읽을 수 있는 기능을 제공하는 보조 스트림|

- 주요 메서드

|메서드|설명|
|-----|-----|
|int read()| 파일로부터 한 문자를 읽고 반환|
|int read(char[] buf)| 파일로부터 buf 배열에 읽어 넣어준다.|
|int read(char[] buf, int off, int len)|파일로부터 읽어와 배열의 off 위치로부터 len 개수만큼 문자를 읽는다.|
|void close()| 입력 스트림과 연결된 대상 리소스를 닫는다.|

*FileReader 사용 예시*
```java
public class FileReaderTest {
	
	public static void main(String[] args) {
		try(FileReader fr = new FileReader("reader.txt")) {
			int i;
			while ((i = fr.read()) != -1) {
				System.out.print((char)i);
            }
			
        } catch (IOException e) {
			e.printStackTrace();
        }
    }
}
```

### [Writer]

#### 정의

- 문자 단위 출력 스트림 최상위 추상 클래스
- Reader와 마찬가지로 많은 추상 메서드들이 선언되어 있고, 이를 하위 클래스에서 상속받아 구현
- 주요 하위 클래스

|클래스|설명|
|-----|-----|
|FileWriter| 파일에서 문자 단위로 출력하는 스트림 클래스|
|OutputStreamWriter| 바이트 단위로 자료를 문자로 변환해 출력하는 클래스|
|BufferedWriter| 문자로 쓸 때 배열을 제공하여 한꺼번에 출력할 수 있는 기능을 제공하는 보조 스트림|

- 주요 메서드

|메서드|설명|
|-----|-----|
|int write(int c)| 한 문자를 파일에 출력|
|int write(char[] buf)| 문자 배열 buf의 내용을 출력|
|int write(char[] buf, int off, int len)| buf + off 부터 len 만큼 출력|
|int write(String str)| 문자열 str 출력|
|int write(String str, int off, int len)| str의 off번째 문자부터 len만큼 출력|
|int flush() | 출력하기 전, 출력 버퍼의 내용을 모두 출력|
|void close()| 스트림과 연결된 리소스를 닫는다. 출력 버퍼 또한 플러시됨|

*FileWriter 예시*
- 파일에 문자 쓰기
```java
public class FileWriterTest {
	public static void main(String[] args) {
		
		try(FileWriter fw = new FileWriter("writer.txt")) {
			fw.write('A');
			char[] buf = {'B', 'C', 'D', 'E'};
			
			fw.write(buf);
			fw.write("안녕하세요.");
			fw.write(buf,1,2);
			fw.write("65");
        } catch(IOException e) {
			e.printStackTrace();
        }
		
		System.out.println("출력이 완료되었습니다.");
    }
}
```

---

## 보조 스트림 클래스

---

### [보조 스트림]

#### 정의

- 보조 기능을 제공하는 스트림
- FilterInputStream과 FilterOutputStream이 보조 스트림의 상위 클래스들
- 생성자의 매개변수로 또 다른 스트림을 가짐
    - 매개변수로 준 스트림의 기능을 호출하고, +@로 본인들의 보조적인 기능을 수행하는 느낌
- Decorator Pattern으로 구현된다.
    - 상속을 이용하여 구현할 수 있지만, 제약조건이 많고, 구조가 복잡해지기 때문에 데코레이터 패턴을 사용한다.
- 상위 클래스 생성자

|생성자|설명|
|-----|-----|
|protected FileterInputStream(InputStream in)| 생성자의 매개변수로 InputStream을 주어야 함 | 
|protected FilterOutputStream(OutputStream out)| 생성자의 매개변수로 OutputStream을 주어야 함|

#### 자주 사용하는 보조 스트림

- InputStreamReader와 outputStreamWriter
  - 바이트 단위로 읽거나 쓰는 자료를 문자로 변환해준다.
- BufferedInputStream과 BufferedOutputStream
  - 약 8k의 배열이 제공되어 입출력이 빠르게 수행될 수 있도록 도와준다.
- DataInputStream과 DataOutputStream
  - 자료가 메모리에 저장된 상태 그대로 읽거나 쓰는 스트림


---

## 직렬화

---

### [Serialization 이란?]

#### 정의

- 인스턴스의 상태를 그대로 파일로 저장하거나, 네트워크로 전송(Serialization)하는 것
- 자바에서는 보조 스트림을 활용하여 직렬화를 제공함

#### 종류

|생성자|설명|
|----|----|
|ObjectInputStream(InputStream in) | InputStream을 생성자의 매개변수로 받아 ObjectInputStream을 생성|
|ObjectOutputStream(OutputStream out) | OutputStream을 생성자의 매개변수로 받아 ObjectOutputStream을 생성|

### [Serializable 인터페이스]

- 직렬화는 객체의 내용이 외부로 유출되는 것이므로, 프로그래머가 해당 객체에 대한 직렬화 의도를 표시해야함
- 구현 코드가 없는 *marker interface* -> 찾아보기
  - 일반적인 인터페이스와 동일하지만, 아무 메소드도 선언하지 않은 인터페이스를 말한다.
  - 대부분의 경우네느 단순한 타입체크용도로 사용하는 느낌
- transient : 직렬화하지 않으려는 멤버 변수에 사용함 (Socket등 직렬화 할 수 없는 객체)
  - transient 사용 시, 해당 멤버의 기본값 (객체라면 null 등)이 세팅됨

### [Externalizable 인터페이스]

- writerExternal()과 readExternal()메서드를 구현해야함
- 프로그래머가 직접 객체를 읽고 쓰는 코드를 구현할 수 있음


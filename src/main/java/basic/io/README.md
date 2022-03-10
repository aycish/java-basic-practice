## 자바 입출력. I/O Stream

---

### 입출력 스트림

---

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

### System 클래스의 표준 입출력 멤버

---

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

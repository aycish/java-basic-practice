## Thread

---

### Thread란

---

#### [정의]

- 하나의 프로세스에서 실제로 작업을 수행하는 단위
- 한 프로세스내의 스레들끼리는 data, code, heap 영역은 공유하나, stack은 공유하지 않음

#### [자바에서의 스레드]
- 자바에서는 프로세스가 존재하지 않고, 스레드만 존재한다.
- 스레드 스케줄링은 JVM에 의해서 수행된다. 즉, 자바의 스레드는 JVM에 의해 스케줄링되는 실행 단위 코드 블록이다.
- 스레드의 개수, 스레드가 실행하는 코드의 메모리 위치, 스레드의 상태, 우선순위등을 JVM에서 관리한다.
- 사용자 (개발자)는 스레드 코드를 작성하고, 라이프 타임을 고려하여 실행을 요청하는일만 수행한다.
- Thread를 extends하여 구현하며 run method가 실행되는 구조

### Multi-threading

---

#### [정의]

- 여러 thread가 동시에 수행되는 프로그래밍
- 각 thread사이에서 공유하는 자원이 있을 수 있는데, 자바에서는 static instance들이 해당된다.

#### [주의점]

- 여러 thread가 자원을 공유하여 작업이 수행될 수 있으므로, race condition을 고려해야한다.
  - race가 발생하는 지점을 critical section이라고 한다.
  - 해당 지점을 동기화를 여러 방법을 통해 구현하여 방지할 수 있지만, 병목등을 고려해봐야함
  - deadlock등이 발생할 수 있으므로 이를 제어하는 방안을 고려해야함
  - java에서는 Thread 클래스에 priority 필드를 통해 우선순위를 결정할 수 있다.

  
### 우선순위

---

#### [Thread 우선 순위]

- Thread.MIN_PRIORITY(1) ~ Thread.MAX_PRIORITY(10) 존재
- Thread.NORMAL_PRIORITY : Default Priority, 5
- 우선 순위가 높은 Thread일 수록, 리소스를 배분 받을 확률이 높다.
    - 우선순위를 설정한대로 동작하려고 하나, 연산의 수가 그렇게 많지 않다면 원하는대로 동작하지 않을 수있다.
    - 따라서, 스레드 제어 메서드등을 통해 명시적으로 멈추거나 재개하는 등의 로직을 추가해야한다.
- Set,Get 메서드를 통해 우선순위 조회와 설정을 수행할 수 있다.

### Thread 제어 메서드

---

#### [join()]

- 동시에 두 개 이상의 Thread가 실행될 때, 다른 Thread의 결과를 기다려야하는 경우 join 메서드 사용
- join()함수를 호출하는 Thread는 not-runnable 상태가 된다.
- 다른 Thread의 수행이 끝나면 (join을 걸어뒀던) runnable로 돌아간다.

#### [interrupt()]

- 다른 Thread에 예외를 캐치할 수 있도록 익셉션을 던짐
- Thread가 join, sleep, wait등의 메서드를 통해 not-runnable에서 대기하고 있는 경우, 해당 익셉션을 캐치하여 다시 runnable로 돌아올 수 있다.

### Thread 종료하기

---

#### [사용처]

- 말 그대로, Thread를 종료하고자 할 때 사용함
- Stop 메서드가 있으나 deprecated됨

---

## Multi Thread 프로그래밍

---

### Critical section과 Semaphore

---

#### [정의]

- Critical section : 두 개 이상의 thread가 동시에 접근하는 경우, 동기화등의 문제가 발생할 수 있는 영역
- Semaphore : 특별한 형태의 시스템 객체로, lock의 key 역할
    - 한 시점에서 한 thread만이 지정한 Critical section에서 semaphore를 가질 수 있고, 동일한 영역에 접근한 다른 thread들은 semaphore를 얻기 까지 대기하고 있는다.
    - semaphore를 가지고 있는 thread가 해당 섹션에서의 동작을 수행한 후, release하여 놓게 되고, 다른 thread에서 이를 get하여 동일하게 작업을 수행한다.

#### [Synchronization]

- 두 개의 thread가 같은 객체에 접근할 경우, 동시에 접근함으로써 데이터의 부정합이 발생하여 오류 발생
- 동기화는 critical section에 접근한 경우, 공유 자원을 lock하여 다른 thread의 접근을 제어한다.
- 동기화를 잘못 구현하면 서로 lock을 기다리는 상황인 deadlock등이 발생할 수 있다.

#### [synchronized 키워드]

- Synchronized 블럭
    - 현재의 객체 또는 다른 객체를 lock으로 만든다.
    ```java
        synchronized(참조형 수식) {
            수행 문
        } 
    ```
- Synchronized 메서드
    - 객체의 메서드에 synchronized 키워드 사용
    - 현재 이 메서드가 속해있는 개체에 lock 권한을 준다.
    - Synchronized 메서드 안에서 다른 Synchronized 메서드를 호출할 경우, deadlock을 발생시킬 수 있으므로 유의한다.

### wait, notify 메서드를 활용한 동기화

#### [메서드별 동작]

- 리소스 사용을 위해, wait 메서드로 대기 가능
    - notify가 호출될 때 까지 대기한다.
- notify를 사용하면 wait하고 있는 Thread 중 무작위로 골라 재시작된다.
    - Priority나 대기 순서등은 고려되지 않아 starvation이 발생할 수 있다.
    - 자바에서는 notifyAll 메서드의 사용을 권장한다.

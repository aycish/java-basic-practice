## 스트림(Stream)

---

### 스트림이란?

---

#### 정의

- 배열 또는 컬렉션등을 활용하여 모은 데이터에 대한 연산을 수행할 수 있도록 해주는 기능

#### 특징

- 일관성 있는 연산으로 자료의 처리를 쉽고 간단하게 함 (데이터를 추상화를 했다고 표현)
    - 람다식을 통해 일관성 있게 처리 가능
- 한번 생성하고 사용한 스트림은 재사용 할 수 없음
    - 연산 수행 후에 사용되었던 스트림은 소모된다.
    - 즉, 다른 연산을 수행하기 위해서는 스트림을 다시 생성해야함
- 스트림 연산은 기존 자료를 변경하지 않음
- 스트림 연산은 중간 연산과 최종 연산으로 구분됨
    - 필터링, 정렬등은 중간 연산이라함
    - 데이터를 소모하면서 연산을 수행하는것을 최종 연산이라고 한다.
    - 최종 연산 호출 시점에 중간 연산들이 모두 수행되며, 연산 결과를 중간에 얻을 수 없다. (지연 연산)

### 스트림 생성하고 사용하기

--- 

**스트림 생성 및 사용 예시**

```java
int[] arr = {1, 2, 3, 4, 5};

Arrays.stream(arr).forEach(n-> System.out.println("num[Stream] = " + n));
```

#### 중간 연산과 최종 연산

- 중간 연산
    - filter(), map(), sorted() 등이 해당
    - 조건에 맞는 값을 추출 (필터링)하거나 요소를 변환 (map)할 때 사용

**중간 연산(필터링) 예시**

```java
Arrays.stream(arr).filter(n-> n >= 3).forEach(n->System.out.println(n));
```

**중간 연산(sorted) 예시**

```java
Arrays.stream(arr).sorted().forEach(n->System.out.println(n));
```

**중간 연산(map) 예시**

```java
customerList.stream().map(c->c.getName()).forEach(s->System.out.println(s));
```

- 최종 연산
    - forEach(), count(), sum() 등이 해당
    - 최종 연산 후에 스트림은 더이상 다른 연산을 적용할 수 없다.

### reduce() 연산

---

#### 정의

- 미리 제공되는, 정의된 연산이 아닌, 사용자가 직접 구현해서 적용할 수 있음

**형태**

```java
T reduce(T identify, BinaryOperator<T> accumulator)
```

#### 특징

- 최종 연산으로, 스트림의 요소를 소모하며 연산을 수행한다.
- 두 번째 요소(BinaryOperator)로 전달되는 람다식에 따라 다양한 기능을 수행할 수 있음
    - 람다식 / BinaryOperator를 구현한 클래스 사용 가능
    - 람다식이 긴 경우, 클래스를 활용하는데, apply (두 인자를 비교하는 메서드) 구현 필요

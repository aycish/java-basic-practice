## 로그 남기기

---

### logging

---

#### 정의

* 시스템 운영에 대한 기록
* 오류가 발생했을 때, 추적하는데 용이
* 적절하게 로깅하는 양을 조절해야한다.
    * 너무 많을 경우, 빈번한 file IO로 오버헤드 증가
    * 너무 적을 경우, 트래킹에 도움이 안됨
    * 회사 정책적으로 결정되어 있다.

#### java.util.logging

* 자바에서 기본적으로 제공되는 log package
* 파일이나 콘솔에 로그 내용을 출력할 수 있다.
* jre/lib/logging.properties 파일을 편집하여 로그의 출력 방식을 로그 레벨을 변경할 수 있다.
    * 익셉션 상황
        * severe
        * warning
    * 일반적인 상황
        * info
        * config
        * fine
        * finer
        * finest
* 오픈 소스로는 log4j를 많이 사용하고 있다.

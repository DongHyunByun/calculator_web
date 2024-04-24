# calculator_web


1. **기간 : 2024.04** 

2. **기술스택**
    1. 개발언어 : java
    2. IDE : Intellij
 
3. **내용**
    1. 웹서버 계산기 구현
    2. tomcat의 역할을 하는 웹서버를 직접 구현
    3. 3단계로 서비스 구현
        1. 사용자 요청을 메인 Thread가 처리하도록 (-> 중간에 에러가 나면 서비스 전체가 멈춤)
        2. 사용자 요청이 들어올 떄 마다 Thread를 새로 생성하여 사용자 요청 처리 (-> 사용자 요청때마다 Thread객체를 생성해야 하므로 서버부하가 큼)
        3. Thread Pool을 적용하여 처리 

4. **파일설명(src/main/java/org.example)**
    1. ../calculator/  : 계산기 로직
    2. ../ClientRequesthandler       : (get)요청이 들어왔을 떄 이를 처리하는 메인 로직
    3. ../CustomWebApplicationServer : 클라이언트 요청이 들어왔을 때 이를 처리하는 로직
    4. ../HttpRequest  : HTTP request를 처리하는 클래스
    5. ../HttpResponse : HTTP response를 처리하는 클래스
    6. ../Main         : main함수
    7. ../QueryString  : get요청의 하나의 key와 value를 처리하는 클래스
    8. ../QueryStrings :  get요청의 모든 key와 value를 처리하는 클래스
    9. ../RequestLine  :  request line method, urlpath, get요청 query를 처리하는 클래스
    10. test.http : 테스트를 위한 http파일

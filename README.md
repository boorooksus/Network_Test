<br>

# 네트워크 테스트 프로그램

### 프로젝트 개요

 트래픽 모니터링 애플리케이션(<https://github.com/boorooksus/Traffic_Monitor_App.git>)의 기능 검증에 도움을 주기 위한 안드로이드 테스트 앱과 테스트 서버 프로그램이다.  트래픽 모니터링 애플리케이션이 어플의 송신 트래픽 량을 정확히 감지하는지 검증하기 위해 테스트 앱과 테스트 서버를 통신시킨다.

<br>

### 프로그램 설명

![image](https://user-images.githubusercontent.com/55964775/129751051-444d6d6c-dcd7-4211-8a34-a772be289d47.png)

#### 1. NetworkTestClient

 테스트용 안드로이드 앱. 유저가 숫자를 입력하고 전송 버튼을 누르면, 입력 받은 숫자를 정수형 데이터 타입으로 소켓에 담아 TCP 통신으로 서버로 전송한다.



#### 2. NetworkTestServer

 테스트용 서버. 테스트용 앱으로 부터 받은 데이터를 받으면 콘솔에 출력한다.


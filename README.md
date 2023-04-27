# ZB11_Assignment1

## 1. 과제 설명

- 서울시에서 제공하는 공공 Wifi Open API를 통해 공공 와이파이 정보를 가져온 뒤, 입력받은 좌표와 비교하여 현재 자신의 좌표에서 가까운 상위 20개 데이터를 출력


- 이후 북마크 그룹을 만들어 각 Wifi 데이터를 북마크 그룹에 넣거나, 제거하고 각 북마크 그룹도 생성하거나 수정, 삭제가 가능하게 할 것


- 추가적으로 값 검증(잘못된 input)이나 중복 데이터(동일한 북마크 그룹에 동일한 Wifi 데이터가 들어가는 경우)를 잡아 처리하도록 구현



## 2. 프로젝트 수행 기간 동안 사용한 기술

- Maven으로 의존성 관리 및 빌드


- Java Seb Servlet + JSP(Java Server Page) - JDK 1.8(Java 8)


- MariaDB - (JDBC Connector는 3.1.3버전 사용)


- Gson 2.10.1 - (JSON 처리에 사용)


- okhttp3 4.9.0 - (공공 Wifi API 호출 및 값 수신에 사용)


- lombok 1.18.26 - (DTO, VO에 대한 Getter, Setter, Builder pattern 구현의 편의성에 사용)


- JSTL 1.2 - (거의 사용하지 않았습니다.)



## 3. DB Table 관계

- Wifi 데이터를 위한 하나의 테이블 존재(공공 API에서 가져온 데이터를 저장하는 용도의 테이블)


- 데이터 조회 내역 테이블(주변 Wifi를 탐색하기 위해 기능 수행 시 수행한 위치와 수행 시간 기록)


- 북마크 그룹 관련 테이블(그룹 이름, 그룹 ID, 그룹 순서, 만든 시간 등등)


- 북마크 관련 테이블(소속 북마크 그룹 ID, 북마크 추가 시간)


- 이때 북마크 그룹 테이블과 북마크 테이블은 1:N 관계로 되어 있으며 북마크 테이블에서 북마크 그룹 ID를 외래 키로 사용하고 있습니다.


## 4. 프로젝트 구조
```
src
│
│
├─main                                 
│  ├─java                              - 서블릿 관련 코드
│  │   └─com.example.zb11_assignment   - 각 기능별로 Controller, DAO, DTO, VO, Service가 구현되어있습니다.     
│  │       ├─bookmark                  - 북마크 관련
│  │       ├─history                   - 기록 조회 관련
│  │       ├─wifi                      - Wifi 데이터 관련
│  │       └─JDBCConnector.class       - JDBC 템플릿   
│  │
│  ├─resources                  
│  │
│  │              
│  └─webapp                            - JSP 페이지 및 View 관련 디렉토리
│     ├─static                         - JSP 페이지에 들어갈 정적 CSS, JS파일
│     │   ├─css
│     │   └─js
│     ├─templates                      - JSP 뷰 파일들 역시 각 기능별로 나누어져 있습니다.
│     │   ├─bookmark
│     │   ├─history
│     │   └─wifi
│     │
│     └─WEB-INF
│
└─test                     
   └─java
      └─com.example.zb11_assignment    - 각 기능별 DAO 테스트코드
            ├─ bookmark.dao
            ├─ history.dao
            └─ wifi.dao
```
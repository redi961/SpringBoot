# H2 관련 설정 방법
 + https://mvnrepository.com/ -> h2 엔진 (최상단) -> 2.1.214 -> maven 전체선택
 +스프링 부트 pom 항목 -> 디펜던시즈 안으로 기입 (버전은 스프링부트가 자동으로 인식하므로 지울것)
 ++ 이후 저장할시 스프링 부트 내에서 자동으로 빌드가 진행됨

# JPA 선행 작업
 + help -> ins new soft -> work with -> latest 선택후 web,xml 선택후 다운로드
 + mvnrepository를 통하여 h2 / junit / hibernate 의 final 버전을 pom -> dependency 를 통하여 추가
 ++ -> 이 과정에서 scope/test는 삭제 처리 할 것 

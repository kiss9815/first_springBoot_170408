#  intellj spring boot 첫 프로젝트

프로젝트 생성시 
web
fremarker
h2, jdbc
devtools
lombok
actuator

#  포트 및 기본 설정 파일 application.properties
spring.datasoure.diriver-class-name=org.mysql.Driver
spring.database.username=mysql 

management.security.enabled=false   -> false 로 하면 localhost:8000 에서 기본정보 세팅 확인가능

server.port=8000   ->  포트설정 가능

logging.level.org.springframework.jdbc=DEBUG

#디비 설정
http://localhost:8000/h2-console  에서 h2 디비 설정 가능
jdbc url : jdbc:h2:mem:testdb
Driver Class : org.h2.Driver
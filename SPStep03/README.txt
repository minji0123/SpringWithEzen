[SPStep03]

1. 스프링 테스트
2. JUnit
3. 서비스용: src/main/resources/context-product.xml
3. 테스트용: src/test/resources/context-product-test.xml
4. GenericXmlApplicationContext context = new GenericXmlApplicationContext("context-product.xml");

(Project)
1. Maven Project
2. New Maven project
	- Create a simple project: check
3. Configure project
	- Group Id: com.spstep03
	- Artifact Id: SPStep03


(구조)
- project name
	- src
		- main
			- java
			- resource
		- test
			- java
			- resource
	- target
	- pom.xml

(springframework)
version: 5.0.2
<properties>
	<spring.mavan.artifact.version>5.0.2.RELEASE</spring.mavan.artifact.version>
</properties>


https://mvnrepository.com/artifact/org.springframework/spring-test/5.0.2.RELEASE
<!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>5.0.2.RELEASE</version>
    <scope>test</scope>
</dependency>

	
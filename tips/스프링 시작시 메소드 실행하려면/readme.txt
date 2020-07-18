1. 클래스 작성


- org.springframework.context.ApplicationListener 를 implements 한 클래스 작성
- onApplicationEvent() 메서드를 구현하여 그 안에 필요한 기능을 삽입한다.



* 클래스 샘플코드 (Test.java)


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class Test implements ApplicationListener{

//변수와 setter를 선언하여 bean xml 로부터 값을 넘겨받을 수 있다.
String var1;

public void setVar1(String var1) {
this.var1 = var1;
}

//스프링 시스템 기동시 수행
public void onApplicationEvent(ApplicationEvent applicationevent) {
System.out.println("### Test.onApplicationEvent() > var1 : "+ var1 +"###");
}
}





2. bean 등록

- <bean/> 태그들이 있는 spring application context 계열의 xml 파일에 <bean/> 요소로 등록


* xml 샘플코드


<bean id="test" class="Test">
<property name="var1" value="변수삽입테스트"/>
</bean>







※ application 기동시가 아닌 각 bean의 생성시 코드가 수행되도록 하는 방법은 여러가지가 있으나
(아래 링크 참조) 그렇게 할 경우, 그 코드가 아직 생성되지 않은 다른 bean을 호출할 때
null pointer exception등의 문제가 발생할 소지가 있다. 그런 면에서 ApplicationListener 를
구현하여 사용하는 편이 안전하다고 볼 수 있다.



출처:http://blog.daum.net/turnnig-pointer/16498283
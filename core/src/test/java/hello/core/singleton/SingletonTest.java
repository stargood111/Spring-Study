package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;

public class SingletonTest {

	@Test
	@DisplayName("스프링 없는 순수한 DI컨테이너")
	void pureContainer() {
		AppConfig appConfig = new AppConfig();
		//객체생성1
		MemberService memberService1 = appConfig.memberService();
		//객채생성2
		MemberService memberService2 = appConfig.memberService();
		
		System.out.println(memberService1);
		System.out.println(memberService2);
		
		//meberService1 != memberService2 객체가 다름
		Assertions.assertThat(memberService1).isNotSameAs(memberService2);
	}
	
	@Test
	@DisplayName("싱글톤 패턴을 사용한 객체 사용")
	void singletonServiceTest() {
		SingletonService singletonService1 = SingletonService.getInstacne();
		SingletonService singletonService2 = SingletonService.getInstacne();
		System.out.println(singletonService1);
		System.out.println(singletonService2);
		Assertions.assertThat(singletonService1).isSameAs(singletonService2);
	}
	
	@Test
	@DisplayName("스프링 컨테이너와 싱글톤")
	void springContainer(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		//객체생성1
		MemberService memberService1 = ac.getBean("memberService", MemberService.class);
		//객채생성2
		MemberService memberService2 = ac.getBean("memberService", MemberService.class);
		
		System.out.println(memberService1);
		System.out.println(memberService2);
		
		//meberService1 != memberService2 객체가 다름
		Assertions.assertThat(memberService1).isSameAs(memberService2);
	}
	
}

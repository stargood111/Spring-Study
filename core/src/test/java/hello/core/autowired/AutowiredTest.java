package hello.core.autowired;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Member;
import io.micrometer.common.lang.Nullable;

public class AutowiredTest {

	
	@Test
	void AutowiredOption() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
	}
	
	static class TestBean {
		@Autowired(required = false)
		public void setNoBaean1(Member memberNoBean1) {
			System.out.println("reqeuired = " + memberNoBean1);	
			}
	
		@Autowired
		public void setNoBaean2(@Nullable Member memberNoBean2) {
			System.out.println("@Nullable = " + memberNoBean2);	
		}	
		
		@Autowired
		public void setNoBaean2(Optional<Member> memberNoBean3) {
			System.out.println("Optional<Member> = " + memberNoBean3);	
		}	  
	}
}

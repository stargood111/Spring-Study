package hello.core.scan;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AutoAppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AutoAppConfigTest {

	@Test
	void basicScan() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		
		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
		
		OrderServiceImpl orderServiceImpl = ac.getBean(OrderServiceImpl.class);
		MemberRepository memberRepository = orderServiceImpl.getMemberRepository();
		
		System.out.println(memberRepository);
	}
}

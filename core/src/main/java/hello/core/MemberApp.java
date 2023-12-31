package hello.core;

import org.springframework.boot.autoconfigure.jms.artemis.ArtemisNoOpBindingRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

	public static void main(String[] args) {
		
		
//		
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
//		MemberService memberService = new MemberServiceImpl();
	
		/*ApplicationContext 스프링 컨테이너*/
		ApplicationContext act = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = act.getBean("memberService",MemberService.class);
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		 
		Member findMember = memberService.findMember(1L);
		
		System.out.println("new member = " + member.getName());
		System.out.println("findMember = " + findMember.getName());
	}

}
  
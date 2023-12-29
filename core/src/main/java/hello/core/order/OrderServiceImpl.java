package hello.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.discount.DiscountPolicy;
//import hello.core.discount.FixDiscountPolicy;
//import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService{


	private MemberRepository memberRepository;
	private DiscountPolicy discountPolicy;
//	@Autowired
//	private  MemberRepository memberRepository; //핃드주입 (권장사용 X, 순수 java에서 TEST 어려움), 스프링 설정을 목적으로 하는 @Configuration 같은 곳에서만 특별한 용도로 사용
//	@Autowired
//	private  DiscountPolicy discountPolicy; //핃드주입 (권장사용 X, 순수 java에서 TEST 어려움) 스프링 설정을 목적으로 하는 @Configuration 같은 곳에서만 특별한 용도로 사용

	
//	@Autowired //Setter주입 (선택,수정)
//	public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//		System.out.println(discountPolicy);
//		this.discountPolicy = discountPolicy;
//	}
//	
//	@Autowired //Setter주입 (선택,수정)
//	public void setMemberRepository(MemberRepository memberRepository) {
//		System.out.println(memberRepository);
//		this.memberRepository = memberRepository;
//	}
//	
	@Autowired //생성자주입 (불변,필수)
	public OrderServiceImpl() {
		System.out.println(memberRepository);
		System.out.println(discountPolicy);
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}
	@Autowired //일반메서드주입
	public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		return  new Order(memberId, itemName, itemPrice, discountPrice);
	}
	//싱글톤 테스트
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
  

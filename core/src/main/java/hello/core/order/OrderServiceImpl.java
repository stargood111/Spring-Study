package hello.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.discount.DiscountPolicy;
//import hello.core.discount.FixDiscountPolicy;
//import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

@Component()
public class OrderServiceImpl implements OrderService{

	private MemberRepository memberRepository = new MemoryMemberRepository();
	private DiscountPolicy discountPolicy;  //DIP 원칙 지킴 (Null point error)

	
	@Autowired
	public void setMemberRepositry(MemberRepository memberRepository) {
		System.out.println(memberRepository);
		this.memberRepository =memberRepository;
	}
	
	/*	private final DiscountPolicy discountPolicy = new RateDiscountPolicy (); //인터페이스 - 추상, RateDiscountPolicy - 구현체 모두 의존
		private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //인터페이스 - 추상, FixeDiscountPolicy구현체 모두 의존
		DIP , OCP 위반 */
	
	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
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
  

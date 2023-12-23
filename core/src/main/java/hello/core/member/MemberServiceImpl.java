package hello.core.member;

import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class MemberServiceImpl implements MemberService{

	private final MemberRepository memberRepository;
	
	
	
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long MemberId) {
		// TODO Auto-generated method stub
		return memberRepository.findById(MemberId);
	}
	//싱글톤 테스트
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}

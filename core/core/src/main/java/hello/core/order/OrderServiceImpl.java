package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor        // final이 붙은 객체 생성자 코드 자동으로 만들어줌
public class OrderServiceImpl implements OrderService{
    // 추상에만 의존해야 하는데 추상에도 의존하고 구현에도 의존하는 현상.
    // final은 무조건 값이 할당되야 함.
    private final MemberRepository memberRepository;          // final.. 딱 한번 생성할 때 정해지면 안바뀐다는 것.
    private final DiscountPolicy discountPolicy;              // final.. 생성자에서만 값을 세팅할 수 있다는 것. 맨 처음에 초기화를 하든지.

    @Autowired                                               // 생성자가 1개이면 생략 가능.
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {         //구현체로 바로 들어가기 ctrl + alt + B
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

/*    @Autowired(required = false)
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Autowired(required = false)
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }*/

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);     // 멤버를 넘길까? | grade를 넘길까?

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
// 스프링없이 순수 자바코드로만 내가 필요한 것들을 테스트해서 조립.
    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();     //생성자로 해야 detect 빨리 할 수 있다는 예제
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());     // 세상에서 제일 좋은 오류 : 컴파일 오류
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy         // qualifier는 문자열 잘 못 쓸 경우 컴파일 오류를 찾기힘들어서 이렇게 쓰자.
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {         // 테스트 시 ctrl + shift + T
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;           // 이 로직이 불안하다.. 돈 관련...
        } else {
            return 0;
        }
    }
}

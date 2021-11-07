package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //인터페이스에만 의존하도록 변경

    public OrderServiceImpl(MemberRepository memberRepository,DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy=discountPolicy;
    }
    //이전까지는 DiscountPolicy 뿐만 아니라 FixDiscountPolicy 구체 클래스도 함께 의존하고 있었다.
    //때문에 FixDiscountPolicy를 RateDiscountPolicy로 변경하는 순간 OrderServiceImpl의 소스코드도
    //함께 변경해야 한다(OCP 위반)

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //단일 책임 원칙이 잘 설계됐기에 이렇게 넘기는게 가능하다.
        Member member=memberRepository.findById(memberId);
        int discountPrice=discountPolicy.discount(member, itemPrice);//최종 할인 가격 받기

        return new Order(memberId, itemName,itemPrice,discountPrice);//최종 주문 내역 반환
    }
}

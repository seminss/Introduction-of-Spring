package hello.core.order;

public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    //생성자
    public Order(Long memberId, String itemName, int itemPrice, int discountPrice){
        this.memberId=memberId;
        this.itemName=itemName;
        this.itemPrice=itemPrice;
        this.discountPrice=discountPrice;
    }

    //계산된 결과
    public int calculatePrice(){
        return itemPrice-discountPrice;
    }

    //geter, seter
    public Long getNameId(){
        return memberId;
    }

    public String getItemName(){
        return itemName;
    }

    public int getItemPrice(){
        return itemPrice;
    }

    public int getDiscountPrice(){
        return discountPrice;
    }

    @Override
    public String toString(){
        return "Order{"+"memberId="+memberId+
                ", itemName='"+itemName+'\''+
                ", itemPrice="+itemPrice+
                ", discountPrice="+discountPrice+
                '}';
    }
}

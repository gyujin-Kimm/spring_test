package hello.core.singleton;


// ctrl + shift + T == 테스트
public class StatefulService {

//    private int price;  //상태를 유지하는 필드

    public int order(String name, int price){          // 10000원 -> 20000원
        System.out.println("name = " + name + " price = " + price);
//        this.price = price;     // 여기가 문제!
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}

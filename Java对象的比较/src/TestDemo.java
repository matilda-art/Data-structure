/**
 * @program: Java对象的比较
 * @description
 * @author: matilda
 * @create: 2020-05-26 23:03
 **/

class Card {
    public int rank; // 数值
    public String suit; // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }


    //equals：两个对象是否是相同的对象。
    /*1、如果指向同一个对象，返回true
    * 2、如果传入的为null，返回false
    * 3、如果传入的对象类型不是Card，返回false
    * 4、按照类的实现目标完成比较，例如这里只要花色和数值一样，就认为是相同的牌
    * 5、注意下调用其引用类型的比较也需要equals，例如这里的suit的比较*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || !(obj instanceof Card)){
            return false;
        }
        Card tmp = (Card) obj;
        if (this.rank == tmp.rank && this.suit.equals(tmp.suit)){
            return true;
        }
        return false;
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Card card1 = new Card(5,"❤");
        Card card2 = new Card(5,"❤");
        System.out.println(card1.equals(card2));
    }
}

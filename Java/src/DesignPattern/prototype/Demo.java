package prototype;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookShop bookShop=new BookShop();
        bookShop.setShopName("novelty");
        bookShop.loadData();



        BookShop bookShop1=bookShop.clone();
        bookShop.getBooks().remove(2);

        bookShop1.setShopName("A1");
        System.out.println(bookShop);

        System.out.println(bookShop1);
    }
}

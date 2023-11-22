import java.util.ArrayList;
import java.util.List;

public class EntityGenerator {

    private static final int HumansCount = 6;
    private static final int AccountCount = 6;
    private static final int CardsCount = 6;

    private static final List<Goods> goods = new ArrayList<>();

    public static void generate() {
        for (int i = 0; i < HumansCount; i++) {
            System.out.println(new Human("Денис" + i, 5 + i));
        }

        for (int i = 0; i < AccountCount; i++) {
            System.out.println(new Account("account" + i, "password" + i));
        }

        for (int i = 0; i < CardsCount; i++) {
            System.out.println(new BankCard());
        }

        showGoods();
    }

    public static void showGoods() {
        makeGoods();
        for (Goods currentGoods : goods) {
            System.out.println(currentGoods.toString());
        }
    }

    private static void makeGoods() {
        goods.add(new Goods("Ноутбук", 10999, 1));
        goods.add(new Goods("Телевізор", 3999, 2));
        goods.add(new Goods("Фотокамера", 2500, 3));
        goods.add(new Goods("Електросамокат", 8599, 4));
        goods.add(new Goods("ПК", 20999, 5));
        goods.add(new Goods("Смартфон", 6999, 6));
        goods.add(new Goods("Квадрокоптер", 4000, 7));
        goods.add(new Goods("Проектор", 3000, 8));
        goods.add(new Goods("3D-принтер", 7899, 9));
        goods.add(new Goods("Годинник", 1300, 10));
    }

    public static List<Goods> getGoods() {
        return goods;
    }
}

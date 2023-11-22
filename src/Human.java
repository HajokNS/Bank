import java.util.ArrayList;
import java.util.List;

public class Human {

    private final String name;
    private final int age;
    private final List<BankCard> cards = new ArrayList<>();
    private Account account;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void createAccount(String userName, String password) {
        this.account = new Account(userName, password);
    }

    public void deleteAccount() {
        this.account = null;
    }

    public void addBankCard(BankCard bankCard) {
        cards.add(bankCard);
    }

    public void addBankCard(Account account) {
        cards.add(new BankCard(account));
    }

    public void showBankCards() {
        for (BankCard bankCard : this.cards) {
            System.out.println(bankCard.toString());
        }
    }

    public List<BankCard> getBankCards() {
        return cards;
    }

    public Account getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        if (this.account != null) {
            return "Ім'я: " + name + " Вік: " + age + "\n"
                + "Прив'язаний обліковий запис до людини: " + account.toString();
        } else {
            return "Ім'я: " + name + " Вік: " + age + "\n"
                + "До цієї людини не прив'язаний жодний обліковий запис";
        }
    }
}

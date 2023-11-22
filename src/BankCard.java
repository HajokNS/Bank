public class BankCard {

    private Account account;

    public BankCard(Account account) {
        this.account = account;
    }

    public BankCard() {
    }

    public void replenishBalance(double quantity) {
        if (this.account == null) {
            System.out.println("Немає облікового запису...");
        } else {
            this.account.plusToAccountBalance(quantity);
            System.out.println("До балансу було додано " + quantity + " гривень");
            System.out.println("Сума грошей на вашому балансі становить: " + account.getAccountBalance());
        }
    }

    public void deductFromBalance(double quantity, Goods goods) {
        if (this.account == null) {
            System.out.println("До карточки не привязаний жодний обліковий запис. Неможливо зняти кошти!");
        } else {
            if (this.account.getAccountBalance() > quantity) {
                this.account.subtractFromAccountBalance(quantity);
                System.out.println("Ви придбали " + goods.getProductName());
                System.out.println("Було знято з балансу " + quantity + " гривень");
                System.out.println("Поточна сума грошей на вашому балансі: " + account.getAccountBalance());
            } else {
                System.out.println("Невистачає коштів на балансі");
            }
        }
    }

    @Override
    public String toString() {
        if (account == null) {
            return "До цієї карточки не привязаний жодний обліковий запис";
        } else {
            return "До цієї карточки привязаний обліковий запис: " + account.toString();
            }
    }
}

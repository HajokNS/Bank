import java.util.Scanner;

public final class BankTransactions {

    static public void launchProgram(Human human) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Створіть обліковий запис:");
        boolean isAlreadyRegistered = false;
        while (!isAlreadyRegistered) {
            System.out.println("Введіть Ім'я: ");
            String userName = scanner.next();
            System.out.println("Введіть пароль: ");
            String password = scanner.next();
            if (launchRegistration(userName, password)) {
                human.createAccount(userName, password);
                isAlreadyRegistered = true;
            } else {
                System.out.println("Повторіть спробу!");
            }
        }
        while (true) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("1. Створення банківської картки");
            System.out.println("2. Перевірити баланс облікового запису");
            System.out.println("3. Поповнити баланс облікового запису");
            System.out.println("4. Придбати товар");
            System.out.println("5. Інформація про власника облікового запису та картки");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Напишіть відповідну цифру, щоб обрати пункт меню:");
            int selectMenuItem = scanner.nextInt();
            switch (selectMenuItem) {
                case 1:
                        human.addBankCard(new BankCard(human.getAccount()));
                        System.out.println("Банківська картка успішно створена та додана до вашого облікового запису");
                    break;
                case 2:
                    System.out.println(human.getAccount().getAccountBalance());
                    break;
                case 3:
                    System.out.println("На скільки ви хочете поповнити баланс:");
                    double quantity = scanner.nextDouble();
                    if (!human.getBankCards().isEmpty()) {
                        human.getBankCards().get(0).replenishBalance(quantity);
                    } else {
                        System.out.println("Нема банківської картки");
                    }
                    break;
                case 4:
                    EntityGenerator.showGoods();
                    System.out.println("Введіть цифру, щоб придбати товар:");
                    byte number = scanner.nextByte();
                    buyGoods(number, human);
                    break;
                case 5:
                    System.out.println(human.toString() + "\n" + human.getBankCards().get(0).toString());
                    break;
                default:
                    System.out.println("Обрано невірний пункт меню");
                    break;
            }
        }
    }

    private static boolean launchRegistration(String userName, String password) {
        if (userName.length() <= 12 && !userName.isEmpty()) {
            if (password.length() <= 16 && password.length() >= 8) {
                System.out.println("Обліковий запис створено!");
                return true;
            } else {
                System.out.println(
                    "Пароль має бути більшим за 8 символів та меншим за 16 символів");
                return false;
            }
        } else {
            System.out.println("Ім'я має бути більшим за 1 символ та меншим за 12 символів");
            return false;
        }
    }


    private static void buyGoods(int number, Human human) {
        for (Goods goods : EntityGenerator.getGoods()) {
            if (number == goods.getIndexInTheList()) {
                if (!human.getBankCards().isEmpty()) {
                    human.getBankCards().get(0)
                        .deductFromBalance(goods.getPrice(), goods);
                    return;
                } else {
                    System.out.println("Немає банківської картки");
                }
            }
        }
        System.out.println("Невірний пункт меню");
    }
}

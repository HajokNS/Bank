import java.util.Random;

public class Account {

        private final int id = new Random().nextInt(999);
        private double accountBalance;
        private String userName;
        private String password;

        public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
        }


        public double getAccountBalance() {
            return accountBalance;
        }

        public void plusToAccountBalance(double balance) {
            this.accountBalance += balance;
        }

        public void subtractFromAccountBalance(double balance) {
            this.accountBalance -= balance;
        }

        @Override
        public String toString() {
            return "Ім'я облікового запису: " + userName + "; Пароль: " + password + "; ID: " + id;
        }
}

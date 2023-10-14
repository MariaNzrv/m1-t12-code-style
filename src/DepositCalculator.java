import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double rate, int term) {
        double totalAmount = amount * Math.pow((1 + rate / 12), 12 * term);
        return roundPercent(totalAmount,2);
    }

    double calculateSimplePercent(double amount,double rate, int term) {
        return roundPercent(amount + amount * rate * term,2);
    }

    double roundPercent(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDepositFuture( ) {
        int depositTerm;
        int typeOfDeposit ;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");

        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        depositTerm = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        typeOfDeposit = scanner.nextInt();

        double totalAmount = 0;

        if (typeOfDeposit == 1) {
            totalAmount = calculateSimplePercent(amount,0.06, depositTerm);
        } else if (typeOfDeposit == 2) {
            totalAmount = calculateComplexPercent(amount,0.06, depositTerm);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositTerm + " лет превратятся в " + totalAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositFuture();
    }
}

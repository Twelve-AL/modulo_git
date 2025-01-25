import java.util.ArrayList;
import java.util.Scanner;

class Dish {
    private String name;
    private double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - R$ " + price;
    }
}

class Order {
    private ArrayList<Dish> dishes = new ArrayList<>();

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public double calculateTotal() {
        double total = 0;
        for (Dish dish : dishes) {
            total += dish.getPrice();
        }
        return total;
    }

    public void showOrder() {
        System.out.println("\nSeu pedido:");
        for (Dish dish : dishes) {
            System.out.println("- " + dish);
        }
        System.out.printf("Total: R$ %.2f\n", calculateTotal());
    }
}

public class RestaurantApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Dish> menu = new ArrayList<>();
        menu.add(new Dish("Pizza Margherita", 25.00));
        menu.add(new Dish("Hambúrguer Artesanal", 20.00));
        menu.add(new Dish("Salada Caesar", 18.50));
        menu.add(new Dish("Suco Natural", 8.00));
        menu.add(new Dish("Brownie com Sorvete", 12.00));

        System.out.println("Bem-vindo ao Restaurante!");
        System.out.println("Nosso cardápio:");

        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }

        Order order = new Order();

        while (true) {
            System.out.print("\nDigite o número do prato para adicionar ao pedido (ou 0 para finalizar): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= menu.size()) {
                Dish selectedDish = menu.get(choice - 1);
                order.addDish(selectedDish);
                System.out.println(selectedDish.getName() + " foi adicionado ao pedido.");
            } else {
                System.out.println("Escolha inválida. Tente novamente.");
            }
        }

        order.showOrder();
        System.out.println("\nObrigado por visitar nosso restaurante! Volte sempre.");

        scanner.close();
    }
}

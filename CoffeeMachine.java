import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int disposableCups = 9;
    static int money = 550;
    static boolean exit = false;

    public static void main(String[] args) {

        while(exit == false){
            action();
        }
    }
    static void remaining(){
        System.out.println("The coffee machine has:\n" +water+
                " ml of water\n" +milk+
                " ml of milk\n" +coffeeBeans+
                " g of coffee beans\n" +disposableCups+
                " disposable cups\n$" +money+
                " of money");
    }
    static void action(){
        System.out.println("Write action (buy, fill, take, remaining, exit) : ");
        String action = scanner.nextLine();
        if(actionValidation(action)){
            if(action.equals("buy")){
                buy();

            } else if (action.equals("fill")) {
                fill();

            } else if (action.equals("take")) {
                System.out.println("I gave you $"+money);
                money = 0;
            } else if (action.equals("remaining")) {
                remaining();
            } else if (action.equals("exit")) {
                exit = true;
            }
        }
        else {
            System.out.println("Wrong input");
        }
    }
    static boolean actionValidation(String action){
        if(action.equals("buy") || action.equals("fill") || action.equals("take") || action.equals("remaining") || action.equals("exit")){
            return true;
        }
        else {
            return false;
        }
    }

    static void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String order = scanner.nextLine();
        if(order.equals("back")){
            action();
        }
        else{
            switch (order){
                case "1" :
                    if(ingredientChecker(250,0,16,1) == true){
                        ingredientsCalc(250,0,16,1,4);
                    }
                    break;
                case "2" :
                    if(ingredientChecker(350,75,20,1) == true){
                        ingredientsCalc(350,75,20,1,7);
                    }
                    break;
                case "3" :
                    if(ingredientChecker(200,100,12,1) == true){
                        ingredientsCalc(200,100,12,1,6);
                    }
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }


    }
    static void ingredientsCalc(int newWater, int newMilk, int newBeans, int newCups, int newMoney){
        water -= newWater;
        milk -= newMilk;
        coffeeBeans -= newBeans;
        disposableCups -= newCups;
        money += newMoney;
    }

    static void ingredientsFill(int newWater, int newMilk, int newBeans, int newCups){
        water += newWater;
        milk += newMilk;
        coffeeBeans += newBeans;
        disposableCups += newCups;
    }

    static void fill(){
        System.out.println("Write how many ml of water you want to add : ");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add : ");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add : ");
        int coffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add : ");
        int numberOfCups = scanner.nextInt();

        ingredientsFill(water,milk,coffeeBeans,numberOfCups);
    }

    static boolean ingredientChecker(int waterCheck, int milkCheck, int beansCheck, int cupsCheck){
        if(water - waterCheck > 0 && milk - milkCheck > 0 && coffeeBeans - beansCheck > 0 && disposableCups - cupsCheck >0){
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        } else if (water - waterCheck <= 0) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk - milkCheck <= 0) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (coffeeBeans - beansCheck <= 0) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (disposableCups - cupsCheck <= 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        return false;
    }
}


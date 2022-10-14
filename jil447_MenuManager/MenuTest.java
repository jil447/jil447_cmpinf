package jil447_MenuManager;
/**
 * Class MenuTest
 * author:Jin Li
 * created:10/09/2022
 */
public class MenuTest {
    public static void main(String[] args) {

            Entree entree1 = new Entree("Sirloin Steak","A delicious piece of 1/2 a pound of our " +
                    "carefully selected meat grilled and seasoned. Choose how much you want it cooked.",30);
            Entree entree2 = new Entree("Sirloin Steak","A delicious piece of 1/2 a pound of our " +
                    "carefully selected meat grilled and seasoned. Choose how much you want it cooked.",30);
            Side side = new Side("Rice and Avocado","Premium quality indian rice mixed with avocado.",20);
            Salad salad1 = new Salad("salad1","N/A",10);
            Salad salad2 = new Salad("salad2","N/A",10);
            Dessert dessert = new Dessert("dessert","N/A",20);

            Menu menu1= new Menu("Menu1(\"Sirloin Steak\"+\"Rice and Avocado\")",entree1,side,null,null);
            System.out.println(menu1.desc());
            System.out.println("TotalCalories is "+menu1.totalCalories());
            System.out.println("-------------------");
            Menu menu2 = new Menu("Menu2(\"Sirloin Steak\"+\"Rice and Avocado\"+\"Salad2\"+\"dessert\")",entree2,side,salad2,dessert);
            System.out.println(menu2.desc());
            System.out.println("TotalCalories is "+menu2.totalCalories());
        }
    }

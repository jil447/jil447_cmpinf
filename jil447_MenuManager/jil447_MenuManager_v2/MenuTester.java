package jil447_MenuManager_v2;
/**
 * Class MenuTester
 * @author:Jin Li
 * @created:11/03/2022
 */
public class MenuTester {
        public static void main ( String [ ] args ) {
            MenuRandomize randomize = new MenuRandomize("data/entrees.txt","data/sides.txt","data/salads.txt","data/desserts.txt");
            Menu myMenu = randomize.randomMenu();
            System.out.println(myMenu.description() + "\ntotal calories "+ myMenu.totalCalories());

        }
}
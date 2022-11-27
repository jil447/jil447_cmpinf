package jil447_MenuManager_v3;
/**
 * Class MenuTest
 * @author:Jin Li
 * @created:11/20/2022
 */
import java.util.ArrayList;

public class MenuTest {
        public static void main ( String [ ] args ) {
        	
        	Menumanager m = new Menumanager("data/dishes");
        	Menu myMenu = m.minCaloriesMenu("Min CaloriesMenu");
        	System.out.println(myMenu.desc() + " \nTotal calories is "+ myMenu.totalCalories()+"\nTotal prices is "+ myMenu.totalPrice());
        	Menu myMenu2 = m.maxCaloriesMenu("Max CaloriesMenu");
        	System.out.println(myMenu2.desc() + " \nTotal calories is "+ myMenu2.totalCalories()+"\nTotal prices is "+ myMenu2.totalPrice());
        	ArrayList<Menu> list = new ArrayList();
        	list.add(myMenu);
        	list.add(myMenu2);
        	FileManager.writeItems("data/aaa", list);
        }
    }



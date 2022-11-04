package jil447_MenuManager_v2;
/**
 * Class MenuRandomize
 * @author:Jin Li
 * @created:11/03/2022
 */
import java.util.ArrayList;

public class MenuRandomize {
    private ArrayList<Entree> entrees;
    private ArrayList<Side> sides;
    private ArrayList<Salad> salads;
    private ArrayList<Dessert> desserts;

    public MenuRandomize(String entreeFile, String sideFile, String saladFile,
                         String dessertFile) {
        entrees = FileManager.readEntrees(entreeFile);
        sides = FileManager.readSides(sideFile);
        salads = FileManager.readSalads(saladFile);
        desserts = FileManager.readDesserts(dessertFile);
    }
    /**
     * Method calculate
     * @param entrees.size()
     * @param Math.random()
     * @return the multiplication
     *
     * Method calculate
     * @param sides.size()
     * @param Math.random()
     * @return the multiplication
     *
     * Method calculate
     * @param salads.size()
     * @param Math.random()
     * @return the multiplication
     *
     * Method calculate
     * @param desserts.size()
     * @param Math.random()
     * @return the multiplication
     */
    public Menu randomMenu() {
        return new Menu("Random Menu",
		                entrees.get((int)(Math.random()*(entrees.size()))),
		                sides.get((int)(Math.random()*(sides.size()))),
		                salads.get((int)(Math.random()*(salads.size()))),
		                desserts.get((int)(Math.random()*(desserts.size()))));
    }
}

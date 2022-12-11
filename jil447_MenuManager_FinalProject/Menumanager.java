package jil447_MenuManager_FinalProject;
/**
 * Class Menumanager
 * @author:Jin Li
 * @created:11/20/2022
 */
import java.util.ArrayList;
import java.util.Comparator;

public class Menumanager {
	private ArrayList<Entree> entrees;
	private ArrayList<Side> sides;
	private ArrayList<Salad> salads;
	private ArrayList<Dessert> desserts;

	public Menumanager(String fileName) {
		entrees = new ArrayList<Entree>();
		sides = new ArrayList<Side>();
		salads = new ArrayList<Salad>();
		desserts = new ArrayList<Dessert>();

		ArrayList<MenuItem> list = FileManager.readItems(fileName);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Entree) {
				entrees.add((Entree) list.get(i));
			} else if (list.get(i) instanceof Side) {
				sides.add((Side) list.get(i));
			} else if (list.get(i) instanceof Salad) {
				salads.add((Salad) list.get(i));
			} else if (list.get(i) instanceof Dessert) {
				desserts.add((Dessert) list.get(i));
			}
		}
	}

	public Menu randomMenu() {
		return new Menu("Today Menu", entrees.get((int) (Math.random() * (entrees.size()))),
				sides.get((int) (Math.random() * (sides.size()))), salads.get((int) (Math.random() * (salads.size()))),
				desserts.get((int) (Math.random() * (desserts.size()))));
	}
	public Menu randomMenu(String name) {
		return new Menu(name, entrees.get((int) (Math.random() * (entrees.size()))),
				sides.get((int) (Math.random() * (sides.size()))), salads.get((int) (Math.random() * (salads.size()))),
				desserts.get((int) (Math.random() * (desserts.size()))));
	}

	public Menu minCaloriesMenu(String name) {
		entrees.sort(new Comparator<Entree>() {
			@Override
			public int compare(Entree e1, Entree e2) {
				return e1.getCalories() - e2.getCalories();
			}
		});
		sides.sort(new Comparator<Side>() {
			@Override
			public int compare(Side s1, Side s2) {
				return s1.getCalories() - s2.getCalories();
			}
		});
		salads.sort(new Comparator<Salad>() {
			@Override
			public int compare(Salad s1, Salad s2) {
				return s1.getCalories() - s2.getCalories();
			}
		});
		desserts.sort(new Comparator<Dessert>() {
			@Override
			public int compare(Dessert d1, Dessert d2) {
				return d1.getCalories() - d2.getCalories();
			}
		});

		return new Menu(name, entrees.get(0), sides.get(0), salads.get(0), desserts.get(0));

	}

	public Menu maxCaloriesMenu(String name) {
		entrees.sort(new Comparator<Entree>() {
			@Override
			public int compare(Entree e1, Entree e2) {
				return e2.getCalories() - e1.getCalories();
			}
		});
		sides.sort(new Comparator<Side>() {
			@Override
			public int compare(Side s1, Side s2) {
				return s2.getCalories() - s1.getCalories();
			}
		});
		salads.sort(new Comparator<Salad>() {
			@Override
			public int compare(Salad s1, Salad s2) {
				return s2.getCalories() - s1.getCalories();
			}
		});
		desserts.sort(new Comparator<Dessert>() {
			@Override
			public int compare(Dessert d1, Dessert d2) {
				return d2.getCalories() - d1.getCalories();
			}
		});

		return new Menu(name, entrees.get(0), sides.get(0), salads.get(0), desserts.get(0));
	}

	public ArrayList<Entree> getEntrees() {
		return entrees;
	}

	public void setEntrees(ArrayList<Entree> entrees) {
		this.entrees = entrees;
	}

	public ArrayList<Side> getSides() {
		return sides;
	}

	public void setSides(ArrayList<Side> sides) {
		this.sides = sides;
	}

	public ArrayList<Salad> getSalads() {
		return salads;
	}

	public void setSalads(ArrayList<Salad> salads) {
		this.salads = salads;
	}

	public ArrayList<Dessert> getDesserts() {
		return desserts;
	}

	public void setDesserts(ArrayList<Dessert> desserts) {
		this.desserts = desserts;
	}

}


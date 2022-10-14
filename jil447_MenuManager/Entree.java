package jil447_MenuManager;
/**
 * Class Entree
 * author:Jin Li
 * created:10/09/2022
 */
public class Entree {
    private String name;
    private String description;
    private int calories;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    Entree(String name, String description, int calories){
        this.name = name;
        this.description = description;
        this.calories = calories;
    }
}

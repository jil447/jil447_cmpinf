package jil447_MenuManager_v2;
/**
 * Class Menu
 * @author:Jin Li
 * @created:10/09/2022
 */
public class Menu {
    private String name;
    private Entree entree;
    private Salad salad;
    private Side side;
    private Dessert dessert;

    Menu(String name, Entree entree, Salad salad){
        this.name = name;
        this.entree = null;
        this.side = null;
        this.salad = null;
        this.dessert = null;
    }
    Menu(String name, Entree entree,Side side){
        this.name = name;
        this.entree = entree;
        this.side = side;
        this.salad = null;
        this.dessert = null;
    }
    Menu(String name, Entree entree,Side side,Salad salad,Dessert dessert){
        this.name = name;
        this.entree = entree;
        this.side = side;
        this.salad = salad;
        this.dessert = dessert;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Entree getEntree() {
        return entree;
    }
    public void setEntree(Entree entree) {
        this.entree = entree;
    }
    public Side getSide() {
        return side;
    }
    public void setSide(Side side) {
        this.side = side;
    }
    public Salad getSalad() {
        return salad;
    }
    public void setSalad(Salad salad) {
        this.salad = salad;
    }
    public Dessert getDessert() {
        return dessert;
    }
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    int totalCalories(){
        double totalCals=0;
        if(this.entree!=null) {
            totalCals+=this.entree.getCalories();
        }
        if(this.side!=null) {
            totalCals+=this.side.getCalories();
        }
        if(this.salad!=null) {
            totalCals+=this.salad.getCalories();
        }
        if(this.dessert!=null) {
            totalCals+=this.dessert.getCalories();
        }
        return (int) totalCals;
    }
    public String description() {
        String description = "";
        description+=this.name;
        description+="\n";
        if(this.entree!=null){
            description+="Entree:"+this.entree.getDescription();
        }else{
            description+="Entree:N/A";
        }
        description+="\n";
        if(this.side!=null){
            description+="Side:"+this.side.getDescription();
        }else{
            description+="Side:N/A";
        }
        description+="\n";
        if(this.salad!=null){
            description+="Salad:"+this.salad.getDescription();
        }else{
            description+="Salad:N/A";
        }
        description+="\n";
        if(this.dessert!=null) {
            description+="Dessert:"+this.dessert.getDescription();
        }else{
            description+="Dessert:N/A";
        }
        description+="\n";
        return description;
    }
}
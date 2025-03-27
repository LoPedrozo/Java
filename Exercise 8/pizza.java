public class pizza {
    private String name;
    private float price;
    private String ingredients;

    public pizza(String name,float price, String ingredients){
        this.name=name;
        this.price=price;
        this.ingredients=ingredients;
    }

    public String getName(){
        return name;
    }

    public float getPrice(){
        return price;
    }

    public String getIngredients(){
        return ingredients;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " (" + ingredients + ")";
    }

}

public class contact {
    private String name;
    private String number;

    public contact(String name, String number){
        this.name=name;
        this.number=number;
    }

    public String getName(){
        return name;
    }

    public String getNumber(){
        return number;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Number: " + number;
    }
}


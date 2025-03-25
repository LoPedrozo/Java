public class player {

    private String name;
    private int score;
    private int level;

    public static void print(String a){

        System.out.print(a);
    }
    public static void println(String p){

        System.out.println(p);
    }

    public player(String name, int score, int level){
        this.name = name;
        this.score = score;
        this.level = level;

    }

    public void IncreaseScore(int points){
        if (points>0){
            this.score += points;
            println(points + " points added ");
            println("New score " + score);
            println("----------------------");
        }
        else {
           println("Enter positive points");
        }
    }

    public void LevelUp(){
        this.level++;
        println("Congratulations! You have leveled up " + this.level + " !");
        println("----------------------");

    }

    public String getName(){
        return name;
    }

    public float getScore(){
        return score;
    }

    public int getLevel(){
        return level;
    }

    public void displayInfo(){
        println("Name " + name);
        println("score: " + score);
        println("level: " + level);
        println("----------------------");
    }
}
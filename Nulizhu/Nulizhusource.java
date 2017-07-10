package Nulizhu;

public class Nulizhusource {
    public int health = 3;
    public String type = "Empty";
    public Nulizhusource(String mytype) {
        this.type = mytype;
    }
    public void gethit(){
        health -=1;
    }
}

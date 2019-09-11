public class Elephant extends Animal {
    public Elephant() {
        System.out.print("Constructing elephant");
    }
    public Elephant(String s) {
        super(s);
        System.out.print("Contructing elephant with string:"+s);
    }
    public void getAnimal() {
        System.out.print("Inside child elephant");
    }
}

package week1.one;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + this.name + " says: Meow!");
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Whiskers");
        Cat cat2 = new Cat("Rex");
        cat.meow();
        cat.meow();
        cat2.meow();
        cat.meow();
    }
}//
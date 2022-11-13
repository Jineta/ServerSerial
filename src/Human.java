import java.io.Serializable;

public class Human implements Serializable {
    String name;
    String sex;
    int age;

    public Human(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Name: " + this.name + ", Sex: " + this.sex + ", Age: " + this.age;
    }
}

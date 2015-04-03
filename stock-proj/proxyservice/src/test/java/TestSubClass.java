/**
 * Created by wgz on 15/4/2.
 */
public class TestSubClass {
    public static void main(String[] args) {
        Child child = new Child();
        child.f();
    }
}

class Father {
    public void f() {
        System.out.println("parent class");
    }
}
class Child extends Father{
    public void f() {
        super.f();
        System.out.println("child class");
    }
}

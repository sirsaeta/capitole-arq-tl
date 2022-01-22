class Base {
    public void Print() {
    System.out.println(""Base"");// replace for System.out.println("Base");
    // System.out.println("Base");
    }
}

class Derived extends Base {
    public void Print() {
    System.out.println(""Derived"");// replace for System.out.println("Derived");
    // System.out.println("Derived");
    }
}

class Main {
    public static void DoPrint(Base o) {
        o.Print();
    }

    public static void main(String[] args) {
        Base x = new Base();
        Base y = new Derived();
        Derived z = new Derived();
        DoPrint(x);
        DoPrint(y);
        DoPrint(z);
    }
}

//resp d si se corrige el A
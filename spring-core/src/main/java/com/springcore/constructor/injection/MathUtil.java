package com.springcore.constructor.injection;

public class MathUtil {
    private int a;
    private int b;

    public MathUtil(double a, double b) {
        this.a = (int) a;
        this.b = (int) b;
        System.out.println("Constructor :double, double");
    }

    public MathUtil(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println("Constructor :int, int");
    }

    public MathUtil(String a, String b){
        this.a = Integer.parseInt(a);
        this.b = Integer.parseInt(b);
        System.out.println("Constructor :String, String");
    }

    public void doSum(){
        System.out.println("sum : "+ (this.a + this.b));
    }
}

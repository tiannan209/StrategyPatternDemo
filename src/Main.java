import java.util.Stack;

//In Strategy pattern, a class behavior or its algorithm can be changed at run time.
//This type of design pattern comes under behavior pattern.
//
//In Strategy pattern, we create objects which represent various strategies and a context
// object whose behavior varies as per its strategy object.
// The strategy object changes the executing algorithm of the context object.
//
//Use the Strategy pattern when you want to use different variants of an algorithm within an
// object and be able to switch from one algorithm to another during runtime.

public class Main {

    public static void main(String[] args) {

        //Stack s = new Stack();

        Employee salesman = new Salesman(15000.00);
        Employee secretary = new Secretary(10000.00);

        salesman.setPayType(new GetBonus());
        secretary.setPayType(new NoBouns());

        System.out.println("Salesman  " + salesman.getPay());
        System.out.println("Secretary  " + secretary.getPay());
    }


}

class Employee {

    protected double salary = 0.0;

    public Pay payType = new NoBouns();

    public Employee(double salary) {
        this.salary = salary;
    }

    public Employee(double salary, Pay payType) {
        this.salary = salary;
        this.payType = payType;
    }

    public void setPayType(Pay newPayType){
        this.payType = newPayType;
    }

    public double getPay(){
        return payType.getPay(this.salary);
    }
}

    interface Pay{
        double getPay(double salary);
    }

    // Get 15% extra bonus
    class GetBonus implements Pay{
        @Override
        public double getPay(double salary) {
            return salary + (salary * .15);
        }
    }

    class NoBouns implements Pay{
        @Override
        public double getPay(double salary) {
            return salary;
        }
    }

    class Salesman extends Employee{
         Salesman(double salary){
             super(salary);
         }

         Salesman(double salary, Pay payType){
             super(salary, payType);
         }
    }

    class Secretary extends Employee{
        Secretary(double salary){
            super(salary);
        }

        Secretary(double salary, Pay payType){
            super(salary, payType);
        }
    }


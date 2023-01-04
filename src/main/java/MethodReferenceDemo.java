import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceDemo {

    static int add(int a, int b){
        return a + b;
    }

    @FunctionalInterface
    interface printable {
        void print(String msg);
    }

    public static void main(String[] args){

        //Functional interface and Lambda expression
        Function<Integer, Double> function = Math::sqrt;
        System.out.println(function.apply(5));

        Function<Integer, Double> function1 = Math::sqrt;
        System.out.println(function1.apply(13));

        BiFunction<Integer, Integer, Integer> function2 = (a, b) ->  MethodReferenceDemo.add(a, b);
        System.out.println(function2.apply(8, 9));

        //Method Reference in Static Method
        BiFunction<Integer, Integer, Integer> function3 = MethodReferenceDemo::add;
        function3.apply(1, 3);

        MethodReferenceDemo referenceDemo = new MethodReferenceDemo();

        printable printable = (msg) -> referenceDemo.message(msg);
        printable.print("Hello World");

        // Method reference in object
        printable printable1 = referenceDemo::message;
        printable1.print("Hi From Method Reference");

        //Method reference in Class Method
        Function<String, String> stringFunction = String::toUpperCase;
        System.out.println(stringFunction.apply("Testing testing"));
    }

    void message (String msg){
        msg = msg.toUpperCase();
        System.out.println(msg);
    }
}

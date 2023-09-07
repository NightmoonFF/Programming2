package Utility;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface Printable {

    void printAnyNameYouWant();

    default ArrayList<Runnable> getPrintable() {
        Class<?> clazz = this.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        // Filter methods with names starting with "print"
        List<Method> exerciseMethods = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("print"))
                .collect(Collectors.toList());

        // Filter methods declared in the class (not inherited from interfaces)
        List<Method> classMethods = Arrays.stream(methods)
                .filter(method -> method.getDeclaringClass() == clazz)
                .collect(Collectors.toList());

        // Convert printable methods to Runnable and collect them in an ArrayList
        ArrayList<Runnable> printableList = classMethods.stream()
                .map(method -> (Runnable) () -> {
                    try {
                        method.invoke(this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                })
                .collect(Collectors.toCollection(ArrayList::new));

        // Sort the printableList alphabetically by the method names
        printableList.sort((runnable1, runnable2) -> {
            String methodName1 = runnable1.toString();
            String methodName2 = runnable2.toString();
            return methodName1.compareTo(methodName2);
        });

        return printableList;
    }

}

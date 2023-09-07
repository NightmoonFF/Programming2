package Utility;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface Printable {
    default ArrayList<NamedTask> getPrintable() {
        Class<?> c = this.getClass();
        Method[] methods = c.getDeclaredMethods();

        // Filter methods with names starting with "print"
        List<Method> printableMethods = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("print"))
                .collect(Collectors.toList());

        // Filter methods declared in the class (not inherited from interfaces)
        List<Method> classMethods = printableMethods.stream()
                .filter(method -> method.getDeclaringClass() == c)
                .collect(Collectors.toList());

        // Convert methods to NamedTask and collect them in an ArrayList
        ArrayList<NamedTask> namedTaskList = new ArrayList<>();
        for (Method method : classMethods) {
            namedTaskList.add(new NamedTask(method.getName()) {
                @Override
                public void run() {
                    try {
                        method.invoke(c.newInstance()); // Create an instance of the declaring class
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // Sort the namedTaskList alphabetically by the method names
        namedTaskList.sort((runnable1, runnable2) -> {
            String methodName1 = runnable1.toString();
            String methodName2 = runnable2.toString();
            return methodName1.compareTo(methodName2);
        });

        return namedTaskList;
    }
}

abstract class NamedTask implements Runnable {
    private String taskName;

    public NamedTask(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

}

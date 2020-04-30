package by.epam.nickgrudnitsky.homework4.task1;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class NewSayHelloMethodForEClass implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("Hello from replaced method!");
        return null;
    }
}

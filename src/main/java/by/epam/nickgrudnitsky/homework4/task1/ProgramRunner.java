package by.epam.nickgrudnitsky.homework4.task1;

import by.epam.nickgrudnitsky.homework4.task1.beans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProgramRunner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        A a = context.getBean("A", A.class);
        System.out.println(a);

        B b = context.getBean("B", B.class);
        System.out.println(b);

        C c = context.getBean("C", C.class);
        System.out.println(c);

        D d1 = c.createD();
        D d2 = c.createD();
        System.out.println("d1: " + d1);
        System.out.println("d2: " + d2);
        System.out.println("d1 == d2 - " + (d1 == d2));

        E e = context.getBean("E", E.class);
        System.out.println(e);
        e.sayHello();

        F f = context.getBean("F", F.class);
        System.out.println(f);

        context.close();
    }
}

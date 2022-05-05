package Homework_7_Java3;

import Homework_7_Java3.annotations.AfterSuite;
import Homework_7_Java3.annotations.BeforeSuite;
import Homework_7_Java3.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {


    

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {

        Class cl = Tests.class;
        Object obj = cl.newInstance();
        Method[] methods = cl.getDeclaredMethods();
        List<Method> methodList = new ArrayList<>();
        Method before = null;
        Method after = null;
        for (Method method : methods) {

            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (before == null) before = method;
                else {
                    throw new RuntimeException();
                }
            }

            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (after == null) after = method;
                else {
                    throw new RuntimeException();
                }
            }

            if (method.isAnnotationPresent(Test.class)) {
                methodList.add(method);
            }

        }

        methodList.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).priority()-o1.getAnnotation(Test.class).priority();
            }
        });

        output(obj, methodList, before, after);

    }

    private static void output(Object obj, List<Method> methodList, Method before, Method after) throws IllegalAccessException, InvocationTargetException {
        before.invoke(obj);
        for (Method method : methodList) method.invoke(obj);
        after.invoke(obj);
    }

}

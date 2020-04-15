package com.crx.sample;


import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class MyComplier {
    public static void main(String[] args) {
        compile();
    }

    static void compile(){
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int status = compiler.run(null,null,null,"-d","E:/my-app","E:/my-app/ATest.java");
        if(status !=0 ){
            System.out.println("failed.");
        }
        try {
            SecurityClassLoader loader = new SecurityClassLoader();
            loader.setRootDir("E:/my-app");
            //Class aTest = Class.forName("E:/my-app/ATest");
            Class aTest = loader.findClass("ATest");
            Object o = aTest.newInstance();
            Method m = aTest.getDeclaredMethod("greeting");
            m.invoke(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //System.out.println(System.getProperty("java.class.path"));
    }
}

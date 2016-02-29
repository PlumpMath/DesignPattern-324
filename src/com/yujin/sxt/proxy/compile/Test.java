package com.yujin.sxt.proxy.compile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.yujin.sxt.proxy.Moveable;
import com.yujin.sxt.proxy.Tank;

public class Test {

    public static void main(String[] args) {
        String rt = "\r\t";
        String str = "package com.yujin.sxt.proxy;" +  rt+  rt+ 
                "public class TankTimeProxy2 implements Moveable {" + rt+ 
                "    Moveable tank;" + rt+ 

                "    public TankTimeProxy2(Moveable tank) { " + rt+ 
                "        super();"+ rt+ 
                "        this.tank = tank;" + rt+ 
                "    }" + rt+ 

                "    @Override" + rt+ 
                "    public void move() {" + rt+ 
                "        long start = System.currentTimeMillis();" + rt+ 
                "        System.out.println(\"start time: \" + start);" + rt+ 
                "        tank.move();" + rt+ 
                "        long end = System.currentTimeMillis();" + rt+ 
                "        System.out.println(\"run time: \" + (end - start));" + rt+ 
                "    }" + rt+ 

                "    @Override" + rt+ 
                "    public void stop() {" + rt+ 
                "        long start = System.currentTimeMillis();" + rt+ 
                "        System.out.println(\"start time: \" + start);" + rt+ 
                "        tank.move();" + rt+ 
                "        long end = System.currentTimeMillis();" + rt+ 
                "        System.out.println(\"run time: \" + (end - start));" + rt+ 
                "    }" + rt+ 
                "}";
        
        String fileName = System.getProperty("user.dir")
                + "/src/com/yujin/sxt/proxy/TankTimeProxy2.java";
        System.out.println("fileName: " + fileName);
        File file = new File(fileName);
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(str);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //compile
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(compiler.getClass().getName());
        StandardJavaFileManager javaMgr = compiler.getStandardFileManager(null, null, null);
        Iterable unit = javaMgr.getJavaFileObjects(fileName);
        CompilationTask task = compiler.getTask(null, javaMgr, null, null, null, unit);
        task.call();
        
        //Load Memory & create an instance object
        try {
            URL[] urls = new URL[] { new URL("file:/" + System.getProperty("user.dir") + "/bin") };
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("com.yujin.sxt.proxy.TankTimeProxy2");
            System.out.println(c);
            // c.newInstance(); //没有无参的构造方法,所以不能用此方式
            Constructor constructor = c.getConstructor(Moveable.class);
            Moveable m;
            m = (Moveable) constructor.newInstance(new Tank());
            m.move();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}

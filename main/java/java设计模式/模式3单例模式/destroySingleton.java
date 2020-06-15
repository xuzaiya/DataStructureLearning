package java设计模式.模式3单例模式;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/*
* 破坏单例的三种方式
*
*
* */
public class destroySingleton {
    public static void main(String[] args) throws Exception {
        System.out.println("-----------序列化----------------------");
        Singleton originSingleton = Singleton.getInstance();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(Singleton.getInstance());
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Singleton serializeSingleton = (Singleton) ois.readObject();
        System.out.println(originSingleton == serializeSingleton);//false

        System.out.println("-----------反射----------------------");
        //通过反射获取
        Constructor<Singleton> cons = Singleton.class.getDeclaredConstructor();
        cons.setAccessible(true);
        Singleton reflextSingleton = cons.newInstance();
        System.out.println(reflextSingleton == originSingleton);//false

        System.out.println("---------------------------克隆----------------------");

        //Singleton cloneSingleton = (Singleton) originSingleton.clone();
        //System.out.println(cloneSingleton == originSingleton);//false

    }

}

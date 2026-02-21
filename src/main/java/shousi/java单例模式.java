package shousi;

public class java单例模式 {
    public static void main(String[] args) {

    }
}

/**
 * 懒汉式
 */
final class Singleton1{
    private Singleton1(){}
    private volatile Singleton1 INSTANCE = null;
    public Singleton1 getInstance(){
        if(INSTANCE==null){
            synchronized (Singleton1.class){
                if(INSTANCE==null){
                    INSTANCE = new Singleton1();
                }
            }
        }
        return INSTANCE;
    }
}

/**
 * 饿汉式
 */
class Singleton2{
    private Singleton2(){}
    private final static Singleton2 INSTANCE = new Singleton2();
    public static Singleton2 getInstance(){
        return INSTANCE;
    }
}
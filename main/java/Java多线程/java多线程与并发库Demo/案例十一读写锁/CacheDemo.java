package Java多线程.java多线程与并发库Demo.案例十一读写锁;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//面試题 ：緩存系統
public class CacheDemo {

    private Map<String ,Object> cache = new HashMap<>();
    public static void main(String[] args) {

    }
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public  Object getData(String key){
        rwl.readLock().lock();
        Object value = null;
        try{
            value = cache.get(key);
            if (value == null){
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try{
                    if(value == null){
                        value = "aaa";//实际去数据库查询
                        cache.put(key,value);
                    }

                }finally {
                    rwl.writeLock().unlock();
                }
                rwl.readLock().lock();


            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwl.readLock().unlock();
        }

        return value;

    }
}

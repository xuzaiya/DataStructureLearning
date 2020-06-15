package java多线程与并发库高级应用.Demo11自己设计一个缓存系统;



import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {
    private Map<String,Object> cache = new HashMap<>();
    public static void main(String[] args) {

    }

    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public  Object getData(String key){
        rwl.readLock().lock();
        Object value = null;
        try{
            value = cache.get(key);
            if(value == null){
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try{
                    if (value == null){
                        value = "aaaa"; //表示去数据库查询数据
                    }
                    cache.put(key,value);
                }finally {
                    rwl.writeLock().unlock();
                }
                rwl.readLock().unlock();


            }
        }finally {
            rwl.readLock().unlock();
        }


        return value;
    }
}

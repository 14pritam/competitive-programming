package Practice.GoldManSachsProblems;

public class UseCache {

    public static void main(String[] args){

        LRUCache<Integer> lruCache = new LRUCache<>(4);

        lruCache.put(String.valueOf(3),4);
        lruCache.put(String.valueOf(4),2);
        System.out.println(lruCache.get(String.valueOf(3)));

        lruCache.put(String.valueOf(5),1);
        System.out.println(lruCache.get(String.valueOf(5)));
        lruCache.put(String.valueOf(6),1);

        lruCache.put(String.valueOf(7),1);
        lruCache.put(String.valueOf(4),2);
        lruCache.get(String.valueOf(3));
        System.out.println(lruCache.get(String.valueOf(4)));
    }
}

package other;


import java.util.LinkedHashMap;
import java.util.Map;

public class Code12_LRU {

    /**
     * 继承 LinkedHashMap
     */
    static class LRUCache extends LinkedHashMap {

        /**
         * 容量
         */
        private int capacity;

        /**
         * 调用父类的构造方法
         * capacity：容量
         * 0.75F：负载因子
         * true：开启 LRU 缓存算法
         */
        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        /**
         * 获取元素，调用父类的构造方法
         * 原理：
         * 	（1）首先将这个元素从队列中移除
         *	（2）然后再将这个元素添加到队列的头部
         */
        public int get(int key) {
            return (int) super.getOrDefault(key, -1);
        }

        /**
         * 得到元素，调用父类的构造方法
         * 原理：
         * 	（1）首先判断 key 所代表的元素是否已经在队列中
         * 	（2）如果在队列中，则直接覆盖元素的值即可
         *	（3）覆盖之后则从队列中移除，然后再添加到队列头部
         * 	（4）此时操作完成
         * 	（5）如果不在队列中，则判断容量是否足够
         * 	（6）如果容量足够，则直接添加到队列头部，此时操作完成
         *	（7）如果容量不足够，则移除队列最后一个元素
         * 	（8）并且将要添加的元素添加到队列的头部，此时操作完成
         */
        public void put(int key, int value) {
            super.put(key, value);
        }

        /**
         * 移除元素条件方法，因为在 LinkedHashMap 中是空方法
         * 所以我们需要重写方法，定义自己的逻辑
         * 这里就是当容量不够时进行移除元素
         */
        @Override
        public boolean removeEldestEntry(Map.Entry eldest) {
            return super.size() > capacity;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
    }



}

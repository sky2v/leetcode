package other;


import java.util.HashMap;
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

    static class LRUCache2 {

        /**
         * 双向链表长度
         */
        private int size;

        /**
         * 最大容量
         */
        private int capacity;

        /**
         * 哈希表，存储数据
         */
        private Map<Integer, DoubleLinkedNode> cache;

        /**
         * 双向链表头节点，不存储任何值，标识作用
         */
        private DoubleLinkedNode head;

        /**
         * 双向链表尾节点，不存储任何值，标识作用
         */
        private DoubleLinkedNode tail;

        /**
         * 构造方法
         */
        public LRUCache2(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.head = new DoubleLinkedNode();
            this.tail = new DoubleLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        /**
         * 获取元素
         */
        public int get(int key) {
            DoubleLinkedNode node = this.cache.get(key);

            // 如果要获取的节点不存在
            if (node == null) {
                return -1;
            }
            // 移动到双向链表头部
            moveToHead(node);
            // 返回值
            return node.value;
        }

        /**
         * 添加元素
         */
        public void put(int key, int value) {
            DoubleLinkedNode node = cache.get(key);
            // 如果元素不存在
            if (node == null) {
                node = new DoubleLinkedNode(key, value);
                // 添加到哈希表中
                cache.put(key, node);
                // 双向链表长度加 1
                size++;
                // 添加到双向链表头部
                addToHead(node);
                // 如果长度大于容量，说明要删除元素了
                if (size > capacity) {
                    // 从双向链表中删除最后一个元素
                    DoubleLinkedNode tail = removeTail();
                    // 同时从哈希表中删除对应的元素
                    cache.remove(tail.key);
                    // 长度减 1
                    size--;
                }
                // 如果元素存在
            } else {
                // 修改值
                node.value = value;
                // 移动到双向链表头部
                moveToHead(node);
            }
        }

        /**
         * 自己构造一个双向链表节点
         */
        class DoubleLinkedNode {

            /**
             * 键
             */
            int key;

            /**
             * 值
             */
            int value;

            /**
             * 前驱节点
             */
            DoubleLinkedNode prev;

            /**
             * 后继节点
             */
            DoubleLinkedNode next;

            /**
             * 构造方法
             */
            public DoubleLinkedNode() {}
            public DoubleLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        /**
         * 添加一个节点到双向链表头部
         */
        private void addToHead(DoubleLinkedNode node) {
            node.next = head.next;
            node.prev = head;
            node.next.prev = node;
            head.next = node;
        }

        /**
         * 从双向链表中删除一个节点
         */
        private void removeNode(DoubleLinkedNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        /**
         * 将双向链表中一个节点移动双向链表到头部
         */
        private void moveToHead(DoubleLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        /**
         * 移除双向链表中最后一个节点
         */
        private DoubleLinkedNode removeTail() {
            DoubleLinkedNode node = this.tail.prev;
            removeNode(node);
            return node;
        }
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
    }



}

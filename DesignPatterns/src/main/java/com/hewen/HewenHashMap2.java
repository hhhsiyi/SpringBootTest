package com.hewen;

/**
 * 2022/3/14
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class HewenHashMap2<K, V> implements HewenMap<K, V> {
    private Entry<K, V> table[]=null;
    int CAPACITY = 16;
    int size = 0;

    public HewenHashMap2() {
        this.table = new Entry[16];
    }

    public HewenHashMap2(Entry<K, V>[] table) {
        this.table = new Entry[16];//初始化的时候会有一个数组是2的四次方
    }

    /**
     * 需要写一个hash算法，来算hashCode
     * 然后需要通过对hashCode取模放到指定地方，同时该值就是index数组的下标。
     * 判断当前对象是否是空，如果是空，直接存储。
     * 如果不空，就是hash冲突，采用next链表。
     * 返回当前节点对象。
     */
    @Override
    public V put(K k, V v) {
        int index = hash(k);
        Entry<K, V> entry = table[index];
        if (null == entry) {
            //当前这个下标的节点是空的，我们就直接把数据扔进这个下标处就行了。
            table[index] = new Entry<>(k, v, index, null);
            size++;
        } else {
            //下标的节点不是空的的话，我们直接把这个值变成之前那个值的后面一个节点，
            table[index] = new Entry<>(k, v, index, entry);
        }
        return table[index].getValue();
    }

    private int hash(K k) {
//        getHashCode
//        真正的底层其实是有移位操作在里面的！
        int index = k.hashCode() % CAPACITY;
        return index >= 0 ? index : -index;
    }

    private int getHashCode(K k) {
        String a = k.toString();
        int sum = 0;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            int t = c;
            sum += t;
        }

        return sum;
    }

    @Override
    public V get(K k) {
        //通过key进行hash，
        // 拿到index对应下标对象，
        // 判断当前对象是否为空：
        // 如果不为空，判断是否相等；如果不相等，就判断next是否为空；
        // 如果不为空，再判断是否相等。直到相等或者空为止
        if (size==0){
            return null;
        }
//        int index = k.hashCode() % CAPACITY;
        int index = hash(k);
        Entry<K, V> entry = findValue(table[index],k);
        return entry.v;
    }

    private Entry<K,V> findValue(Entry<K,V> entry, K k) {
        //k是我们要查询的，entry是我们取出下标为k的所有节点。
        if (k==entry.getKey()||k.equals(entry.getKey())){
            return entry;
        }else {
            if (entry.next!=null){
                //递归
                return findValue(entry.next,k);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size++;
    }

    class Entry<K, V> implements HewenMap.Entry<K, V> {

        K k;
        V v;
        int hash;
        Entry<K, V> next;

        //有参构造方便扔数据进去
        public Entry(K k, V v, int hash, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.k;
        }

        @Override
        public V getValue() {
            return this.v;
        }
    }

    public static void main(String[] args) {
//        HewenHashMap2<String, String> map2 = new HewenHashMap2<String, String>();
//        int abc = map2.getHashCode("abc");
//        System.out.println(abc);
        HewenHashMap2<String, Integer> map = new HewenHashMap2<>();
        map.put("何文",24);
        map.put("何文文",25);
        System.out.println(map.get("何文"));
        System.out.println(map.get("何文文"));
    }
}

package list;

/**
 * 2022/3/25
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        Student s1 = new Student("何文1", 1);
        Student s2 = new Student("何文2", 2);
        Student s3 = new Student("何文3", 3);
        Student s4 = new Student("何文4", 4);
        Student s5 = new Student("何文5", 5);

        LinkedList1 list1 = new LinkedList1(s1);
        LinkedList1 list2 = new LinkedList1(s2);
        LinkedList1 list3 = new LinkedList1(s3);
        LinkedList1 list4 = new LinkedList1(s4);
        list1.setNext(list2);
        list2.setNext(list3);
        list3.setNext(list4);
        list1.add(new LinkedList1(s5));
//        System.out.println(list1);
//        System.out.println(list1.size());
        list1.delByIndex(5);
        System.out.println(list1);
    }

}

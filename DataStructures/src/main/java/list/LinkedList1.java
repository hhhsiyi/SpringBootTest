package list;

/**
 * 2022/3/25
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class LinkedList1 {
    //单向链表
    //应该有数据域和下一个节点.
    private Student data;
    private LinkedList1 next;

    public void add(LinkedList1 value) {
        LinkedList1 tmp = this;
        while (true) {
            if (null == tmp.getNext()) {
//                this.next = value;
                break;
//            return true;
            } else {
                tmp = tmp.getNext();
            }
        }
        tmp.next = value;
    }

    public LinkedList1(Student data) {
        this.data = data;
    }

    public int size() {
        int size = 0;
        LinkedList1 tmp = this;
        System.out.println(this.equals(tmp));
        System.out.println(this.hashCode() == tmp.hashCode());
        while (true) {
            if (null == tmp.getNext()) {
//                this.next = value;
                size++;
                break;
//            return true;
            } else {
                size++;
                tmp = tmp.getNext();
//                this.next = this.next.next;
//                this.next = this.getNext().getNext();
//                this.next = this;
//                this = this.next;
            }
        }
        return size;
    }

    public void delByNum(Student data) {

    }

    public void delByIndex(int n) {
        //删除单链表第n个数
        int count = 0;
        LinkedList1 tmp = this;
        if (n == 0) {
            this.data = this.next.data;
            this.next = this.next.next;
            return;
        }
        while (this.next != null) {
            if (count == n - 1) {
                if (null != tmp.next) {
                    tmp.data = tmp.next.data;
                    tmp.next = tmp.next.next;
                } else {
                    tmp.data = tmp.data;
                    tmp.next = null;
                }
            } else {
                tmp = tmp.next;
                count++;
            }
        }

    }

    public LinkedList1() {
    }

    @Override
    public String toString() {
        return "\nLinkedList1{" +
                "data=" + data +
                ", next=" + next +
                '}'
                ;
    }

    public LinkedList1(Student data, LinkedList1 next) {
        this.data = data;
        this.next = next;
    }

    public Student getData() {
        return data;
    }

    public void setData(Student data) {
        this.data = data;
    }

    public LinkedList1 getNext() {
        return next;
    }

    public void setNext(LinkedList1 next) {
        this.next = next;
    }
}

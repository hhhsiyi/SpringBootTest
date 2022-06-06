package queue;

/**
 * 2022/3/24
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class ArrayQueueDemo {


    public static void main(String[] args) {
        ArrayQueue2 arrayQueue = new ArrayQueue2(5);

        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
        arrayQueue.show();
        arrayQueue.addQueue(4);
//        System.out.println(arrayQueue.getQueue());
//        System.out.println(arrayQueue.justShowHeader());
        arrayQueue.addQueue(5);
        arrayQueue.show();
        System.out.println(arrayQueue.getQueue());
        arrayQueue.addQueue(6);
        arrayQueue.show();


//        boolean loop = true;
//        char key = ' ';
//        Scanner scanner = new Scanner(System.in);
//        while (loop) {
//            System.out.println("e,退出");
//            System.out.println("s,显示");
//            System.out.println("a,添加");
//            System.out.println("g,取出");
//            System.out.println("h,拿头");
//            System.out.println("==========开始===========");
//            key = scanner.next().charAt(0);
//            switch (key) {
//                case 'e':
//                    loop = false;
//                    break;
//                case 's':
//                    arrayQueue.show();
//                    break;
//                case 'a':
//                    arrayQueue.addQueue(scanner.nextInt());
//                    break;
//                case 'g':
//                    System.out.println(arrayQueue.getQueue());
//                    break;
//                case 'h':
//                    System.out.println(arrayQueue.justShowHeader());
//                    break;
//                default:
//                    break;
//            }
//        }
//        System.out.println("退出");
    }
}

class ArrayQueue1 {
    private int maxSize;//数组的最大容量
    private int head;//队列头
    private int foot;//队列尾
    private int[] arr;//数组队列

    public ArrayQueue1(int maxSize) {
        this.maxSize = maxSize;
        head = -1;//指向队列头部的前一个位置
        foot = -1;//指向队列最后一个数据
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return foot == maxSize - 1;
    }

    public boolean isEmpty() {
        return head == foot;
    }

    public boolean addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满");
            return false;
        }
        foot++;
        arr[foot] = n;
        return true;
    }

    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
            return -99999;
        }
        head++;
        return arr[head];
    }

    public int justShowHeader() {
        if (isEmpty())
            return -99999;
        return arr[head + 1];
    }

    public void show() {
        if (isEmpty())
            System.out.println("队列空");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }
}

class ArrayQueue2 {
    private int maxSize;//数组的最大容量
    private int head;//队列头
    private int foot;//队列尾
    private int[] arr;//数组队列

    public ArrayQueue2(int maxSize) {
        this.maxSize = maxSize;
        head = 0;//指向队列头部的前一个位置
        foot = 0;//指向队列最后一个数据
        arr = new int[maxSize];
    }

    public boolean isFull() {
//        if (Math.abs(head-foot)==maxSize){
//            return true;
//        }
//        if (head == foot && head == -1) {
//            return false;
//        }
//        return foot == head;
        //上面的那种写法,没有预留空位,导致无法判断队列是否为空!
        return (foot+1)%maxSize == head;
    }

    public boolean isEmpty() {
        return head == foot;
    }

    public boolean addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满");
            return false;
        }
//        if (foot == maxSize-1) foot=-1;
//        foot++;
        arr[foot] = n;
        foot=(foot+1)%maxSize;
        return true;
    }

    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
            return -99999;
        }
//        head++;
        int tmp = arr[head];
        head=(head+1)%maxSize;
        return tmp;
    }

    public int justShowHeader() {
        if (isEmpty())
            return -99999;
        return arr[head + 1];
    }

    public void show() {
        if (isEmpty())
            System.out.println("队列空");
        for (int i = head; i < head+this.size(); i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
        }
    }
//front = head
    public int size(){
        return (foot+maxSize-head)%maxSize;
    }
}

public class Tester {
    public static void main(String[] args) {
    HeapPriorityQueue<Integer> h = new HeapPriorityQueue<Integer>();
    h.add(1);
    h.add(2);
    h.add(3);
    h.add(4);
    h.add(5);
    h.add(6);
    h.add(7);
    System.out.println(h);
    h.remove();
    h.remove();
    System.out.println(h);
    }
}
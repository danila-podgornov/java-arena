// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step06_a_hash_map_of_your_own_ai.challenge02_ai;

public class Main {
    /**
     * A dry cleaner's map from ticket numbers to customers is the SimpleMap of this step, with 8 buckets. An Integer's hash code is its own value. What does this program print?
     * Hints
     * 1. The bucket is the remainder of dividing by 8, without its minus sign: 14 % 8 is 6, and -3 % 8 is -3, which {@code Math.abs} makes 3.
     * 2. Three of the tickets share bucket 6. {@code get(22)} looks in bucket 6 and finds 22 there. {@code get(30)} looks in bucket 6 too, but none of its keys equals 30.
     */
    public static void main(String[] args) {
        SimpleMap<Integer, String> tickets = new SimpleMap<>();
        int[] numbers = {14, 6, 22, -3, 40};
        String[] names = {"Rosa", "Yusuf", "Mila", "Tom", "Ada"};
        for (int i = 0; i < numbers.length; i++) {
            tickets.put(numbers[i], names[i]);
        }
        for (int number : numbers) {
            System.out.print(Math.abs(Integer.valueOf(number).hashCode() % 8) + " ");
        }
        System.out.println();
        System.out.println(tickets.get(22) + " " + tickets.get(30) + " " + tickets.get(-3));
    }
}

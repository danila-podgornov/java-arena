// AI-Generated
package module27_procedural_and_object_oriented_programs_ai.step01_procedural_programs_ai;

public class Challenge03Ai {
    /**
     * What does this program print? One of the calls doesn't store what {@code read} returns.
     * Hints
     * 1. {@code read(page, 30, 200);} works out 80 and returns it, but nothing stores the answer. The variable {@code page} of {@code main} is still 50.
     * 2. {@code next} gets 50 + 170, which stops at 200. {@code page} doesn't change until the last line stores into it, and that call starts from {@code next}.
     */
    public static void main(String[] args) {
        int page = 0;
        page = read(page, 50, 200);
        read(page, 30, 200);
        System.out.println(page);
        int next = read(page, 170, 200);
        System.out.println(next + " " + page);
        page = read(next, 10, 200);
        System.out.println(page);
    }

    public static int read(int page, int count, int pages) {
        page = page + count;
        if (page > pages) {
            page = pages;
        }
        return page;
    }
}

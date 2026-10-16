// AI-Generated
package module35_interfaces_ai.step02_many_classes_many_interfaces_ai.challenge02_ai;

public class Main {
    /**
     * A laptop and a pair of headphones both implement Chargeable, but they charge at different speeds. What does this program print?
     * Hints
     * 1. Each object runs its own class's {@code charge}: the laptop gains 1 percent a minute, the headphones 5 percent a minute.
     * 2. The laptop goes from 20 to 50, and the headphones from 10 to 70. After that, both would go past 100, so each stops at 100.
     */
    public static void main(String[] args) {
        Laptop laptop = new Laptop(20);
        Headphones headphones = new Headphones(10);
        laptop.charge(30);
        headphones.charge(12);
        System.out.println(laptop.batteryPercent() + " " + headphones.batteryPercent());
        laptop.charge(60);
        headphones.charge(60);
        System.out.println(laptop.batteryPercent() + " " + headphones.batteryPercent());
    }
}

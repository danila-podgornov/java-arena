// AI-Generated
package module50_gui_multiple_views_ai.step07_a_practice_app_part_2_the_views_ai.challenge01_ai;

import java.util.ArrayList;

public class CardBox {
    private ArrayList<Card> cards;

    public CardBox() {
        this.cards = new ArrayList<>();
    }

    public boolean add(String country, String capital) {
        String name = country.trim();
        String city = capital.trim();
        if (name.isEmpty() || city.isEmpty() || this.capitalOf(name) != null) {
            return false;
        }
        this.cards.add(new Card(name, city));
        return true;
    }

    public String capitalOf(String country) {
        for (Card card : this.cards) {
            if (card.getCountry().equals(country)) {
                return card.getCapital();
            }
        }
        return null;
    }

    public String countryAt(int index) {
        return this.cards.get(index).getCountry();
    }

    public int size() {
        return this.cards.size();
    }
}

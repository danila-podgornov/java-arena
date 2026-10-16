// AI-Generated
package module37_streams_and_lambdas_ai.step06_streams_of_objects_ai.challenge03_ai;

public class Screening {
    private String film;
    private int sold;
    private int seats;

    public Screening(String film, int sold, int seats) {
        this.film = film;
        this.sold = sold;
        this.seats = seats;
    }

    public String getFilm() {
        return this.film;
    }

    public int getSold() {
        return this.sold;
    }

    public boolean isSoldOut() {
        return this.sold >= this.seats;
    }
}

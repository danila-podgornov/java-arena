// AI-Generated
package module31_hash_maps_ai.step03_objects_as_values_ai.challenge01_ai;

public class Airport {
    private String code;
    private String city;
    private String country;

    public Airport(String code, String city, String country) {
        this.code = code;
        this.city = city;
        this.country = country;
    }

    public String getCode() {
        return this.code;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String toString() {
        return this.city + ", " + this.country + " (" + this.code + ")";
    }
}

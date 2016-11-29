package co.nri.micasa.trenitime.model.in.viaggiatreno.soluzioniViaggioNew;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Soluzione {

    @JsonProperty("durata")
    private String durata;

    @JsonProperty("vehicles")
    private List<Vehicle> vehicles = new ArrayList<>();

    /**
     * Getter for property 'durata'.
     *
     * @return Value for property 'durata'.
     */
    public String getDurata() {
        return durata;
    }

    /**
     * Setter for property 'durata'.
     *
     * @param durata Value to set for property 'durata'.
     */
    public void setDurata(String durata) {
        this.durata = durata;
    }

    /**
     * Getter for property 'vehicles'.
     *
     * @return Value for property 'vehicles'.
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Setter for property 'vehicles'.
     *
     * @param vehicles Value to set for property 'vehicles'.
     */
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}

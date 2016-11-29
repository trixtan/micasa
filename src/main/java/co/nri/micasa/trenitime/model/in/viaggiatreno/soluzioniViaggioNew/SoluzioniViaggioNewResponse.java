package co.nri.micasa.trenitime.model.in.viaggiatreno.soluzioniViaggioNew;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SoluzioniViaggioNewResponse {

    @JsonProperty("soluzioni")
    private List<Soluzione> soluzioni;

    @JsonProperty("origine")
    private String origine;

    @JsonProperty("destinazione")
    private String destinazione;

    @JsonProperty("errore")
    private String errore;

    /**
     * Getter for property 'soluzioni'.
     *
     * @return Value for property 'soluzioni'.
     */
    public List<Soluzione> getSoluzioni() {
        return soluzioni;
    }

    /**
     * Setter for property 'soluzioni'.
     *
     * @param soluzioni Value to set for property 'soluzioni'.
     */
    public void setSoluzioni(List<Soluzione> soluzioni) {
        this.soluzioni = soluzioni;
    }

    /**
     * Getter for property 'origine'.
     *
     * @return Value for property 'origine'.
     */
    public String getOrigine() {
        return origine;
    }

    /**
     * Setter for property 'origine'.
     *
     * @param origine Value to set for property 'origine'.
     */
    public void setOrigine(String origine) {
        this.origine = origine;
    }

    /**
     * Getter for property 'destinazione'.
     *
     * @return Value for property 'destinazione'.
     */
    public String getDestinazione() {
        return destinazione;
    }

    /**
     * Setter for property 'destinazione'.
     *
     * @param destinazione Value to set for property 'destinazione'.
     */
    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    /**
     * Getter for property 'errore'.
     *
     * @return Value for property 'errore'.
     */
    public String getErrore() {
        return errore;
    }

    /**
     * Setter for property 'errore'.
     *
     * @param errore Value to set for property 'errore'.
     */
    public void setErrore(String errore) {
        this.errore = errore;
    }
}

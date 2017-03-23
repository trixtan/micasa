package co.nri.micasa.trenitime.model.in.viaggiatreno.soluzioniViaggioNew;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import co.nri.micasa.trenitime.deserializer.ViaggiatrenoJsonDateDeserializer;

public class Vehicle {

    @JsonProperty("origine")
    private String origine;

    @JsonProperty("destinazione")
    private String destinazione;

    @JsonProperty("orarioPartenza")
    @JsonDeserialize(using = ViaggiatrenoJsonDateDeserializer.class)
    private Date orarioPartenza;

    @JsonProperty("orarioArrivo")
    @JsonDeserialize(using = ViaggiatrenoJsonDateDeserializer.class)
    private Date orarioArrivo;

    @JsonProperty("categoria")
    private String categoria;

    @JsonProperty("categoriaDescrizione")
    private String categoriaDescrizione;

    @JsonProperty("numeroTreno")
    private String numeroTreno;

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
     * Getter for property 'categoria'.
     *
     * @return Value for property 'categoria'.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Setter for property 'categoria'.
     *
     * @param categoria Value to set for property 'categoria'.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Getter for property 'categoriaDescrizione'.
     *
     * @return Value for property 'categoriaDescrizione'.
     */
    public String getCategoriaDescrizione() {
        return categoriaDescrizione;
    }

    /**
     * Setter for property 'categoriaDescrizione'.
     *
     * @param categoriaDescrizione Value to set for property 'categoriaDescrizione'.
     */
    public void setCategoriaDescrizione(String categoriaDescrizione) {
        this.categoriaDescrizione = categoriaDescrizione;
    }

    /**
     * Getter for property 'numeroTreno'.
     *
     * @return Value for property 'numeroTreno'.
     */
    public String getNumeroTreno() {
        return numeroTreno;
    }

    /**
     * Setter for property 'numeroTreno'.
     *
     * @param numeroTreno Value to set for property 'numeroTreno'.
     */
    public void setNumeroTreno(String numeroTreno) {
        this.numeroTreno = numeroTreno;
    }

    /**
     * Getter for property 'orarioPartenza'.
     *
     * @return Value for property 'orarioPartenza'.
     */
    public Date getOrarioPartenza() {
        return orarioPartenza;
    }

    /**
     * Setter for property 'orarioPartenza'.
     *
     * @param orarioPartenza Value to set for property 'orarioPartenza'.
     */
    public void setOrarioPartenza(Date orarioPartenza) {
        this.orarioPartenza = orarioPartenza;
    }

    /**
     * Getter for property 'orarioArrivo'.
     *
     * @return Value for property 'orarioArrivo'.
     */
    public Date getOrarioArrivo() {
        return orarioArrivo;
    }

    /**
     * Setter for property 'orarioArrivo'.
     *
     * @param orarioArrivo Value to set for property 'orarioArrivo'.
     */
    public void setOrarioArrivo(Date orarioArrivo) {
        this.orarioArrivo = orarioArrivo;
    }
}

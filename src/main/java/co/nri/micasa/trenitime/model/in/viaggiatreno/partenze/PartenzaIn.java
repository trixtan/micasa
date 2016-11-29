package co.nri.micasa.trenitime.model.in.viaggiatreno.partenze;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.nri.micasa.trenitime.model.in.viaggiatreno.soluzioniViaggioNew.Vehicle;

public class PartenzaIn {
    private Integer numeroTreno;
    private String categoria;
    private String categoriaDescrizione;
    private String origine;
    private String codOrigine;
    private String destinazione;
    private String codDestinazione;
    private String origineEstera;
    private String destinazioneEstera;
    private String oraPartenzaEstera;
    private String oraArrivoEstera;
    private Integer tratta;
    private Integer regione;
    private String origineZero;
    private String destinazioneZero;
    private String orarioPartenzaZero;
    private String orarioArrivoZero;
    private Boolean circolante;
    private Integer codiceCliente;
    private String binarioEffettivoArrivoCodice;
    private String binarioEffettivoArrivoDescrizione;
    private String binarioEffettivoArrivoTipo;
    private String binarioProgrammatoArrivoCodice;
    private String binarioProgrammatoArrivoDescrizione;
    private String binarioEffettivoPartenzaCodice;
    private String binarioEffettivoPartenzaDescrizione;
    private String binarioEffettivoPartenzaTipo;
    private String binarioProgrammatoPartenzaCodice;
    private String binarioProgrammatoPartenzaDescrizione;
    private String subTitle;
    private String esisteCorsaZero;
    private String orientamento;
    private Boolean inStazione;
    private Boolean haCambiNumero;
    private Boolean nonPartito;
    private Integer provvedimento;
    private String riprogrammazione;
    private Long orarioPartenza;
    private String orarioArrivo;
    private String stazionePartenza;
    private String stazioneArrivo;
    private String statoTreno;
    private String corrispondenze;
    private String servizi;
    private Integer ritardo;
    private String tipoProdotto;
    private String compOrarioPartenzaZeroEffettivo;
    private String compOrarioArrivoZeroEffettivo;
    private String compOrarioPartenzaZero;
    private String compOrarioArrivoZero;
    private String compOrarioArrivo;
    private String compOrarioPartenza;
    private String compNumeroTreno;
    private List<String> compOrientamento;
    private String compTipologiaTreno;
    private String compClassRitardoTxt;
    private String compClassRitardoLine;
    private String compImgRitardo2;
    private String compImgRitardo;
    private List<String> compRitardo;
    private List<String> compRitardoAndamento;
    private List<String> compInStazionePartenza;
    private List<String> compInStazioneArrivo;
    private String compOrarioEffettivoArrivo;
    private String compDurata;
    private String compImgCambiNumerazione;

    /**
     * Getter for property 'numeroTreno'.
     *
     * @return Value for property 'numeroTreno'.
     */
    public Integer getNumeroTreno() {
        return numeroTreno;
    }

    /**
     * Setter for property 'numeroTreno'.
     *
     * @param numeroTreno Value to set for property 'numeroTreno'.
     */
    public void setNumeroTreno(Integer numeroTreno) {
        this.numeroTreno = numeroTreno;
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
     * Getter for property 'codOrigine'.
     *
     * @return Value for property 'codOrigine'.
     */
    public String getCodOrigine() {
        return codOrigine;
    }

    /**
     * Setter for property 'codOrigine'.
     *
     * @param codOrigine Value to set for property 'codOrigine'.
     */
    public void setCodOrigine(String codOrigine) {
        this.codOrigine = codOrigine;
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
     * Getter for property 'codDestinazione'.
     *
     * @return Value for property 'codDestinazione'.
     */
    public String getCodDestinazione() {
        return codDestinazione;
    }

    /**
     * Setter for property 'codDestinazione'.
     *
     * @param codDestinazione Value to set for property 'codDestinazione'.
     */
    public void setCodDestinazione(String codDestinazione) {
        this.codDestinazione = codDestinazione;
    }

    /**
     * Getter for property 'origineEstera'.
     *
     * @return Value for property 'origineEstera'.
     */
    public String getOrigineEstera() {
        return origineEstera;
    }

    /**
     * Setter for property 'origineEstera'.
     *
     * @param origineEstera Value to set for property 'origineEstera'.
     */
    public void setOrigineEstera(String origineEstera) {
        this.origineEstera = origineEstera;
    }

    /**
     * Getter for property 'destinazioneEstera'.
     *
     * @return Value for property 'destinazioneEstera'.
     */
    public String getDestinazioneEstera() {
        return destinazioneEstera;
    }

    /**
     * Setter for property 'destinazioneEstera'.
     *
     * @param destinazioneEstera Value to set for property 'destinazioneEstera'.
     */
    public void setDestinazioneEstera(String destinazioneEstera) {
        this.destinazioneEstera = destinazioneEstera;
    }

    /**
     * Getter for property 'oraPartenzaEstera'.
     *
     * @return Value for property 'oraPartenzaEstera'.
     */
    public String getOraPartenzaEstera() {
        return oraPartenzaEstera;
    }

    /**
     * Setter for property 'oraPartenzaEstera'.
     *
     * @param oraPartenzaEstera Value to set for property 'oraPartenzaEstera'.
     */
    public void setOraPartenzaEstera(String oraPartenzaEstera) {
        this.oraPartenzaEstera = oraPartenzaEstera;
    }

    /**
     * Getter for property 'oraArrivoEstera'.
     *
     * @return Value for property 'oraArrivoEstera'.
     */
    public String getOraArrivoEstera() {
        return oraArrivoEstera;
    }

    /**
     * Setter for property 'oraArrivoEstera'.
     *
     * @param oraArrivoEstera Value to set for property 'oraArrivoEstera'.
     */
    public void setOraArrivoEstera(String oraArrivoEstera) {
        this.oraArrivoEstera = oraArrivoEstera;
    }

    /**
     * Getter for property 'tratta'.
     *
     * @return Value for property 'tratta'.
     */
    public Integer getTratta() {
        return tratta;
    }

    /**
     * Setter for property 'tratta'.
     *
     * @param tratta Value to set for property 'tratta'.
     */
    public void setTratta(Integer tratta) {
        this.tratta = tratta;
    }

    /**
     * Getter for property 'regione'.
     *
     * @return Value for property 'regione'.
     */
    public Integer getRegione() {
        return regione;
    }

    /**
     * Setter for property 'regione'.
     *
     * @param regione Value to set for property 'regione'.
     */
    public void setRegione(Integer regione) {
        this.regione = regione;
    }

    /**
     * Getter for property 'origineZero'.
     *
     * @return Value for property 'origineZero'.
     */
    public String getOrigineZero() {
        return origineZero;
    }

    /**
     * Setter for property 'origineZero'.
     *
     * @param origineZero Value to set for property 'origineZero'.
     */
    public void setOrigineZero(String origineZero) {
        this.origineZero = origineZero;
    }

    /**
     * Getter for property 'destinazioneZero'.
     *
     * @return Value for property 'destinazioneZero'.
     */
    public String getDestinazioneZero() {
        return destinazioneZero;
    }

    /**
     * Setter for property 'destinazioneZero'.
     *
     * @param destinazioneZero Value to set for property 'destinazioneZero'.
     */
    public void setDestinazioneZero(String destinazioneZero) {
        this.destinazioneZero = destinazioneZero;
    }

    /**
     * Getter for property 'orarioPartenzaZero'.
     *
     * @return Value for property 'orarioPartenzaZero'.
     */
    public String getOrarioPartenzaZero() {
        return orarioPartenzaZero;
    }

    /**
     * Setter for property 'orarioPartenzaZero'.
     *
     * @param orarioPartenzaZero Value to set for property 'orarioPartenzaZero'.
     */
    public void setOrarioPartenzaZero(String orarioPartenzaZero) {
        this.orarioPartenzaZero = orarioPartenzaZero;
    }

    /**
     * Getter for property 'orarioArrivoZero'.
     *
     * @return Value for property 'orarioArrivoZero'.
     */
    public String getOrarioArrivoZero() {
        return orarioArrivoZero;
    }

    /**
     * Setter for property 'orarioArrivoZero'.
     *
     * @param orarioArrivoZero Value to set for property 'orarioArrivoZero'.
     */
    public void setOrarioArrivoZero(String orarioArrivoZero) {
        this.orarioArrivoZero = orarioArrivoZero;
    }

    /**
     * Getter for property 'circolante'.
     *
     * @return Value for property 'circolante'.
     */
    public Boolean getCircolante() {
        return circolante;
    }

    /**
     * Setter for property 'circolante'.
     *
     * @param circolante Value to set for property 'circolante'.
     */
    public void setCircolante(Boolean circolante) {
        this.circolante = circolante;
    }

    /**
     * Getter for property 'codiceCliente'.
     *
     * @return Value for property 'codiceCliente'.
     */
    public Integer getCodiceCliente() {
        return codiceCliente;
    }

    /**
     * Setter for property 'codiceCliente'.
     *
     * @param codiceCliente Value to set for property 'codiceCliente'.
     */
    public void setCodiceCliente(Integer codiceCliente) {
        this.codiceCliente = codiceCliente;
    }

    /**
     * Getter for property 'binarioEffettivoArrivoCodice'.
     *
     * @return Value for property 'binarioEffettivoArrivoCodice'.
     */
    public String getBinarioEffettivoArrivoCodice() {
        return binarioEffettivoArrivoCodice;
    }

    /**
     * Setter for property 'binarioEffettivoArrivoCodice'.
     *
     * @param binarioEffettivoArrivoCodice Value to set for property 'binarioEffettivoArrivoCodice'.
     */
    public void setBinarioEffettivoArrivoCodice(String binarioEffettivoArrivoCodice) {
        this.binarioEffettivoArrivoCodice = binarioEffettivoArrivoCodice;
    }

    /**
     * Getter for property 'binarioEffettivoArrivoDescrizione'.
     *
     * @return Value for property 'binarioEffettivoArrivoDescrizione'.
     */
    public String getBinarioEffettivoArrivoDescrizione() {
        return binarioEffettivoArrivoDescrizione;
    }

    /**
     * Setter for property 'binarioEffettivoArrivoDescrizione'.
     *
     * @param binarioEffettivoArrivoDescrizione Value to set for property 'binarioEffettivoArrivoDescrizione'.
     */
    public void setBinarioEffettivoArrivoDescrizione(String binarioEffettivoArrivoDescrizione) {
        this.binarioEffettivoArrivoDescrizione = binarioEffettivoArrivoDescrizione;
    }

    /**
     * Getter for property 'binarioEffettivoArrivoTipo'.
     *
     * @return Value for property 'binarioEffettivoArrivoTipo'.
     */
    public String getBinarioEffettivoArrivoTipo() {
        return binarioEffettivoArrivoTipo;
    }

    /**
     * Setter for property 'binarioEffettivoArrivoTipo'.
     *
     * @param binarioEffettivoArrivoTipo Value to set for property 'binarioEffettivoArrivoTipo'.
     */
    public void setBinarioEffettivoArrivoTipo(String binarioEffettivoArrivoTipo) {
        this.binarioEffettivoArrivoTipo = binarioEffettivoArrivoTipo;
    }

    /**
     * Getter for property 'binarioProgrammatoArrivoCodice'.
     *
     * @return Value for property 'binarioProgrammatoArrivoCodice'.
     */
    public String getBinarioProgrammatoArrivoCodice() {
        return binarioProgrammatoArrivoCodice;
    }

    /**
     * Setter for property 'binarioProgrammatoArrivoCodice'.
     *
     * @param binarioProgrammatoArrivoCodice Value to set for property 'binarioProgrammatoArrivoCodice'.
     */
    public void setBinarioProgrammatoArrivoCodice(String binarioProgrammatoArrivoCodice) {
        this.binarioProgrammatoArrivoCodice = binarioProgrammatoArrivoCodice;
    }

    /**
     * Getter for property 'binarioProgrammatoArrivoDescrizione'.
     *
     * @return Value for property 'binarioProgrammatoArrivoDescrizione'.
     */
    public String getBinarioProgrammatoArrivoDescrizione() {
        return binarioProgrammatoArrivoDescrizione;
    }

    /**
     * Setter for property 'binarioProgrammatoArrivoDescrizione'.
     *
     * @param binarioProgrammatoArrivoDescrizione Value to set for property 'binarioProgrammatoArrivoDescrizione'.
     */
    public void setBinarioProgrammatoArrivoDescrizione(String binarioProgrammatoArrivoDescrizione) {
        this.binarioProgrammatoArrivoDescrizione = binarioProgrammatoArrivoDescrizione;
    }

    /**
     * Getter for property 'binarioEffettivoPartenzaCodice'.
     *
     * @return Value for property 'binarioEffettivoPartenzaCodice'.
     */
    public String getBinarioEffettivoPartenzaCodice() {
        return binarioEffettivoPartenzaCodice;
    }

    /**
     * Setter for property 'binarioEffettivoPartenzaCodice'.
     *
     * @param binarioEffettivoPartenzaCodice Value to set for property 'binarioEffettivoPartenzaCodice'.
     */
    public void setBinarioEffettivoPartenzaCodice(String binarioEffettivoPartenzaCodice) {
        this.binarioEffettivoPartenzaCodice = binarioEffettivoPartenzaCodice;
    }

    /**
     * Getter for property 'binarioEffettivoPartenzaDescrizione'.
     *
     * @return Value for property 'binarioEffettivoPartenzaDescrizione'.
     */
    public String getBinarioEffettivoPartenzaDescrizione() {
        return binarioEffettivoPartenzaDescrizione;
    }

    /**
     * Setter for property 'binarioEffettivoPartenzaDescrizione'.
     *
     * @param binarioEffettivoPartenzaDescrizione Value to set for property 'binarioEffettivoPartenzaDescrizione'.
     */
    public void setBinarioEffettivoPartenzaDescrizione(String binarioEffettivoPartenzaDescrizione) {
        this.binarioEffettivoPartenzaDescrizione = binarioEffettivoPartenzaDescrizione;
    }

    /**
     * Getter for property 'binarioEffettivoPartenzaTipo'.
     *
     * @return Value for property 'binarioEffettivoPartenzaTipo'.
     */
    public String getBinarioEffettivoPartenzaTipo() {
        return binarioEffettivoPartenzaTipo;
    }

    /**
     * Setter for property 'binarioEffettivoPartenzaTipo'.
     *
     * @param binarioEffettivoPartenzaTipo Value to set for property 'binarioEffettivoPartenzaTipo'.
     */
    public void setBinarioEffettivoPartenzaTipo(String binarioEffettivoPartenzaTipo) {
        this.binarioEffettivoPartenzaTipo = binarioEffettivoPartenzaTipo;
    }

    /**
     * Getter for property 'binarioProgrammatoPartenzaCodice'.
     *
     * @return Value for property 'binarioProgrammatoPartenzaCodice'.
     */
    public String getBinarioProgrammatoPartenzaCodice() {
        return binarioProgrammatoPartenzaCodice;
    }

    /**
     * Setter for property 'binarioProgrammatoPartenzaCodice'.
     *
     * @param binarioProgrammatoPartenzaCodice Value to set for property 'binarioProgrammatoPartenzaCodice'.
     */
    public void setBinarioProgrammatoPartenzaCodice(String binarioProgrammatoPartenzaCodice) {
        this.binarioProgrammatoPartenzaCodice = binarioProgrammatoPartenzaCodice;
    }

    /**
     * Getter for property 'binarioProgrammatoPartenzaDescrizione'.
     *
     * @return Value for property 'binarioProgrammatoPartenzaDescrizione'.
     */
    public String getBinarioProgrammatoPartenzaDescrizione() {
        return binarioProgrammatoPartenzaDescrizione;
    }

    /**
     * Setter for property 'binarioProgrammatoPartenzaDescrizione'.
     *
     * @param binarioProgrammatoPartenzaDescrizione Value to set for property 'binarioProgrammatoPartenzaDescrizione'.
     */
    public void setBinarioProgrammatoPartenzaDescrizione(String binarioProgrammatoPartenzaDescrizione) {
        this.binarioProgrammatoPartenzaDescrizione = binarioProgrammatoPartenzaDescrizione;
    }

    /**
     * Getter for property 'subTitle'.
     *
     * @return Value for property 'subTitle'.
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * Setter for property 'subTitle'.
     *
     * @param subTitle Value to set for property 'subTitle'.
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * Getter for property 'esisteCorsaZero'.
     *
     * @return Value for property 'esisteCorsaZero'.
     */
    public String getEsisteCorsaZero() {
        return esisteCorsaZero;
    }

    /**
     * Setter for property 'esisteCorsaZero'.
     *
     * @param esisteCorsaZero Value to set for property 'esisteCorsaZero'.
     */
    public void setEsisteCorsaZero(String esisteCorsaZero) {
        this.esisteCorsaZero = esisteCorsaZero;
    }

    /**
     * Getter for property 'orientamento'.
     *
     * @return Value for property 'orientamento'.
     */
    public String getOrientamento() {
        return orientamento;
    }

    /**
     * Setter for property 'orientamento'.
     *
     * @param orientamento Value to set for property 'orientamento'.
     */
    public void setOrientamento(String orientamento) {
        this.orientamento = orientamento;
    }

    /**
     * Getter for property 'inStazione'.
     *
     * @return Value for property 'inStazione'.
     */
    public Boolean getInStazione() {
        return inStazione;
    }

    /**
     * Setter for property 'inStazione'.
     *
     * @param inStazione Value to set for property 'inStazione'.
     */
    public void setInStazione(Boolean inStazione) {
        this.inStazione = inStazione;
    }

    /**
     * Getter for property 'haCambiNumero'.
     *
     * @return Value for property 'haCambiNumero'.
     */
    public Boolean getHaCambiNumero() {
        return haCambiNumero;
    }

    /**
     * Setter for property 'haCambiNumero'.
     *
     * @param haCambiNumero Value to set for property 'haCambiNumero'.
     */
    public void setHaCambiNumero(Boolean haCambiNumero) {
        this.haCambiNumero = haCambiNumero;
    }

    /**
     * Getter for property 'nonPartito'.
     *
     * @return Value for property 'nonPartito'.
     */
    public Boolean getNonPartito() {
        return nonPartito;
    }

    /**
     * Setter for property 'nonPartito'.
     *
     * @param nonPartito Value to set for property 'nonPartito'.
     */
    public void setNonPartito(Boolean nonPartito) {
        this.nonPartito = nonPartito;
    }

    /**
     * Getter for property 'provvedimento'.
     *
     * @return Value for property 'provvedimento'.
     */
    public Integer getProvvedimento() {
        return provvedimento;
    }

    /**
     * Setter for property 'provvedimento'.
     *
     * @param provvedimento Value to set for property 'provvedimento'.
     */
    public void setProvvedimento(Integer provvedimento) {
        this.provvedimento = provvedimento;
    }

    /**
     * Getter for property 'riprogrammazione'.
     *
     * @return Value for property 'riprogrammazione'.
     */
    public String getRiprogrammazione() {
        return riprogrammazione;
    }

    /**
     * Setter for property 'riprogrammazione'.
     *
     * @param riprogrammazione Value to set for property 'riprogrammazione'.
     */
    public void setRiprogrammazione(String riprogrammazione) {
        this.riprogrammazione = riprogrammazione;
    }

    /**
     * Getter for property 'orarioPartenza'.
     *
     * @return Value for property 'orarioPartenza'.
     */
    public Long getOrarioPartenza() {
        return orarioPartenza;
    }

    /**
     * Setter for property 'orarioPartenza'.
     *
     * @param orarioPartenza Value to set for property 'orarioPartenza'.
     */
    public void setOrarioPartenza(Long orarioPartenza) {
        this.orarioPartenza = orarioPartenza;
    }

    /**
     * Getter for property 'orarioArrivo'.
     *
     * @return Value for property 'orarioArrivo'.
     */
    public String getOrarioArrivo() {
        return orarioArrivo;
    }

    /**
     * Setter for property 'orarioArrivo'.
     *
     * @param orarioArrivo Value to set for property 'orarioArrivo'.
     */
    public void setOrarioArrivo(String orarioArrivo) {
        this.orarioArrivo = orarioArrivo;
    }

    /**
     * Getter for property 'stazionePartenza'.
     *
     * @return Value for property 'stazionePartenza'.
     */
    public String getStazionePartenza() {
        return stazionePartenza;
    }

    /**
     * Setter for property 'stazionePartenza'.
     *
     * @param stazionePartenza Value to set for property 'stazionePartenza'.
     */
    public void setStazionePartenza(String stazionePartenza) {
        this.stazionePartenza = stazionePartenza;
    }

    /**
     * Getter for property 'stazioneArrivo'.
     *
     * @return Value for property 'stazioneArrivo'.
     */
    public String getStazioneArrivo() {
        return stazioneArrivo;
    }

    /**
     * Setter for property 'stazioneArrivo'.
     *
     * @param stazioneArrivo Value to set for property 'stazioneArrivo'.
     */
    public void setStazioneArrivo(String stazioneArrivo) {
        this.stazioneArrivo = stazioneArrivo;
    }

    /**
     * Getter for property 'statoTreno'.
     *
     * @return Value for property 'statoTreno'.
     */
    public String getStatoTreno() {
        return statoTreno;
    }

    /**
     * Setter for property 'statoTreno'.
     *
     * @param statoTreno Value to set for property 'statoTreno'.
     */
    public void setStatoTreno(String statoTreno) {
        this.statoTreno = statoTreno;
    }

    /**
     * Getter for property 'corrispondenze'.
     *
     * @return Value for property 'corrispondenze'.
     */
    public String getCorrispondenze() {
        return corrispondenze;
    }

    /**
     * Setter for property 'corrispondenze'.
     *
     * @param corrispondenze Value to set for property 'corrispondenze'.
     */
    public void setCorrispondenze(String corrispondenze) {
        this.corrispondenze = corrispondenze;
    }

    /**
     * Getter for property 'servizi'.
     *
     * @return Value for property 'servizi'.
     */
    public String getServizi() {
        return servizi;
    }

    /**
     * Setter for property 'servizi'.
     *
     * @param servizi Value to set for property 'servizi'.
     */
    public void setServizi(String servizi) {
        this.servizi = servizi;
    }

    /**
     * Getter for property 'ritardo'.
     *
     * @return Value for property 'ritardo'.
     */
    public Integer getRitardo() {
        return ritardo;
    }

    /**
     * Setter for property 'ritardo'.
     *
     * @param ritardo Value to set for property 'ritardo'.
     */
    public void setRitardo(Integer ritardo) {
        this.ritardo = ritardo;
    }

    /**
     * Getter for property 'tipoProdotto'.
     *
     * @return Value for property 'tipoProdotto'.
     */
    public String getTipoProdotto() {
        return tipoProdotto;
    }

    /**
     * Setter for property 'tipoProdotto'.
     *
     * @param tipoProdotto Value to set for property 'tipoProdotto'.
     */
    public void setTipoProdotto(String tipoProdotto) {
        this.tipoProdotto = tipoProdotto;
    }

    /**
     * Getter for property 'compOrarioPartenzaZeroEffettivo'.
     *
     * @return Value for property 'compOrarioPartenzaZeroEffettivo'.
     */
    public String getCompOrarioPartenzaZeroEffettivo() {
        return compOrarioPartenzaZeroEffettivo;
    }

    /**
     * Setter for property 'compOrarioPartenzaZeroEffettivo'.
     *
     * @param compOrarioPartenzaZeroEffettivo Value to set for property 'compOrarioPartenzaZeroEffettivo'.
     */
    public void setCompOrarioPartenzaZeroEffettivo(String compOrarioPartenzaZeroEffettivo) {
        this.compOrarioPartenzaZeroEffettivo = compOrarioPartenzaZeroEffettivo;
    }

    /**
     * Getter for property 'compOrarioArrivoZeroEffettivo'.
     *
     * @return Value for property 'compOrarioArrivoZeroEffettivo'.
     */
    public String getCompOrarioArrivoZeroEffettivo() {
        return compOrarioArrivoZeroEffettivo;
    }

    /**
     * Setter for property 'compOrarioArrivoZeroEffettivo'.
     *
     * @param compOrarioArrivoZeroEffettivo Value to set for property 'compOrarioArrivoZeroEffettivo'.
     */
    public void setCompOrarioArrivoZeroEffettivo(String compOrarioArrivoZeroEffettivo) {
        this.compOrarioArrivoZeroEffettivo = compOrarioArrivoZeroEffettivo;
    }

    /**
     * Getter for property 'compOrarioPartenzaZero'.
     *
     * @return Value for property 'compOrarioPartenzaZero'.
     */
    public String getCompOrarioPartenzaZero() {
        return compOrarioPartenzaZero;
    }

    /**
     * Setter for property 'compOrarioPartenzaZero'.
     *
     * @param compOrarioPartenzaZero Value to set for property 'compOrarioPartenzaZero'.
     */
    public void setCompOrarioPartenzaZero(String compOrarioPartenzaZero) {
        this.compOrarioPartenzaZero = compOrarioPartenzaZero;
    }

    /**
     * Getter for property 'compOrarioArrivoZero'.
     *
     * @return Value for property 'compOrarioArrivoZero'.
     */
    public String getCompOrarioArrivoZero() {
        return compOrarioArrivoZero;
    }

    /**
     * Setter for property 'compOrarioArrivoZero'.
     *
     * @param compOrarioArrivoZero Value to set for property 'compOrarioArrivoZero'.
     */
    public void setCompOrarioArrivoZero(String compOrarioArrivoZero) {
        this.compOrarioArrivoZero = compOrarioArrivoZero;
    }

    /**
     * Getter for property 'compOrarioArrivo'.
     *
     * @return Value for property 'compOrarioArrivo'.
     */
    public String getCompOrarioArrivo() {
        return compOrarioArrivo;
    }

    /**
     * Setter for property 'compOrarioArrivo'.
     *
     * @param compOrarioArrivo Value to set for property 'compOrarioArrivo'.
     */
    public void setCompOrarioArrivo(String compOrarioArrivo) {
        this.compOrarioArrivo = compOrarioArrivo;
    }

    /**
     * Getter for property 'compOrarioPartenza'.
     *
     * @return Value for property 'compOrarioPartenza'.
     */
    public String getCompOrarioPartenza() {
        return compOrarioPartenza;
    }

    /**
     * Setter for property 'compOrarioPartenza'.
     *
     * @param compOrarioPartenza Value to set for property 'compOrarioPartenza'.
     */
    public void setCompOrarioPartenza(String compOrarioPartenza) {
        this.compOrarioPartenza = compOrarioPartenza;
    }

    /**
     * Getter for property 'compNumeroTreno'.
     *
     * @return Value for property 'compNumeroTreno'.
     */
    public String getCompNumeroTreno() {
        return compNumeroTreno;
    }

    /**
     * Setter for property 'compNumeroTreno'.
     *
     * @param compNumeroTreno Value to set for property 'compNumeroTreno'.
     */
    public void setCompNumeroTreno(String compNumeroTreno) {
        this.compNumeroTreno = compNumeroTreno;
    }

    /**
     * Getter for property 'compOrientamento'.
     *
     * @return Value for property 'compOrientamento'.
     */
    public List<String> getCompOrientamento() {
        return compOrientamento;
    }

    /**
     * Setter for property 'compOrientamento'.
     *
     * @param compOrientamento Value to set for property 'compOrientamento'.
     */
    public void setCompOrientamento(List<String> compOrientamento) {
        this.compOrientamento = compOrientamento;
    }

    /**
     * Getter for property 'compTipologiaTreno'.
     *
     * @return Value for property 'compTipologiaTreno'.
     */
    public String getCompTipologiaTreno() {
        return compTipologiaTreno;
    }

    /**
     * Setter for property 'compTipologiaTreno'.
     *
     * @param compTipologiaTreno Value to set for property 'compTipologiaTreno'.
     */
    public void setCompTipologiaTreno(String compTipologiaTreno) {
        this.compTipologiaTreno = compTipologiaTreno;
    }

    /**
     * Getter for property 'compClassRitardoTxt'.
     *
     * @return Value for property 'compClassRitardoTxt'.
     */
    public String getCompClassRitardoTxt() {
        return compClassRitardoTxt;
    }

    /**
     * Setter for property 'compClassRitardoTxt'.
     *
     * @param compClassRitardoTxt Value to set for property 'compClassRitardoTxt'.
     */
    public void setCompClassRitardoTxt(String compClassRitardoTxt) {
        this.compClassRitardoTxt = compClassRitardoTxt;
    }

    /**
     * Getter for property 'compClassRitardoLine'.
     *
     * @return Value for property 'compClassRitardoLine'.
     */
    public String getCompClassRitardoLine() {
        return compClassRitardoLine;
    }

    /**
     * Setter for property 'compClassRitardoLine'.
     *
     * @param compClassRitardoLine Value to set for property 'compClassRitardoLine'.
     */
    public void setCompClassRitardoLine(String compClassRitardoLine) {
        this.compClassRitardoLine = compClassRitardoLine;
    }

    /**
     * Getter for property 'compImgRitardo2'.
     *
     * @return Value for property 'compImgRitardo2'.
     */
    public String getCompImgRitardo2() {
        return compImgRitardo2;
    }

    /**
     * Setter for property 'compImgRitardo2'.
     *
     * @param compImgRitardo2 Value to set for property 'compImgRitardo2'.
     */
    public void setCompImgRitardo2(String compImgRitardo2) {
        this.compImgRitardo2 = compImgRitardo2;
    }

    /**
     * Getter for property 'compImgRitardo'.
     *
     * @return Value for property 'compImgRitardo'.
     */
    public String getCompImgRitardo() {
        return compImgRitardo;
    }

    /**
     * Setter for property 'compImgRitardo'.
     *
     * @param compImgRitardo Value to set for property 'compImgRitardo'.
     */
    public void setCompImgRitardo(String compImgRitardo) {
        this.compImgRitardo = compImgRitardo;
    }

    /**
     * Getter for property 'compRitardo'.
     *
     * @return Value for property 'compRitardo'.
     */
    public List<String> getCompRitardo() {
        return compRitardo;
    }

    /**
     * Setter for property 'compRitardo'.
     *
     * @param compRitardo Value to set for property 'compRitardo'.
     */
    public void setCompRitardo(List<String> compRitardo) {
        this.compRitardo = compRitardo;
    }

    /**
     * Getter for property 'compRitardoAndamento'.
     *
     * @return Value for property 'compRitardoAndamento'.
     */
    public List<String> getCompRitardoAndamento() {
        return compRitardoAndamento;
    }

    /**
     * Setter for property 'compRitardoAndamento'.
     *
     * @param compRitardoAndamento Value to set for property 'compRitardoAndamento'.
     */
    public void setCompRitardoAndamento(List<String> compRitardoAndamento) {
        this.compRitardoAndamento = compRitardoAndamento;
    }

    /**
     * Getter for property 'compInStazionePartenza'.
     *
     * @return Value for property 'compInStazionePartenza'.
     */
    public List<String> getCompInStazionePartenza() {
        return compInStazionePartenza;
    }

    /**
     * Setter for property 'compInStazionePartenza'.
     *
     * @param compInStazionePartenza Value to set for property 'compInStazionePartenza'.
     */
    public void setCompInStazionePartenza(List<String> compInStazionePartenza) {
        this.compInStazionePartenza = compInStazionePartenza;
    }

    /**
     * Getter for property 'compInStazioneArrivo'.
     *
     * @return Value for property 'compInStazioneArrivo'.
     */
    public List<String> getCompInStazioneArrivo() {
        return compInStazioneArrivo;
    }

    /**
     * Setter for property 'compInStazioneArrivo'.
     *
     * @param compInStazioneArrivo Value to set for property 'compInStazioneArrivo'.
     */
    public void setCompInStazioneArrivo(List<String> compInStazioneArrivo) {
        this.compInStazioneArrivo = compInStazioneArrivo;
    }

    /**
     * Getter for property 'compOrarioEffettivoArrivo'.
     *
     * @return Value for property 'compOrarioEffettivoArrivo'.
     */
    public String getCompOrarioEffettivoArrivo() {
        return compOrarioEffettivoArrivo;
    }

    /**
     * Setter for property 'compOrarioEffettivoArrivo'.
     *
     * @param compOrarioEffettivoArrivo Value to set for property 'compOrarioEffettivoArrivo'.
     */
    public void setCompOrarioEffettivoArrivo(String compOrarioEffettivoArrivo) {
        this.compOrarioEffettivoArrivo = compOrarioEffettivoArrivo;
    }

    /**
     * Getter for property 'compDurata'.
     *
     * @return Value for property 'compDurata'.
     */
    public String getCompDurata() {
        return compDurata;
    }

    /**
     * Setter for property 'compDurata'.
     *
     * @param compDurata Value to set for property 'compDurata'.
     */
    public void setCompDurata(String compDurata) {
        this.compDurata = compDurata;
    }

    /**
     * Getter for property 'compImgCambiNumerazione'.
     *
     * @return Value for property 'compImgCambiNumerazione'.
     */
    public String getCompImgCambiNumerazione() {
        return compImgCambiNumerazione;
    }

    /**
     * Setter for property 'compImgCambiNumerazione'.
     *
     * @param compImgCambiNumerazione Value to set for property 'compImgCambiNumerazione'.
     */
    public void setCompImgCambiNumerazione(String compImgCambiNumerazione) {
        this.compImgCambiNumerazione = compImgCambiNumerazione;
    }

    /*
                "numeroTreno": 20690,
            "categoria": "REG",
            "categoriaDescrizione": null,
            "origine": null,
            "codOrigine": "S05706",
            "destinazione": "VENEZIA SANTA LUCIA",
            "codDestinazione": null,
            "origineEstera": null,
            "destinazioneEstera": null,
            "oraPartenzaEstera": null,
            "oraArrivoEstera": null,
            "tratta": 0,
            "regione": 0,
            "origineZero": null,
            "destinazioneZero": null,
            "orarioPartenzaZero": null,
            "orarioArrivoZero": null,
            "circolante": true,
            "codiceCliente": 2,
            "binarioEffettivoArrivoCodice": null,
            "binarioEffettivoArrivoDescrizione": null,
            "binarioEffettivoArrivoTipo": null,
            "binarioProgrammatoArrivoCodice": null,
            "binarioProgrammatoArrivoDescrizione": null,
            "binarioEffettivoPartenzaCodice": "0",
            "binarioEffettivoPartenzaDescrizione": "1",
            "binarioEffettivoPartenzaTipo": "0",
            "binarioProgrammatoPartenzaCodice": null,
            "binarioProgrammatoPartenzaDescrizione": null,
            "subTitle": null,
            "esisteCorsaZero": null,
            "orientamento": "",
            "inStazione": true,
            "haCambiNumero": false,
            "nonPartito": false,
            "provvedimento": 0,
            "riprogrammazione": "N",
            "orarioPartenza": 1453734600000,
            "orarioArrivo": null,
            "stazionePartenza": null,
            "stazioneArrivo": null,
            "statoTreno": null,
            "corrispondenze": null,
            "servizi": null,
            "ritardo": 9,
            "tipoProdotto": "",
            "compOrarioPartenzaZeroEffettivo": "16:10",
            "compOrarioArrivoZeroEffettivo": null,
            "compOrarioPartenzaZero": "16:10",
            "compOrarioArrivoZero": null,
            "compOrarioArrivo": null,
            "compOrarioPartenza": "16:10",
            "compNumeroTreno": "REG 20690",
            "compOrientamento": [
            "--",
            "--",
            "--",
            "--",
            "--",
            "--",
            "--",
            "--",
            "--"
            ],
            "compTipologiaTreno": "regionale",
            "compClassRitardoTxt": "ritardo01_txt",
            "compClassRitardoLine": "ritardo01_line",
            "compImgRitardo2": "/vt_static/img/legenda/icone_legenda/ritardo01.png",
            "compImgRitardo": "/vt_static/img/legenda/icone_legenda/ritardo01.png",
            "compRitardo": [
            "ritardo 9 min.",
            "delay 9 min.",
            "Versp&#228;tung 9 Min.",
            "retard de 9 min.",
            "retraso de 9 min.",
            "&icirc;nt&acirc;rziere 9 min.",
            "遅延 9 分",
            "误点 9分钟",
            "опоздание на 9 минут"
            ],
            "compRitardoAndamento": [
            "con un ritardo di 9 min.",
            "9 minutes late",
            "mit einer Verz&#246;gerung von 9 Min.",
            "avec un retard de 9 min.",
            "con un retraso de 9 min.",
            "cu o &icirc;nt&acirc;rziere de 9 min.",
            "9 分の遅延",
            "误点 9分钟",
            "с опозданием в 9 минут"
            ],
            "compInStazionePartenza": [
            "Partito",
            "Departed",
            "angef&#228;hrt",
            "Partit",
            "Salido",
            "Plecat",
            "発車済",
            "已出发",
            "отправленный"
            ],
            "compInStazioneArrivo": [
            "Arrivato",
            "Arrived",
            "angekommen",
            "Arriv&eacute;",
            "Llegado",
            "Sosit",
            "到着済",
            "已到达",
            "прибывший"
            ],
            "compOrarioEffettivoArrivo": null,
            "compDurata": "",
            "compImgCambiNumerazione": "&nbsp;&nbsp;"
},*/
}

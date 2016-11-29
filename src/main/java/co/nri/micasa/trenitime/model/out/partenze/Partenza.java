
package co.nri.micasa.trenitime.model.out.partenze;

import java.io.Serializable;

public class Partenza implements Serializable {

    private String numeroTreno;
    private String categoriaTreno;
    private Long orarioPartenza;

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
     * Getter for property 'categoriaTreno'.
     *
     * @return Value for property 'categoriaTreno'.
     */
    public String getCategoriaTreno() {
        return categoriaTreno;
    }

    /**
     * Setter for property 'categoriaTreno'.
     *
     * @param categoriaTreno Value to set for property 'categoriaTreno'.
     */
    public void setCategoriaTreno(String categoriaTreno) {
        this.categoriaTreno = categoriaTreno;
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

    @Override
    public String toString() {
        return new StringBuilder().append("numeroTreno: ").append(this.numeroTreno)
        .append("categoriaTreno: ").append(this.categoriaTreno)
        .append("orarioPartenza: ").append(this.orarioPartenza).toString();
    }
}

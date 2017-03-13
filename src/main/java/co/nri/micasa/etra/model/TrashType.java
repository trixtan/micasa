package co.nri.micasa.etra.model;

public enum TrashType {
    UMIDO,
        SECCO,
        VERDE_E_RAMAGLIE,
        PLASTICA,
        VETRO,
        CARTA_E_CARTONE;
                
        public static TrashType fromDescription(String description) {
            switch(description){
                case "Umido":
                    return UMIDO;
                case "Secco":
                    return SECCO;
                case "Verde e ramaglie":
                    return VERDE_E_RAMAGLIE;
                case "Plastica":
                    return PLASTICA;
                case "Vetro":
                    return VETRO;
                case "Carta e cartone":
                    return CARTA_E_CARTONE;
                default:
                    return null;
            }
        }
}

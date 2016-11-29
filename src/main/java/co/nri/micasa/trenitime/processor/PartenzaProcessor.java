package co.nri.micasa.trenitime.processor;


import org.springframework.batch.item.ItemProcessor;

import co.nri.micasa.trenitime.model.in.viaggiatreno.partenze.PartenzaIn;

public class PartenzaProcessor implements ItemProcessor<PartenzaIn, co.nri.micasa.trenitime.model.out.partenze.Partenza>{

    @Override
    public co.nri.micasa.trenitime.model.out.partenze.Partenza process(PartenzaIn item) throws Exception {
        co.nri.micasa.trenitime.model.out.partenze.Partenza partenza = new co.nri.micasa.trenitime.model.out.partenze.Partenza();
        partenza.setCategoriaTreno(item.getCategoria());
        partenza.setNumeroTreno(Integer.toString(item.getNumeroTreno()));
        partenza.setOrarioPartenza(item.getOrarioPartenza());
        return partenza;
    }
}

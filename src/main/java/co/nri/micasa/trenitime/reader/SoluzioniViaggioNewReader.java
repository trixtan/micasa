
package co.nri.micasa.trenitime.reader;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Value;

import co.nri.micasa.trenitime.model.in.viaggiatreno.partenze.PartenzaIn;

public class SoluzioniViaggioNewReader implements ItemReader<PartenzaIn> {

    private static final Logger LOG = LoggerFactory.getLogger(SoluzioniViaggioNewReader.class);



    @Value("${trenitime.fromStation}")
    private String fromStation;

    @Value("${trenitime.toStation}")
    private String toStation;

    private Iterator<PartenzaIn> partenze;

    @Override
    public PartenzaIn read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(this.partenze == null) {
            getPartenze();
        }
        if(this.partenze!= null && this.partenze.hasNext()) {
            return this.partenze.next();
        } else {
            return null;
        }
    }
}

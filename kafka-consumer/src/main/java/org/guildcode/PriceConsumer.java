package org.guildcode;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class PriceConsumer {

    @Incoming("prices")
    public CompletionStage<Void> consume(Message<Price> priceIn) {

        System.out.println("########## INCOMING ##########");
        System.out.println(priceIn.getPayload());
        System.out.println("##############################");
        return priceIn.ack();
    }
}

package org.guildcode;

import io.smallrye.mutiny.operators.multi.processors.BroadcastProcessor;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class PriceConsumer {

    private static final double CONVERSION_RATE = 0.88;
    private static final BroadcastProcessor<Double> BROADCASTER = BroadcastProcessor.create();

//    @Incoming("prices")
//    public void consume(Price priceIn) {
//        System.out.println("########## INCOMING ##########");
//        System.out.println(priceIn);
//        System.out.println("##############################");
////        return priceIn.ack();
//    }

//    public Multi<Double> priceConverterEvent(final Integer value) {
//        if(value != null) {
//            BROADCASTER.onNext(process(value));
//        }
//        return BROADCASTER;
//    };
}

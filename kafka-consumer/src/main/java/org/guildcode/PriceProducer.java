package org.guildcode;

import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.Duration;
import java.util.Random;

@ApplicationScoped
public class PriceProducer {

    @Inject
    @Channel("generated-price")
    Emitter<Price> emitterPrice;

    private Random random = new Random();

    public void produce() {
        Multi.createFrom().ticks().every(Duration.ofSeconds(5))
                .onOverflow().drop()
                .map(tick -> random.nextDouble())
                .subscribe().with((data) -> {
            System.out.println("############## PRODUCE ################");
            System.out.println("Generated value => " + data);
            System.out.println("#######################################");
            emitterPrice.send(new Price(data));
        });
    }


//    void onStart(@Observes StartupEvent ev) {
//        this.produce();
//    }
}

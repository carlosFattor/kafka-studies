package org.guildcode;

import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.kafka.KafkaRecord;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.Duration;
import java.util.Random;
import java.util.UUID;

@ApplicationScoped
public class PriceProducer {

    @Inject
    @Channel("generated-price")
    Emitter<Price> emitterPrice;

    private Random random = new Random();

    public void produce() {
        Multi.createFrom().ticks().every(Duration.ofSeconds(1L))
                .onOverflow().drop()
                .map(tick -> random.nextDouble())
                .subscribe().with((data) -> {
            System.out.println("############## PRODUCE ################");
            System.out.println("Generated value => " + data);
            System.out.println("#######################################");
            emitterPrice.send(KafkaRecord.of(UUID.randomUUID().toString(), new Price(data)));
        });
    }


    void onStart(@Observes StartupEvent ev) {
        this.produce();
    }
}

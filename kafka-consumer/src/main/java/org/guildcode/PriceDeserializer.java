package org.guildcode;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class PriceDeserializer extends ObjectMapperDeserializer<Price> {
    public PriceDeserializer() {
        super(Price.class);
    }
}

package org.apache.flink.playgrounds.ops.clickcount.dbchanges;

import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import java.io.IOException;

import io.debezium.serde.DebeziumSerdes;

/**
 * A Kafka {@link DeserializationSchema} to deserialize {@link DbChange}s from JSON.
 */
public class DbChangeDeserializationSchema implements DeserializationSchema<DbChange> {

    private static final long serialVersionUID = 1L;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final Deserializer<Customer> deserializer = DebeziumSerdes.payloadJson(Customer.class).deserializer();

    @Override
    public DbChange deserialize(byte[] message) throws IOException {
        //return deserializer.deserialize()
        return objectMapper.readValue(message, DbChange.class);
    }

    @Override
    public boolean isEndOfStream(DbChange nextElement) {
        return false;
    }

    @Override
    public TypeInformation<DbChange> getProducedType() {
        return TypeInformation.of(DbChange.class);
    }
}

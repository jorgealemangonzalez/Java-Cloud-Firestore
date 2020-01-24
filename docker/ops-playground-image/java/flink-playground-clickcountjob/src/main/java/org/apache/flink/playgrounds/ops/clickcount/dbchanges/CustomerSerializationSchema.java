package org.apache.flink.playgrounds.ops.clickcount.dbchanges;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.streaming.connectors.kafka.KafkaSerializationSchema;
import org.apache.kafka.clients.producer.ProducerRecord;
import javax.annotation.Nullable;

/**
 * A Kafka {@link KafkaSerializationSchema} to serialize {@link Customer}s as JSON.
 */
public class CustomerSerializationSchema implements KafkaSerializationSchema<Customer> {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private String topic;

    public CustomerSerializationSchema(String topic) {
        this.topic = topic;
    }

    @Override
    public ProducerRecord<byte[], byte[]> serialize(
        final Customer message, @Nullable final Long timestamp) {
        try {
            //if topic is null, default topic will be used
            return new ProducerRecord<>(topic, objectMapper.writeValueAsBytes(message));
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Could not serialize record: " + message, e);
        }
    }
}

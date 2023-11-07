package functions;

import com.google.cloud.functions.CloudEventsFunction;
import com.google.events.cloud.firestore.v1.DocumentEventData;
import com.google.protobuf.InvalidProtocolBufferException;
import io.cloudevents.CloudEvent;
import java.util.logging.Logger;

public class FirestoreFunction implements CloudEventsFunction {
  private static final Logger logger = Logger.getLogger(FirestoreFunction.class.getName());

  @Override
  public void accept(CloudEvent event) throws InvalidProtocolBufferException {
    DocumentEventData firestorEventData = DocumentEventData.parseFrom(event.getData().toBytes());

    logger.info("Function triggered by event on: " + event.getSource());
    logger.info("Event type: " + event.getType());

    logger.info("Old value:");
    logger.info(firestorEventData.getOldValue().toString());

    logger.info("New value:");
    logger.info(firestorEventData.getValue().toString());
  }
}

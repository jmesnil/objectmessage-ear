package org.jboss.as.quickstarts.mdb;

import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;


/**
 * <p>
 * A simple Message Driven Bean that asynchronously receives and processes the
 * messages that are sent to the queue.
 * </p>
 * 
 * @author Serge Pagop (spagop@redhat.com)
 * 
 */
@MessageDriven(name = "HelloWorldMDB", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/myQueue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class HelloWorldMDB implements MessageListener {

	private final static Logger LOGGER = Logger.getLogger(HelloWorldMDB.class
			.toString());

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message rcvMessage) {
	    ObjectMessage msg = null;
		try {
			if (rcvMessage instanceof ObjectMessage) {
				msg = (ObjectMessage) rcvMessage;
				LOGGER.info("Received Message: " + msg.getObject());
			} else {
				LOGGER.warning("Message of wrong type: "
						+ rcvMessage.getClass().getName());
			}
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}
}

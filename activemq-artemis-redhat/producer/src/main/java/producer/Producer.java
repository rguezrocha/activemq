package Producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

import org.apache.activemq.artemis.api.core.Message;

public class Producer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		InitialContext initialContext = null;
		try {
			// Step 1. Create an initial context to perform the JNDI lookup.
			initialContext = new InitialContext();

			// Step 2. Perform a lookup on the queue
			Queue queue = (Queue) initialContext.lookup("queue/exampleQueue");

			// Step 3. Perform a lookup on the Connection Factory
			ConnectionFactory cf = (ConnectionFactory) initialContext.lookup("ConnectionFactory");

			// Step 4.createConnection connection
			connection = cf.createConnection("amq", "broker");

			// Step 5. Create a JMS Session session
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Step 6. Create a JMS MessageProducer producer
			MessageProducer producer = session.createProducer(queue);

			// Step 7. Create a TextMessage message
			TextMessage message = session.createTextMessage("This is a text message");
			message.setStringProperty(Message.HDR_DUPLICATE_DETECTION_ID.toString(), "UNIQUEID");

			System.out.println("Sent 2 messages with the same ID: " + message.getText());

			// Step 8. Send the same message twice
			producer.send(message);
			producer.send(message);

			// Step 9. Start the Connection
			connection.start();

		} finally {
			// Step 10. Be sure to close our JMS resources!
			if (initialContext != null) {
				initialContext.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}

}

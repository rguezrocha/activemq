package Consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

import org.apache.activemq.artemis.api.core.Message;

public class Consumer {

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

			// Step 9. Create a JMS Message Consumer
			MessageConsumer messageConsumer = session.createConsumer(queue);

			// Step 10. Start the Connection
			connection.start();

			// Step 11. Receive the message
			TextMessage messageReceived = (TextMessage) messageConsumer.receive(5000);

			System.out.println("Received message: " + messageReceived.getText());

			// Step 11. Receive the non existant second message
			TextMessage messageReceived2 = (TextMessage) messageConsumer.receive(5000);

			// Step 12. Check the second message could not be received
			if (messageReceived2 == null) {
				System.out.println(
						"Second message discarded by the Broker as expected, message successfully delivered just once.");
			} else {
				System.out.println("Received message 2: " + messageReceived2.getText());
			}

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

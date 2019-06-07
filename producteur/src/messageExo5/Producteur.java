package messageExo5;

import javax.jms.*;
import javax.naming.InitialContext;


public class Producteur {

    public static void main(String[] args) {
    ConnectionFactory connectionFactory=null;
    Queue queue=null;
    
        Connection connection = null;
        Session session = null;
        MessageProducer messageProducer = null;
        TextMessage message = null;        
        final int NUM_MSGS = 3;

        try {
				InitialContext ctx = new InitialContext();		
				connectionFactory = (ConnectionFactory) ctx.lookup("UneConnectionFactoryExo5");
				queue = (Queue) ctx.lookup("uneBALExo5");
			}
		catch (Exception ex) {
				System.err.println("erreur dans le lookup");
				ex.printStackTrace();
			}
        try {
				connection = connectionFactory.createConnection();
				session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				messageProducer = session.createProducer(queue);
				message = session.createTextMessage();

				for (int i = 0; i < NUM_MSGS; i++) {
					message.setText("This is messageExo5 " + (i + 1));
					System.out.println("Sending messageExo5: " + message.getText());
					messageProducer.send(message);
				}	
				
				connection.close();
				System.exit(0);
			} 
			catch (JMSException e) {
					System.out.println("Exception occurred: " + e.toString());
				}
    } // main
} // class

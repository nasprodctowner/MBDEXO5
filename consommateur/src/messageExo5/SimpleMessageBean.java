package messageExo5;
import javax.ejb.*;
import javax.jms.*;

@MessageDriven(mappedName = "uneBALExo5")
public class SimpleMessageBean implements MessageListener {

    public SimpleMessageBean() {
    }

    @EJB private convertItfLocale c;

    public void onMessage(Message inMessage) {
        TextMessage msg = null;

        try {
            if (inMessage instanceof TextMessage) {
                msg = (TextMessage) inMessage;

                System.out.println("Message recu: " + msg.getText()+" Dollar to euro : "+c.dollarToEuro(1));
            } else {
                System.out.println("Message of wrong type: " + inMessage.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }
}

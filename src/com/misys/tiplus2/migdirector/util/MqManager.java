/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ibm.jms.JMSTextMessage;
import com.ibm.mq.jms.JMSC;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueSender;
import com.ibm.mq.jms.MQQueueSession;
import javax.jms.Session;

/**
 *
 * @author falmarez
 */
public class MqManager {
    
    private String machine="";
    private int port=0;
    private String queueName="";
    private String queueManager="";
    private String channel="";
    
    public MqManager(){
    
    }
    
    public MqManager(String machine, int port, String queueName, String queueManager, String channel){
        
        this.machine=machine;
        this.port=port;
        this.queueName=queueName;
        this.queueManager=queueManager;
        this.channel=channel;
    
    }
    
    public void send(String messageArg){
        
        try {
            
          MQQueueConnectionFactory cf = new MQQueueConnectionFactory();

          // Config
          cf.setHostName(this.getMachine());
          cf.setPort(this.port);
          cf.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
          cf.setQueueManager(this.queueManager);
          cf.setChannel(this.channel);
  

          MQQueueConnection mqConn = (MQQueueConnection) cf.createQueueConnection();
          MQQueueSession mqSession = (MQQueueSession) mqConn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
          MQQueue mqQueue = (MQQueue) mqSession.createQueue(this.queueName);
          MQQueueSender mqSender =  (MQQueueSender) mqSession.createSender(mqQueue);

          JMSTextMessage jmsMessage = (JMSTextMessage) mqSession.createTextMessage(messageArg);     

          // Start the mqConn
          mqConn.start();

          mqSender.send(jmsMessage);
          
          mqSender.close();
          mqSession.close();
          mqConn.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
      }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getQueueManager() {
        return queueManager;
    }

    public void setQueueManager(String queueManager) {
        this.queueManager = queueManager;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
    
    
}

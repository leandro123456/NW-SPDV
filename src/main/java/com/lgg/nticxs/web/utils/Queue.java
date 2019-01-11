package com.lgg.nticxs.web.utils;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Queue {
	private static Queue instance = null;
    private Connection connection;
    private Channel channel;
    
    public Queue() {
    	try {
			//createRabittMQ();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
	public static Queue getInstance() {
		if (instance == null) {
			instance = new Queue();
		}
		return instance;
	}
    
//	private void createRabittMQ() throws Exception {
//		ConnectionFactory factory = new ConnectionFactory();
//		factory.setUsername("leandro");
//		factory.setPassword("lguzman");
//	    factory.setHost("localhost");
//	    connection = factory.newConnection();
//	    channel = connection.createChannel();
//	    channel.queueDeclare(Settings.getInstance().getQueueName(),  false, false, false, null);
//	}
	
	
	public void send(String queueName, String message) throws IOException {
		channel.basicPublish("", queueName, null, message.getBytes());
	}
	
}

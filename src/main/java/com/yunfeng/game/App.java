package com.yunfeng.game;

import org.hibernate.SessionFactory;

import com.yunfeng.game.transfer.Server;
import com.yunfeng.game.util.Client;
import com.yunfeng.game.util.HibernateUtil;
import com.yunfeng.game.util.Runner;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		sessionFactory.close();

		Runner.runExample(Server.class);

		for (int i = 0; i < 100; i++) {
			Runner.runExample(Client.class);
		}
	}
}

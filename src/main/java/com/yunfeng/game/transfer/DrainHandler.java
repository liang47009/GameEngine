package com.yunfeng.game.transfer;

import io.vertx.core.Handler;
import io.vertx.core.net.NetSocket;

import com.yunfeng.game.util.Log;

public class DrainHandler implements Handler<Void> {

	private NetSocket sock;
	private Server server;

	public DrainHandler(NetSocket sock) {
		// TODO Auto-generated constructor stub
		this.sock = sock;
	}

	public DrainHandler(Server server, NetSocket sock) {
		// TODO Auto-generated constructor stub
		this.sock = sock;
		this.server = server;
	}

	@Override
	public void handle(Void event) {
		// TODO Auto-generated method stub
//		Log.d("drain event: " + sock.writeHandlerID());
	}

}

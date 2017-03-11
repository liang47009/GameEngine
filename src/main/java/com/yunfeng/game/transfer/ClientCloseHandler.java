package com.yunfeng.game.transfer;

import io.vertx.core.Handler;
import io.vertx.core.net.NetSocket;

/**
 * 客户端关闭处理器
 * 
 * @author XIAYUNFENG
 *
 */
public final class ClientCloseHandler implements Handler<Void> {

	private Server server;
	private NetSocket sock;

	public ClientCloseHandler(NetSocket sock) {
		// TODO Auto-generated constructor stub
		this.sock = sock;
	}

	public ClientCloseHandler(Server server, NetSocket sock) {
		// TODO Auto-generated constructor stub
		this.server = server;
		this.sock = sock;
	}

	@Override
	public void handle(Void event) {
		// TODO Auto-generated method stub
		// Log.d("client closed!" + sock.writeHandlerID());
		this.server.leave(sock);
	}
}

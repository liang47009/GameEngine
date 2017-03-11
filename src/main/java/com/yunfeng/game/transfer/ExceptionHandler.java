package com.yunfeng.game.transfer;

import com.yunfeng.game.util.Log;

import io.vertx.core.Handler;
import io.vertx.core.net.NetSocket;

/**
 * 服务器错误处理器
 * 
 * @author XIAYUNFENG
 *
 */
public class ExceptionHandler implements Handler<Throwable> {

	private NetSocket sock;
	private Server server;

	public ExceptionHandler(NetSocket sock) {
		// TODO Auto-generated constructor stub
		this.sock = sock;
	}

	public ExceptionHandler(Server server, NetSocket sock) {
		// TODO Auto-generated constructor stub
		this.server = server;
		this.sock = sock;
	}

	@Override
	public void handle(Throwable event) {
		// TODO Auto-generated method stub
		Log.i("Exception:" + event.getCause() + ", " + sock.writeHandlerID());
	}

}

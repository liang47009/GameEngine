package com.yunfeng.game.transfer;

import com.yunfeng.game.util.Log;

import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetSocket;

/**
 * 客户端数据接收处理器
 * 
 * @author XIAYUNFENG
 *
 */
public final class ServerRecvHandler implements Handler<Buffer> {

	private NetSocket sock;
	private Server server;

	public ServerRecvHandler(NetSocket sock) {
		// TODO Auto-generated constructor stub
		this.sock = sock;
	}

	public ServerRecvHandler(Server server, NetSocket sock) {
		// TODO Auto-generated constructor stub
		this.sock = sock;
		this.server = server;
	}

	@Override
	public void handle(Buffer buffer) {
		// TODO Auto-generated method stub
		// Log.d("server recv data:" + buffer.length());
		// sock.write("ok");
		// server.broadcase(new String(buffer.getBytes()));
		int length = buffer.getInt(0);
		if (length > 0) {
			byte module = buffer.getByte(4);
			if (module > 0) {
				Buffer data = Buffer.buffer().appendBuffer(buffer, 5, buffer.length() - 5);
				server.sendToModule(module, data);
			}
		} else {
			Log.d("length error");
		}
	}
}

package com.yunfeng.game.transfer;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetSocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.yunfeng.game.module.IModule;
import com.yunfeng.game.module.ModuleManager;
import com.yunfeng.game.util.Log;

/**
 * 服务器处理入口类
 * 
 * @author XIAYUNFENG
 *
 */
public class Server extends AbstractVerticle {

	private ModuleManager moduleManager = new ModuleManager();
	private Map<String, NetSocket> sockets = new ConcurrentHashMap<String, NetSocket>();
	private Map<Byte, IModule> modules = new ConcurrentHashMap<Byte, IModule>();

	@Override
	public void start() throws Exception {
		Handler<NetSocket> handler = new Handler<NetSocket>() {

			@Override
			public void handle(NetSocket sock) {
				// Create a pump
				// Pump.pump(sock, sock).start();
				sock.handler(new ServerRecvHandler(Server.this, sock));
				sock.drainHandler(new DrainHandler(Server.this, sock));
				sock.closeHandler(new ClientCloseHandler(Server.this, sock));
				sock.exceptionHandler(new ExceptionHandler(Server.this, sock));

				sockets.put(sock.writeHandlerID(), sock);
				broadcase(sock.writeHandlerID() + " has join!");
				// Log.d("after join user num:" + sockets.size());
			}
		};

		vertx.createNetServer().connectHandler(handler)
				.listen(8888, "localhost");
		moduleManager.init(this);
	}

	public void leave(NetSocket sock) {
		sockets.remove(sock.writeHandlerID());
		broadcase(sock.writeHandlerID() + " has left!");
		// Log.d("after left user num:" + sockets.size());
	}

	public void broadcase(String msg) {
		for (NetSocket sock : sockets.values()) {
			sock.write(msg);
		}
	}

	public IModule registerModule(byte moduleid, IModule module) {
		return modules.put(moduleid, module);
	}

	public IModule unRegisterModule(byte moduleid) {
		return modules.remove(moduleid);
	}

	public void sendToModule(byte moduleid, Buffer data) {
		// TODO Auto-generated method stub
		IModule module = modules.get(moduleid);
		if (module != null) {
			module.handle(data);
		} else {
			Log.e("module with id: " + moduleid + " is not exist!");
		}
	}
}

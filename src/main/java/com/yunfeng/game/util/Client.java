package com.yunfeng.game.util;

import java.util.Timer;
import java.util.TimerTask;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetSocket;

/**
 * 模拟客户端类
 * 
 * @author XIAYUNFENG
 *
 */
public class Client extends AbstractVerticle {

	@Override
	public void start() throws Exception {
		Handler<AsyncResult<NetSocket>> handler = new Handler<AsyncResult<NetSocket>>() {
			@Override
			public void handle(AsyncResult<NetSocket> res) {
				// TODO Auto-generated method stub
				if (res.succeeded()) {
					NetSocket socket = res.result();
					socket.handler(new Handler<Buffer>() {

						@Override
						public void handle(Buffer buffer) {
							// TODO Auto-generated method stub
							Log.d("client recv:" + new String(buffer.getBytes()));
						}
					});
					new Timer().schedule(new TimerTask() {
						@Override
						public void run() {
							String str = "hello everyone!";
							Buffer buffer = Buffer.buffer();
							buffer.appendByte((byte) 1);// module
							buffer.appendByte((byte) 1);// pid
							buffer.appendByte((byte) 0);// subpid

							byte[] bytes = str.getBytes();
							buffer.appendInt(bytes.length);
							buffer.appendBytes(bytes);

							Buffer temp = Buffer.buffer();
							temp.appendInt(buffer.length());
							temp.appendBuffer(buffer);

							socket.write(temp);
							socket.end();
						}
					}, 2000, 2000);
				} else {
					Log.d("Failed to connect " + res.cause());
				}
			}
		};
		vertx.createNetClient().connect(8888, "localhost", handler);
	}
}
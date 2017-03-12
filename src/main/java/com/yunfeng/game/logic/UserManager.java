package com.yunfeng.game.logic;

import com.yunfeng.game.transfer.BufferReader;
import com.yunfeng.game.util.Log;

import io.vertx.core.buffer.Buffer;

public class UserManager implements ILogicManager {

	private static final byte SUBPID_HELLO_WORLD = 0;
	private static final byte SUBPID_LOGIN = 1;

	@Override
	public void execute(Buffer data) {
		// TODO Auto-generated method stub
		byte subpid = data.getByte(0);
		switch (subpid) {
		case SUBPID_HELLO_WORLD:
			helloWorld(data);
			break;
		case SUBPID_LOGIN:
			login(data);
			break;
		}
	}

	private void login(Buffer data) {
		// TODO Auto-generated method stub
		
	}

	private void helloWorld(Buffer data) {
		// TODO Auto-generated method stub
		String msg = BufferReader.readString(data, 1);
		Log.t(msg);
	}

}

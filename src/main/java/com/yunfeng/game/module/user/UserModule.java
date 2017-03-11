package com.yunfeng.game.module.user;

import io.vertx.core.buffer.Buffer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.yunfeng.game.logic.ILogicManager;
import com.yunfeng.game.logic.UserManager;
import com.yunfeng.game.module.IModule;
import com.yunfeng.game.transfer.BufferReader;
import com.yunfeng.game.util.Log;

public class UserModule implements IModule {

	private Map<Byte, ILogicManager> logicManagers = new ConcurrentHashMap<Byte, ILogicManager>();

	private static final byte USER_LOGIN_LOGIC = 1;

	public UserModule() {
		logicManagers.put(USER_LOGIN_LOGIC, new UserManager());
	}

	@Override
	public void handle(Buffer data) {
		// TODO Auto-generated method stub
		// Log.i("UserModule handle data: " + data.length());
		int pos = 0;
		byte pid = BufferReader.readByte(data, pos);
		pos++;
		byte subpid = BufferReader.readByte(data, pos);
		pos++;
		String msg = BufferReader.readString(data, pos);
		Log.t(msg);
	}

}

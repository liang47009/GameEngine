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

	private static final byte USER_MANAGER_LOGIC_1 = 1;

	public UserModule() {
		UserManager userManager = new UserManager();
		logicManagers.put(USER_MANAGER_LOGIC_1, userManager);
	}

	@Override
	public void handle(Buffer buffer) {
		// TODO Auto-generated method stub
		byte pid = BufferReader.readByte(buffer, 0);
		if (pid > 0) {
			ILogicManager logic = logicManagers.get(pid);
			if (logic == null) {
				Log.e("no logic to execute!");
			} else {
				Buffer data = Buffer.buffer().appendBuffer(buffer, 1, buffer.length() - 1);
				logic.execute(data);
			}
		}
	}

}

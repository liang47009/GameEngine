package com.yunfeng.game.module;

import com.yunfeng.game.module.user.UserModule;
import com.yunfeng.game.transfer.Server;

public class ModuleManager {

	private static final byte USER_MODULE_ID = 1;

	public void init(Server server) {
		server.registerModule(USER_MODULE_ID, new UserModule());
	}
}

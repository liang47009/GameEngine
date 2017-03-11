package com.yunfeng.game.module;

import io.vertx.core.buffer.Buffer;

public interface IModule {

	void handle(Buffer data);

}

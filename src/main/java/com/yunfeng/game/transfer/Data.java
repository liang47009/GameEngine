package com.yunfeng.game.transfer;

import java.nio.Buffer;

/**
 * 数据结构体
 * 
 * @author XIAYUNFENG
 *
 */
public class Data {
	private String id;
	private byte module;
	private byte pid;// 消息号
	private byte subPid;// 子消息

	private Buffer buffer;// 消息体

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte getModule() {
		return module;
	}

	public void setModule(byte module) {
		this.module = module;
	}

	public byte getPid() {
		return pid;
	}

	public void setPid(byte pid) {
		this.pid = pid;
	}

	public byte getSubPid() {
		return subPid;
	}

	public void setSubPid(byte subPid) {
		this.subPid = subPid;
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

}

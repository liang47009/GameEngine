package com.yunfeng.game.transfer;

import io.vertx.core.buffer.Buffer;

import com.yunfeng.game.util.Log;

public class BufferWriter {

	public static Buffer writeByte(Buffer buffer, byte b) {
		return buffer.appendByte(b);
	}

	public static Buffer writeInt(Buffer buffer, int i) {
		return buffer.appendInt(i);
	}

	public static Buffer writeLong(Buffer buffer, long l) {
		return buffer.appendLong(l);
	}

	public static Buffer writeFloat(Buffer buffer, float f) {
		return buffer.appendFloat(f);
	}

	public static Buffer writeDouble(Buffer buffer, Double d) {
		return buffer.appendDouble(d);
	}

	private static final int ERROR_STRING_LENGTH = 1000;

	public static Buffer writeString(Buffer buffer, String s) {
		if (s == null || s.length() == 0) {
			Log.e("cant write empty string to buffer !");
			return buffer;
		}
		if (s.length() > ERROR_STRING_LENGTH) {
			Log.e("cant write too long string to buffer !");
			return buffer;
		}
		byte[] bytes = s.getBytes();
		return buffer.appendInt(bytes.length).appendBytes(bytes);
	}
}

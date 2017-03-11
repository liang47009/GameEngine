package com.yunfeng.game.transfer;

import io.vertx.core.buffer.Buffer;

import com.yunfeng.game.util.Log;

public class BufferReader {

	public static byte readByte(Buffer buffer, int pos) {
		return buffer.getByte(pos);
	}

	public static int readInt(Buffer buffer, int pos) {
		return buffer.getInt(pos);
	}

	public static long readLong(Buffer buffer, int pos) {
		return buffer.getLong(pos);
	}

	public static float readFloat(Buffer buffer, int pos) {
		return buffer.getFloat(pos);
	}

	public static double readDouble(Buffer buffer, int pos) {
		return buffer.getDouble(pos);
	}

	private static final int ERROR_STRING_LENGTH = 1000;

	/**
	 * 
	 * @param buffer
	 * @param pos
	 * @return
	 */
	public static String readString(Buffer buffer, int pos) {
		int length = readInt(buffer, pos);
		if (length > 0) {
			if (length < ERROR_STRING_LENGTH) {
				return buffer.getString(pos + 4, pos + 4 + length);
			} else {
				Log.e("string length is too long, please check protocol!");
			}
		}
		return "";
	}
}

package utils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import play.Play;

/**
 * アプリケーションの設定情報を扱うクラス
 * @author ohbarye
 */
public class ConfigUtil {

	/**
	 * 設定ファイルから値を取得する。
	 * @param key
	 * @return 
	 */
	public static Optional<String> getString(String key) {
    	return Optional.ofNullable(
    			Play.application().configuration().getString(key));
	}

	/**
	 * 設定ファイルから値を取得する。
	 * @param key
	 * @return 
	 */
	public static Optional<Integer> getInteger(String key) {
    	return Optional.ofNullable(
    			Play.application().configuration().getInt(key));
	}

	/**
	 * 設定ファイルから値を取得する。
	 * @param key
	 * @return
	 */
	public static Optional<Boolean> getBoolean(String key) {		
    	return Optional.ofNullable(
    			Play.application().configuration().getBoolean(key));
	}

	/**
	 * 設定ファイルから値を取得する。
	 * @param key
	 * @return
	 */
	public static Optional<List<String>> getList(String key) {		
    	return Optional.ofNullable(
    			Play.application().configuration().getStringList((key)));
	}

	/**
	 * 設定ファイルから値を取得する。
	 * @param key
	 * @return
	 */
	public static Optional<List<Map<String,Object>>> getObjectList(String key) {		
    	return Optional.ofNullable(
    			Play.application().configuration().getObjectList(key));
	}

}

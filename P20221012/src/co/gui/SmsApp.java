package co.gui;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

//20221018 : pw찾을 경우 이메일 또는 문자로 일회성 비밀번호 전송에 사용
public class SmsApp {
	public void sendSms(String to, String from, String content) {
		String api_key = "NCSSR6BF5GTE32F0";
		String api_secret = "1WLRZGMZKFEFMMEGPSEXPI9TAYSLOZZG";
		Message coolsms = new Message(api_key, api_secret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", to); // 수신번호
		params.put("from", from); // 발신번호
		params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
		params.put("text", content); // 문자내용
		params.put("app_version", "JAVA SDK v1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}
}

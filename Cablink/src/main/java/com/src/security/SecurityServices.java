package com.src.security;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class SecurityServices implements SecurityServicesInterface{
	Encoder encode = Base64.getEncoder();
	Decoder decode = Base64.getDecoder();
	@Override
	public String encrypt(String string) {
		// TODO Auto-generated method stub
		
		return (encode.encodeToString(string.getBytes()));
	}

	@Override
	public String decrypt(String string) {
		// TODO Auto-generated method stub
		return new String(decode.decode(string));
	}

}

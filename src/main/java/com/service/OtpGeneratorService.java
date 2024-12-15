package com.service;

import org.springframework.stereotype.Service;

@Service
public class OtpGeneratorService {

	public String generateOtp(int size) {
		StringBuilder otp = new StringBuilder("");

		String seed = "0123456789";

		for (int i = 1; i <= size; i++) {

			int index = (int) (Math.random() * seed.length());
			if (i == 1 && index == 0) {
				i--;// 0
			} else {
				otp.append(seed.charAt(index));
			}
		}

		return otp.toString();
	}
	//

}

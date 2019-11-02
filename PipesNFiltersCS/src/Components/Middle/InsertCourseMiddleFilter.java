package Components.Middle;

/**
 * Copyright(c) 2013 All rights reserved by JU Consulting
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import Framework.GeneralFilter;

/**
 * @author Hwi Ahn, Pilsu Jung, Jungho Kim
 * @date 2013-08-15
 * @version 1.0
 * @description 입력값으로 받은 byte들을 아무 기능도 하지 않고 그대로 전송하는 기능을 한다.
 */
public class InsertCourseMiddleFilter extends GeneralFilter {

	@Override
	public void specificComputationForFilter() throws IOException {
		int checkBlank = 5;
		int checkBlank2 = 6;
		int databyte = 0;
		int numOfBlank = 0;
		int idx = 0;

		byte[] buffer = new byte[64];
		boolean is12345 = false, is23456 = false;

		while (true) {
			while (databyte != '\n' && databyte != -1) {
				databyte = in.read();
				if (databyte == ' ') {
					numOfBlank++;
				}
				if (databyte != -1) {
					buffer[idx++] = (byte) databyte;
				}
				if (numOfBlank == checkBlank && buffer[idx - 6] == '1' && buffer[idx - 5] == '2'
						&& buffer[idx - 4] == '3' && buffer[idx - 3] == '4' && buffer[idx - 2] == '5') {
					is12345 = true;
				}
				if (numOfBlank == checkBlank2 && buffer[idx - 6] == '2' && buffer[idx - 5] == '3'
						&& buffer[idx - 4] == '4' && buffer[idx - 3] == '5' && buffer[idx - 2] == '6') {
					is23456 = true;
				}

			}

			if (is12345 == false && is23456 == false && databyte != -1) {
				byte[] byt = " 12345 23456\n".getBytes(StandardCharsets.UTF_8);

				idx = idx - 2;
				for (int i = 0; i < byt.length; i++) {
					buffer[idx++] = byt[i];
				}
				is12345 = true;
				is23456 = true;
			}
			if (is12345 == false && databyte != -1) {
				byte[] byt = " 12345\n".getBytes(StandardCharsets.UTF_8);

				idx = idx - 2;
				for (int i = 0; i < byt.length; i++) {
					buffer[idx++] = byt[i];
				}
				is12345 = true;
			}
			if (is23456 == false && databyte != -1) {
				byte[] byt = " 23456\n".getBytes(StandardCharsets.UTF_8);

				idx = idx - 2;
				for (int i = 0; i < byt.length; i++) {
					buffer[idx++] = byt[i];
				}
				is23456 = true;
			}

			if (is12345 == true && is23456 == true) {
				for (int i = 0; i < idx; i++) {
					out.write((char) buffer[i]);
					System.out.print((char) buffer[i]);
				}
				is12345 = false;
				is23456 = false;
			}
			if (databyte == -1) {
				out.close();
				return;
			}
			idx = 0;
			numOfBlank = 0;
			databyte = '\0';
		}

	}
	

}

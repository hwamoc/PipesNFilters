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
public class DeleteCourseMiddleFilter extends GeneralFilter {

	@Override
	public void specificComputationForFilter() throws IOException {
		int checkBlank = 7;
		int checkBlank2 = 8;
		int databyte = 0;
		int numOfBlank = 0;
		int idx = 0;

		byte[] buffer = new byte[64];
		boolean is17651 = false, is17652 = false;

		while (true) {
			while (databyte != '\n' && databyte != -1) {
				databyte = in.read();
				if (databyte == ' ') {
					numOfBlank++;
				}
				if (databyte != -1) {
					buffer[idx++] = (byte) databyte;
				}
				if (numOfBlank == checkBlank && buffer[idx - 6] == '1' && buffer[idx - 5] == '7'
						&& buffer[idx - 4] == '6' && buffer[idx - 3] == '5' && buffer[idx - 2] == '1') {
					is17651 = true;
					idx = idx - 6;
				}
				if (numOfBlank == checkBlank2 && buffer[idx - 6] == '1' && buffer[idx - 5] == '7'
						&& buffer[idx - 4] == '6' && buffer[idx - 3] == '5' && buffer[idx - 2] == '2') {
					is17652 = true;
					idx = idx - 6;
				}
				

			}

			if (is17651 == true || is17652 == true) {
				for (int i = 0; i < idx; i++) {
					out.write((char) buffer[i]);
					System.out.print((char) buffer[i]);
				}
				is17651 = false;
				is17652 = false;
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

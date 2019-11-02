package Components.Sink;
/**
 * Copyright(c) 2013 All rights reserved by JU Consulting
 */

import java.io.FileWriter;
import java.io.IOException;

import Framework.GeneralFilter;

/**
 * @author Hwi Ahn, Pilsu Jung, Jungho Kim
 * @date 2013-08-15
 * @version 1.0
 * @description
 *      입력값으로 들어온 byte들을 읽어 CS 값만 출력값 파일에 기록하는 클래스.
 */
public class SinkFilter extends GeneralFilter{
    private String filePath;
    
    public SinkFilter(String outputFilePath) {
        this.filePath = outputFilePath;
    }

    @Override
    public void specificComputationForFilter() throws IOException {
    	int byte_read;

		try {
			FileWriter fw = new FileWriter(this.filePath);
			
		    try { 
			      while(true) {
			        byte_read = in.read();

                    if(byte_read == -1){
                        fw.close();
                        System.out.println( "::Filtering is finished; Output file is created." );
                        return;
                    }
                    fw.write((char)byte_read);
			      }
			    } catch (Exception e) {

			    }

		





		} catch (Exception e) {
			closePorts();
			e.printStackTrace();

		}
	}

}

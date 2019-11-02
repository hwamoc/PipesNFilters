package Framework;
import Components.Middle.CSMiddleFilter;
import Components.Middle.InsertCourseMiddleFilter;
import Components.Sink.SinkFilter;
import Components.Source.SourceFilter;

/**
 * Copyright(c) 2013 All rights reserved by JU Consulting
 */


/**
 * @author Hwi Ahn, Pilsu Jung, Jungho Kim
 * @date 2013-08-15
 * @version 1.0
 * @description
 *      Filter들의 input/output port를 연결하고 실제로 구동을 시키는 main 메소드가 위치한 클래스.
 */
public class PipeAndFilterSystem {

    public static void main(String[] args) {
        try {
            CommonForFilter sourceFilter = new SourceFilter("Students.txt");
            CommonForFilter CSMiddleFilter = new CSMiddleFilter();
            CommonForFilter insertCourseMiddleFilter = new InsertCourseMiddleFilter();
            CommonForFilter sinkFilter = new SinkFilter("Output.txt");
            
            sourceFilter.connectOutputTo(CSMiddleFilter);
            CSMiddleFilter.connectOutputTo(insertCourseMiddleFilter);
            insertCourseMiddleFilter.connectOutputTo(sinkFilter);
            
            
            Thread thread1 = new Thread(sourceFilter);
            Thread thread2 = new Thread(CSMiddleFilter);
            Thread thread3 = new Thread(insertCourseMiddleFilter);
            Thread thread4 = new Thread(sinkFilter);	
            
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}

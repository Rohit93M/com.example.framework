package genericutility;

import java.awt.Robot;
import java.time.LocalDateTime;

public class JavaUtility {

public String localDateAndTime() {
String dateAndTime=LocalDateTime.now().toString().replace(':','-');
return dateAndTime;
    }
}
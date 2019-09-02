package tool;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

import java.sql.Date;
import java.sql.SQLException;

public class ChangeToSqlDate extends DefaultTypeConverter {

    @Override
    public Object convertValue(Object value, Class toType) {

        if (value == null || toType != Date.class) return false;
        if (value instanceof String[]) {
            String before = ((String[]) (value))[0];
            System.out.println("---------------------------------");
            System.out.println(before);
            System.out.println("---------------------------------");

            try {
                Date date = Date.valueOf(before);
                System.out.println(date.toString());
                return date;
            } catch (Exception se) {
                se.printStackTrace();
                return false;
            }

        }

        return false;
    }

}
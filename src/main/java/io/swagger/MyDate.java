package io.swagger;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MyDate extends ISO8601DateFormat {

    private static final long serialVersionUID = 1L;

    @Override
    /**
     * Utilisé pour rendre la date au bon format dans la documentation.
     */
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        Calendar d = new GregorianCalendar();
        d.setTime(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        String format = dateFormat.format(d.getTime()) + " GMT";
        toAppendTo.append(format);
        return toAppendTo;
    }

}
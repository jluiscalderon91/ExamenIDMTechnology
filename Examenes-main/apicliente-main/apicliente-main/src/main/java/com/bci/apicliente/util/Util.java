package com.bci.apicliente.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Util {
    public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static String convertirDateToString(Date fecha) {
        return dateFormat.format(fecha);
    }
    public static Date convertirStringToDate(String date) throws ParseException {
        return dateFormat.parse(date);
    }
}

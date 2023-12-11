package com.android.ocrsystem.model.converter;
import androidx.room.TypeConverter;

import java.util.Arrays;
import java.util.List;

public class AllergyListConverter {
    @TypeConverter
    public static String fromList(List<String> allergyList) {
        if (allergyList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String allergy : allergyList) {
            sb.append(allergy).append(",");
        }
        return sb.toString();
    }

    @TypeConverter
    public static List<String> toList(String data) {
        if (data == null) {
            return null;
        }
        return Arrays.asList(data.split(","));
    }
}

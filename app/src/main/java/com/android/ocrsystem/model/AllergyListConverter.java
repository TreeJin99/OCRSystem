package com.android.ocrsystem.model;

// AllergyListConverter.java

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.android.ocrsystem.model.Allergy;

import java.lang.reflect.Type;
import java.util.List;

public class AllergyListConverter {
    private static final Gson gson = new Gson();

    @TypeConverter
    public static List<Allergy> fromString(String value) {
        Type listType = new TypeToken<List<Allergy>>() {}.getType();
        return gson.fromJson(value, listType);
    }

    @TypeConverter
    public static String fromList(List<Allergy> list) {
        return gson.toJson(list);
    }
}

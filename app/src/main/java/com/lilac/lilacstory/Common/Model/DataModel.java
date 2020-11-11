package com.lilac.lilacstory.Common.Model;

import android.content.SharedPreferences;
import android.provider.ContactsContract;

import java.util.HashMap;
import java.util.Map;

public class DataModel implements DataRepository {
    private Map<String,String> repo = new HashMap<>();
    private static DataRepository dataRepository = new DataModel();
    private DataModel(){}

    public static DataRepository getInstance()
    {
        return dataRepository;
    }

    @Override
    public String LoadInfo(String key) {
        return repo.get(key);
    }

    @Override
    public void SaveInfo(String key,String value) {
        repo.put(key,value);
    }
}

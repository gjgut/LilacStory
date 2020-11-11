package com.lilac.lilacstory.Common.Model;

interface DataRepository {

    String LoadInfo(String key);
    void SaveInfo(String key,String value);

}

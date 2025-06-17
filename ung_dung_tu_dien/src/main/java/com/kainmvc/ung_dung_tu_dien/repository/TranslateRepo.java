package com.kainmvc.ung_dung_tu_dien.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TranslateRepo implements ITranslateRepo{
    private static Map<String,String> wordList= new HashMap<>();
    static {
        wordList.put("Vĩnh", "nobita");
        wordList.put("Con gà", "chicken");
        wordList.put("Con vịt", "duck");
        wordList.put("Con heo", "pig");
    }


    @Override
    public String findByKey(String key) {
        for (Map.Entry<String, String> entry : wordList.entrySet()) {
            if(entry.getKey().equals(key)){
                return entry.getValue();
            }
        }
        return null;
    }
}

package com.kainmvc.ung_dung_tu_dien.service;

import com.kainmvc.ung_dung_tu_dien.repository.ITranslateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslateService implements ITranslateService{
    @Autowired
    private ITranslateRepo translateRepo;
    @Override
    public String findByKey(String key) {
        return translateRepo.findByKey(key);
    }
}

package com.kainmvc.hom_thu_dien_tu.service;

import com.kainmvc.hom_thu_dien_tu.entity.Email;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService implements IEmailService{
    private static List<Email> emails = new ArrayList<>();

    static {
        emails.add(new Email(1,"English",25,true, "VinhxWibu"));
        emails.add(new Email(2,"Vietnamese",25,false, "VinhxWibu"));
        emails.add(new Email(3,"Japanese",25,false, "VinhxWibu"));
        emails.add(new Email(4,"English",25,false, "VinhxWibu"));
    }
    @Override
    public List<Email> findAll() {
        return emails;
    }

    @Override
    public Email findById(int id) {
        for (Email email : emails) {
            if (email.getId() == id) {
                return email;
            }
        }
        return null;
    }

    @Override
    public void update(Email email) {
        for(int i =0;i<emails.size();i++){
            if(emails.get(i).getId()==email.getId()){
                emails.set(i,email);
            }
        }
    }
}

package com.kainmvc.hom_thu_dien_tu.service;

import com.kainmvc.hom_thu_dien_tu.entity.Email;

import java.util.List;

public interface IEmailService {
    List<Email> findAll();
    Email findById(int id);
    void update(Email email);
}

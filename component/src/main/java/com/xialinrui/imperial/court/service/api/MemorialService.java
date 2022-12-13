package com.xialinrui.imperial.court.service.api;

import com.xialinrui.imperial.court.entity.Memorials;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MemorialService {

    List<Memorials> getAllMemorialsDigest();

    Memorials getMemorialsDetailById(String memorialsId);

    void upDateMemorialsStatusToRead(String memorialsId);

    void updateMemorialsFeedback(String memorialsId, String feedbackContent);
}

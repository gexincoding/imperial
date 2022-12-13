package com.xialinrui.imperial.court.service.impl;

import com.xialinrui.imperial.court.entity.Memorials;
import com.xialinrui.imperial.court.mapper.MemorialsMapper;
import com.xialinrui.imperial.court.service.api.MemorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@Transactional
public class MemorialsServiceImpl implements MemorialService {

    @Autowired
    private MemorialsMapper memorialsMapper;


    @Override
    public List<Memorials> getAllMemorialsDigest() {
        return memorialsMapper.selectAllMemorialsDigest();
    }

    @Override
    public Memorials getMemorialsDetailById(String memorialsId) {
        return memorialsMapper.selectMemorialsById(memorialsId);
    }

    @Override
    public void upDateMemorialsStatusToRead(String memorialsId) {
        memorialsMapper.updateMemorialsStatusToRead(memorialsId);

    }

    @Override
    public void updateMemorialsFeedback(String memorialsId, String feedbackContent) {
        memorialsMapper.updateMemorialsFeedback(memorialsId,feedbackContent);
    }
}

package com.gao.service.impl;

import com.gao.mappers.TStudentMapper;
import com.gao.model.TStudent;
import com.gao.service.TStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TStudentServiceImpl implements TStudentService {
    @Autowired
    private TStudentMapper tStudentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tStudentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TStudent record) {
        return tStudentMapper.insert(record);
    }

    @Override
    public int insertSelective(TStudent record) {
        return tStudentMapper.insertSelective(record);
    }

    @Override
    public TStudent selectByPrimaryKey(Integer id) {
        return tStudentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TStudent record) {
        return tStudentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TStudent record) {
        return tStudentMapper.updateByPrimaryKey(record);
    }
}

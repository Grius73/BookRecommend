package com.wudi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wudi.mapper.RateMapper;
import com.wudi.model.Rate;
import com.wudi.model.RateKey;
import com.wudi.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
@Service
public class RateServiceImpl implements RateService {
    @Autowired
    RateMapper rateMapper;
    @Override
    public PageInfo<Rate> returnAllRate(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Rate> rateList= rateMapper.getAll();
        return new PageInfo<>(rateList,5);
    }

    @Override
    public int isRecordExist(int userid, int bookid) {
        RateKey rateKey=new RateKey();
        rateKey.setBookid(bookid);
        rateKey.setUserid(userid);
        if(rateMapper.selectByPrimaryKey(rateKey)!=null)
        {
            return 1;
        }else return 0;

    }

    @Override
    public Rate returnRate(int userid, int bookid) {
        RateKey rateKey=new RateKey();
        rateKey.setBookid(bookid);
        rateKey.setUserid(userid);
        return rateMapper.selectByPrimaryKey(rateKey);
    }

    @Override
    public float returnAvgScore(int bookid) {
        return rateMapper.avgScore(bookid);
    }

    @Override
    public int returnRateNum(int bookid) {
        return rateMapper.rateNum(bookid);
    }
}

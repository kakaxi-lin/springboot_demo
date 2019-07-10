package com.yk.shopping.dao;

import com.yk.shopping.po.PurchaseRecord;

public interface PurchaseRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseRecord record);

    int insertSelective(PurchaseRecord record);

    PurchaseRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseRecord record);

    int updateByPrimaryKey(PurchaseRecord record);
}
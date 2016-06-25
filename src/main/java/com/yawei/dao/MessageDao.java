package com.yawei.dao;

import com.yawei.entity.Message;
import com.yawei.util.DbHelper;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class MessageDao {

    public List<Message> findAll(){
        String sql = "select * from t_message order by id desc";
        return DbHelper.query(sql,new BeanListHandler<>(Message.class));
    }
    public List<Message> findMsgByMaxId(String maxId){
        String sql = "select * from t_message where id > ? order by id desc";
        return DbHelper.query(sql,new BeanListHandler<>(Message.class),maxId);
    }
}

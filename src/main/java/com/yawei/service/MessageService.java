package com.yawei.service;
import com.yawei.dao.MessageDao;
import com.yawei.entity.Message;

import java.util.List;

public class MessageService {
    private MessageDao messageDao = new MessageDao();

    public List<Message> findAll(){
        return messageDao.findAll();
    }
    public List<Message> findMsgById(String maxId){
        return messageDao.findMsgByMaxId(maxId);
    }
}

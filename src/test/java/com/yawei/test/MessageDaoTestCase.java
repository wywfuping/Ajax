package com.yawei.test;

import com.yawei.dao.MessageDao;
import com.yawei.entity.Message;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MessageDaoTestCase {
    private static MessageDao messageDao = new MessageDao();

    @Test
    public void findByIdTest(){
        Message message = messageDao.findById(2);
        message = messageDao.findById(2);
        message = messageDao.findById(2);
        Assert.assertNotNull(message);
    }

    @Test
    public void findAllTest(){
        List<Message> messageList = messageDao.findAll();

        messageList = messageDao.findAll();
        Message message = new Message();
        message.setAuthor("tom");
        message.setMessage("come");

        messageDao.save(message);

        messageList = messageDao.findAll();
        messageList = messageDao.findAll();

        Assert.assertEquals(20,messageList.size());
    }
}

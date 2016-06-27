package com.yawei.dao;

import com.yawei.entity.Message;
import com.yawei.util.DbHelper;
import com.yawei.util.cache.EhcacheUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MessageDao {
    private Logger logger = LoggerFactory.getLogger(Message.class);

    public Message findById(Integer id) {
        Message message = (Message) EhcacheUtil.get("message:" + id);
        if (message == null) {
            String sql = "select * from t_message where id = ?";
            message = DbHelper.query(sql, new BeanHandler<>(Message.class), id);
            EhcacheUtil.set("message:" + id, message);
        } else {
            logger.debug("从缓存中读取数据");
        }
        return message;
    }

    public List<Message> findAll() {
        List<Message> messageList = (List<Message>) EhcacheUtil.get("messageList");
        if (messageList==null) {
            String sql = "select * from t_message order by id desc";
            messageList=DbHelper.query(sql, new BeanListHandler<>(Message.class));
            EhcacheUtil.set("messageList",messageList);
        }
        return messageList;
    }

    public void save(Message message){
        String sql = "insert into t_message(message,author) values(?,?)";
        DbHelper.update(sql,message.getMessage(),message.getAuthor());
        EhcacheUtil.remove("messageList");
    }

    public List<Message> findMsgByMaxId(String maxId) {
        String sql = "select * from t_message where id > ? order by id desc";
        return DbHelper.query(sql, new BeanListHandler<>(Message.class), maxId);
    }
}

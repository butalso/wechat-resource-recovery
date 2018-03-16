package dao;

import entity.Message;
import entity.User;
import org.apache.ibatis.annotations.Param;

public interface MessageDao {
    /**
     * 创建消息
     * @return
     */
    int addMessage(Message message);

    /**
     * 获取用户创建的消息
     * @param sender
     * @return
     */
    Message getSendMessage(User sender);

    /**
     * 获取用户接收的消息
     * @param receiver
     * @return
     */
    Message getReceiveMessage(User receiver);

    /**
     * 将消息标记为已读
     * @param messageId
     */
    void readMessage(int messageId);

    /**
     * 删除消息
     * @param messageId
     */
    void deleteMessage(int messageId);

}

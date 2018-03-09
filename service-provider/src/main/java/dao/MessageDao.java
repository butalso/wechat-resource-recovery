package dao;

import entity.Message;
import entity.User;
import org.apache.ibatis.annotations.Param;

public interface MessageDao {
    /**
     * 创建消息
     * @param sender
     * @param receiver
     * @param content
     * @return
     */
    int createMessage(@Param("sender") User sender, @Param("receiver") User receiver, @Param("content") String content);

    /**
     * 获取用户创建的消息
     * @param sender
     * @return
     */
    Message getMySends(User sender);

    /**
     * 获取用户接收的消息
     * @param receiver
     * @return
     */
    Message getMyReceive(User receiver);

    /**
     * 将消息标记为已读
     * @param messageId
     */
    void readMessage(int messageId);

}

package com.yunhuchatbot.Constant;

/**
 * 事件类型
 * @author xclhove
 */
public interface EventType {
    /**
     * 普通消息事件
     */
    final String MESSAGE_RECEIVE_NORMAL = "message.receive.normal";
    /**
     * 指令消息事件
     */
    final String MESSAGE_RECEIVE_INSTRUCTION = "message.receive.instruction";
    /**
     * 关注机器人事件
     */
    final String BOT_FOLLOWED = "bot.followed";
    /**
     * 取消关注机器人事件
     */
    final String BOT_UNFOLLOWED = "bot.unfollowed";
    /**
     * 加入群事件
     */
    final String GROUP_JOIN = "group.join";
    /**
     *退出群事件
     */
    final String GROUP_LEAVE = "group.leave";
    /**
     * 按钮事件
     */
    final String BUTTON_REPORT_INLINE = "button.report.inline";
}

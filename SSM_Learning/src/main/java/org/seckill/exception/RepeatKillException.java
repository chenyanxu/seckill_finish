package org.seckill.exception;

/**
 * �ظ���ɱ�쳣(�������쳣)��
 * �쳣���������쳣���������쳣���������쳣����Ҫ�ֶ�try/catch��
 * spring ������ʽ����ֻ�ӿ��������쳣������Ǳ������쳣���ǲ������ع��ġ�
 * @author yangxin
 * @version 1.00
 * @time 2018/12/7  9:23
 */
public class RepeatKillException extends SeckillException{
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}

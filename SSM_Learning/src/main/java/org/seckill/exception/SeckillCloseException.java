package org.seckill.exception;

/**
 *
 * ��ɱ�ر��쳣��
 * @author yangxin
 * @version 1.00
 * @time 2018/12/7  9:27
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}

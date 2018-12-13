package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.SecKill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * ҵ��ӿڣ�վ��"ʹ����"�ĽǶ���ƽӿڡ�
 * �������棺�٣������������ȡ��ڣ�������Խ����Խ�á��۷������ͣ�return �������Ѻ�/Ҳ�����׳��쳣��
 * @author yangxin
 * @version 1.00
 * @time 2018/12/7  8:58
 */
public interface SeckillService {

    /**
    * ��ѯ������ɱ��¼��
    * @author      yangxin
     * @param
    * @return
    * @exception
    * @date        2018/12/7 9:02
    */
    List<SecKill> getSeckillList();

    /**
    * ����Id��ѯһ����ɱ�ӿڡ�
    * @author      yangxin
     * @param @seckillId:��ƷID
    * @return
    * @exception
    * @date        2018/12/7 9:04
    */
    SecKill getById(long seckillId);

    /**
    * ��ɱ����ʱ�������ɱ�ӿڵĵ�ַ���������ϵͳʱ�����ɱʱ�䡣
     * ��ֹUrl����ƴ����ɱ��ַ���ٸ�����������������ɱ��
    * @author      yangxin
    * @return
    * @exception
    * @date        2018/12/7 9:05
    */
    Exposer exportSeckillUrl(long seckillId);

    /**
    *ִ����ɱ������
     * ʹ��Md5�����ж��û��Ƿ񴮸�md5���ܵĵ�ַ���Ƿ������ɱ��
    * @author      yangxin
    * @return   ��װ����ɱ���������
    * @date        2018/12/7 9:15
    */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
        throws SeckillException, RepeatKillException, SeckillCloseException;

    /**
    * ʹ�ô洢����
    * @author      yangxin
    * @date        2018/12/12 13:08
    */
    SeckillExecution executeSeckill2(long seckillId, long userPhone, String md5);


}

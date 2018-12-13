package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKill;

public interface SuccessKillDao {
	
	/*
	 * ���빺����ϸ���ɹ����ظ�
	 * ����ֵ���ز������������������0��ʾ����ʧ�ܡ�
	 */
	public int insertSuccessKilled(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
	
	/*
	 * ����id��ѯSuccessKilled��Я����ɱ��Ʒ����ʵ��
	 */
	public SuccessKill queryByIdWithSecKill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
	
	

}

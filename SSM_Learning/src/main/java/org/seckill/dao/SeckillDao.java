package org.seckill.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SecKill;

public interface SeckillDao {
	
	/*
	 * ����溯��
	 * ������ص�����>1����ʾӰ���������������0����������û�гɹ�
	 */

	public int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime")Date killTime);


	/*
	 * ��ѯ�ӿ�
	 */

	public SecKill queryById(long seckillId);

	/*
	 * ����ƫ������ѯ��ɱ��Ʒ�б�
	 * ����ΪʲôҪʹ��@Paramע��;��Ϊjava����û�б����βε���������һ���������βζ���ʾ��args0��args1......
	 * ����������SeckillDao.xml��Sql����У�������һ�� limit #{offset},#{limit};������Ҫoffset��limit������
	 * �����ע����ǽ��������⡣
	 */
	public List<SecKill> queryAll(@Param("offset")int offset,@Param("limit")int limit);


	/*
	* ʹ�ô洢����ִ����ɱ��
	* */
	void killByProcedure(Map<String,Object> map);


}

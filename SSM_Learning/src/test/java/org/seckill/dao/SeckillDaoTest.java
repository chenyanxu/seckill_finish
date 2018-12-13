package org.seckill.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SecKill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * ����spring��Junit���ϣ�Junit����ʱ����springIOc
 * SPring-test��jUnit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//����Junit Spring�����ļ�
@ContextConfiguration({"classpath:spring/springDao-config.xml"})
public class SeckillDaoTest {
	
	//ע��Dao����
	
	@Resource
	private SeckillDao seckillDao; 
	
	@Test
	public void testQueryById() throws Exception {
		long id=1000;
		
		SecKill secKill=seckillDao.queryById(id);
		System.out.println(secKill.getName());
		System.out.println(secKill);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testQueryAll() {
		List<SecKill> list=seckillDao.queryAll(0, 100);
		for(SecKill secKill:list)
			System.out.println(secKill);
	}
	
	/*
	 *
	 */
	
	@Test
	public void testReduceNumber() {
		Date date =new Date();
		
		int count=seckillDao.reduceNumber(1000, date);
		
		System.out.println("update:  "+count);
	}




}

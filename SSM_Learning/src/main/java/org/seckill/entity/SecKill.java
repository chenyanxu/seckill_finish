package org.seckill.entity;

import java.util.Date;

public class SecKill {
	private long seckillId;
	//�������ݿ��seckill_id
	
	private String name;
	//�������ݿ��name
	
	private int number;
	//�������ݿ��number
	
	private Date startTime;
	//�������ݿ��start_time
	
	private Date endTime;
	//�������ݿ��end_time
	
	private Date createTime;
	//�������ݿ��create_time


	public long getSeckillId() {
		return seckillId;
	}


	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SecKill [seckillId=" + seckillId + ", name=" + name + ", number=" + number + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", createTime=" + createTime + "]";
	}

	

}

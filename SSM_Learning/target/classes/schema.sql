 --���ݿ��ʼ���ű�

--�������ݿ�

CREATE database seckill;

--ʹ�����ݿ�

use seckill;

--������ɱ����

create table seckill(

	`seckill_id` bigint NOT NULL AUTO_INCREMENT  COMMENT '��Ʒ���ID',
	`name` varchar(120) NOT NULL COMMENT '��Ʒ������',
	`number` int NOT NULL COMMENT '�������',
	`start_time` timestamp NOT NULL COMMENT '��ɱ��ʼʱ��',
	`end_time` timestamp NOT NULL COMMENT '��ɱ����ʱ��',
	`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
	PRIMARY KEY(seckill_id),
	key idx_start_time(start_time),
	key idx_end_time(end_time),
	key idx_create_time(create_time)	
)engine=InnoDB auto_INCREMENT=1000 DEFAULT CHARSET=utf8 comment='��ɱ����';

---��ʼ������
insert into seckill(name,number,start_time,end_time)
values
('1000Ԫ��ɱipone12X',100,'2018-11-11 00:00:00','2018-11-12 00:00:00'),
('100Ԫ��ɱipad',100,'2018-11-11 00:00:00','2018-11-12 00:00:00'),
('1300Ԫ��ɱС��',100,'2018-11-11 00:00:00','2018-11-12 00:00:00'),
('700Ԫ��ɱ��Ϊmate20',100,'2018-11-11 00:00:00','2018-11-12 00:00:00'),
('1000Ԫ��ɱoppo',100,'2018-11-11 00:00:00','2018-11-12 00:00:00'),
('600Ԫ��ɱŮ����',100,'2018-11-11 00:00:00','2018-11-12 00:00:00'),
('1000Ԫ��ɱiponeX',100,'2018-11-11 00:00:00','2018-11-12 00:00:00');

---��ɱ�ɹ���ϸ��
---�û���¼��֤�����Ϣ
create table success_killed(
	`seckill_id` bigint not null comment '��ɱ��Ʒid',
	`user_phone` bigint not null comment '�û��ֻ�����',
	`state` tinyint not null default -1 comment '״̬��ʶ��-1����Ч��0���ɹ���1���Ѹ��2���ѷ���..',
	`create_time` timestamp not null comment '����ʱ��',
	primary key(seckill_id,user_phone),/*��������*/
	key idx_crate_time(create_time)
)engine=InnoDB DEFAULT CHARSET=utf8 comment='��ɱ�ɹ���ϸ��';

---�������ݿ����̨

mysql -uroot -p


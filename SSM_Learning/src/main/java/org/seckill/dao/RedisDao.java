package org.seckill.dao;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.seckill.entity.SecKill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author yangxin
 * @time 2018/12/12  11:15
 */
public class RedisDao {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    //����Jedis��pool
    private JedisPool jedisPool;

    public RedisDao(String ip, int port){
      jedisPool = new JedisPool(ip, port);
    }

    //ʹ�õ�������protostuff���л�����Ҫ��ָ����Ҫ���л�����ӿڣ����£���������������pojo�͡�
    private RuntimeSchema<SecKill> schema=RuntimeSchema.createFrom(SecKill.class);

    public SecKill getSeckill(long seckillId) {
        //����Redis������
        try{
            //����jedisPool������ǵ���Դ .getResource();
            Jedis jedis=jedisPool.getResource();
            try{
                //��ΪRedis��key-value�洢�ģ���ô��������Ҫ����һ��key��
                String key="seckill:"+seckillId;
                /*
                    Redis��û��ʵ���ڲ����л�������
                    ������Ҫ�ڻ�ȡredis��Դ��ʱ��Ҫ���з����л�����
                    get->byte[]->�����л�->Object(Seckill);
                    �������л��Ľ�������������ż�������Ҫ���ݵ�entity�Ķ�����ʵ�� Serializable�ӿڣ����Serializable��
                    ʹ�õ���JDK���Լ������л���   �ڴ�ʦ������Ȼ�����Ż������¶�ӿڣ���ô�Ͱ���������ã�ʹ��JDkԭ����
                    ���л����ٶȣ�Ч�ʣ�ռ�Ŀռ䣬ת�����ֽ���(����,�������д�����ֽ����ͻ����٣�Ч�����)�ȶ��������
                    �ġ������Զ������л�������ʹ�õ���protostuff,��ô��Pom.xml����� protostuff-core��protostuff-runtime
                    ϵ�л�������
                */
                byte[]bytes=jedis.get(key.getBytes());
                if(bytes!=null){
                    //����һ���ն���,��Redis�и�ֵ������ն���
                    SecKill secKill=schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes,secKill,schema);
                    //�ն���secKill���ڵ����������֮�󱻸�ֵ��
                    return secKill;
                }
            }finally {
                jedis.close();
            }
        }catch(Exception e){
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    public String setSeckill(SecKill seckill) {
        //�����õ�Seckill��Ȼ��ת�����ֽ����飬Ȼ���redis
        try{
            //�����Դ
            Jedis jedis=jedisPool.getResource();
            try{
                //��װKey
                String key="seckill:"+seckill.getSeckillId();
                //ϵ�л�
                byte[] bytes=ProtostuffIOUtil.toByteArray(seckill,schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));

                int timeout=60*60;
                String result=jedis.setex(key.getBytes(),timeout,bytes);
                return result;
            }finally {
                jedis.close();
            }

        }catch(Exception e){
            logger.error(e.getMessage(),e);
        }
        return "";
    }
}

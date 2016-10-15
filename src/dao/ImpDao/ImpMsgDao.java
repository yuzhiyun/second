package dao.ImpDao;

import dao.IDao.IMsgDao;
import dao.pojo.Message;
import dao.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yuzhiyun on 2016-10-10.
 */
public class ImpMsgDao implements IMsgDao {
    //
    Session session = null;

    /**
     * 真正开始存储进入数据库
     */
    @Override
    public Serializable save(Message msg) {
//        System.out.println("执行在 ");
        Serializable saveSerializable=null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            //用于判断是否save成功
            saveSerializable=session.save(msg);
            session.getTransaction().commit();
            return saveSerializable;
        } catch (RuntimeException re) {
            System.out.println("catch" + re.toString());
            re.printStackTrace();
            return null;
        }
//        System.out.println("执行在  session.getTransaction().commit();");
    }

    @Override
    public List findAll() {
        List list=null;
        System.out.println("查询结果*********************");
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            //这里表示从Message 这个类所对应的表中查询数据，这里不用直接写table name ，出发表名和类名一样
            String queryString = "from Message";
            Query query = session.createQuery(queryString);
             list = query.list();
            session.getTransaction().commit();
        } catch (RuntimeException re) {
            System.out.println("catch" + re.toString());
            re.printStackTrace();
        }
        return list;
    }
//

}

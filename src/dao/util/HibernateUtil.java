package dao.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/**
 * Created by yuzhiyun on 2016-10-10.
 */


    public class HibernateUtil {

        public static final SessionFactory sessionFactory=buildSessionFactory();

        @SuppressWarnings("deprecation")
        private static SessionFactory buildSessionFactory() {
            // TODO Auto-generated method stub
            System.out.print("buildSessionFactory");
            try {
                return new Configuration().configure().buildSessionFactory();
            } catch (HibernateException e) {
                System.out.print("HibernateException"+e.toString());
                e.printStackTrace();
            }
            return null;
        }
        public static SessionFactory getSessionFactory(){
            return sessionFactory;
        }
    }


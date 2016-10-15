package dao;

import dao.IDao.IMsgDao;
import dao.ImpDao.ImpMsgDao;

/**
 * Created by yuzhiyun on 2016-10-10.
 */
public class DaoFatory {

    public static  IMsgDao getMsgDao() {
        return new ImpMsgDao();
    }
}

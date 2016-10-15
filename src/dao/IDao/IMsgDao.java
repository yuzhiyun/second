package dao.IDao;

import dao.pojo.Message;

import javax.servlet.annotation.WebServlet;
import java.util.List;

/**
 * Created by yuzhiyun on 2016-10-10.
 */

public interface IMsgDao {
    public Object save(Message msg);
    public List findAll();
}

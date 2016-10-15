package service.IService;

import dao.pojo.Message;

import java.util.List;

/**
 * Created by yuzhiyun on 2016-10-10.
 */
public interface IMsgService {

    public Object save(Message msg);
    public List  findAll();

}

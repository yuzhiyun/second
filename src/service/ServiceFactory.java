package service;

import service.IService.IMsgService;
import service.ImpService.ImpMsgService;

/**
 * Created by yuzhiyun on 2016-10-10.
 */
public class ServiceFactory {
    public static IMsgService getMsgService() {
        return new ImpMsgService();
    }
}

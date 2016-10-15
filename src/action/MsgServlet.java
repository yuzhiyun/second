package action;

import dao.pojo.Message;
//import org.hibernate.Query;
import org.json.JSONArray;
import service.IService.IMsgService;
import service.ImpService.ImpMsgService;
import service.ServiceFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by yuzhiyun on 2016-10-10.
 */
@WebServlet("*.msg")
public class MsgServlet extends HttpServlet {

    //弹幕service接口
    IMsgService impMsgService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        System.out.print("访问MsgServlet成功" + req.getCharacterEncoding() + " " + resp.getCharacterEncoding());

        String temp = req.getServletPath().substring(1);
        String methodName = temp.substring(0, temp.length() - 4);

        Method method = null;
        try {
            method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

//        resp.sendRedirect("./index.jsp");
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) {

        String sMsg = req.getParameter("Message");
        Message msg = new Message();
        msg.setmMsgContent(sMsg + "");
        System.out.print(sMsg + "");
        impMsgService = ServiceFactory.getMsgService();
        Serializable serializable = (Serializable) impMsgService.save(msg);
        try {
            //判断是否插入成功
            if (serializable != null)
                resp.getWriter().print("success");
            else
                resp.getWriter().print("fail");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findAll(HttpServletRequest req, HttpServletResponse resp) {

        impMsgService = ServiceFactory.getMsgService();
        List list = impMsgService.findAll();
        JSONArray jsonArray = new JSONArray();

        //打印
        for (Object object : list) {
            jsonArray.put(((Message) object).getmMsgContent());
            System.out.println(((Message) object).getmMsgContent());
        }
        try {
            resp.getWriter().print(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package org.review.download;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * 下载专用
 * @author lijichen
 * @date 2020/10/13 - 14:02
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1，获取要下载的文件名
        String downloadFileName = "1中文.png";
        //2,读取要下载的文件内容（通过servletcontext对象可以读取）
        ServletContext servletContext = getServletContext();

        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/imgs/" + downloadFileName);
        System.out.println("下载的文件类型："+mimeType);
        //4，在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        //5，还要告诉客户端收到的数据是用于下载使用（还是使用响应头）
        //Content-Disposition表示响应头，表示收到的数据怎么处理
        //attachment表示附件
        //filename表示指定下载的文件名
//        resp.setHeader("Content-Disposition" , "attachment; filename=" + downloadFileName);
        //兼容中文编码
//        resp.setHeader("Content-Disposition" , "attachment; filename=" + URLEncoder.encode(downloadFileName,"UTF-8"));
        //火狐浏览器兼容，使用base64编码
//        resp.setHeader("Content-Disposition" , "attachment; filename==?UTF-8?B?"+new BASE64Encoder().encode(downloadFileName.getBytes("UTF-8")) +"?=");

        /*
        * 如果是火狐浏览器，使用base64编码
        * 否则使用url编码
        * */
        if (req.getHeader("User-Agent").contains("Firefox")) {
            //使用base64
            resp.setHeader("Content-Disposition" , "attachment; filename==?UTF-8?B?"+new BASE64Encoder().encode(downloadFileName.getBytes("UTF-8")) +"?=");
        } else {
            //使用url编码
            resp.setHeader("Content-Disposition" , "attachment; filename=" + URLEncoder.encode(downloadFileName,"UTF-8"));
        }

        /*
        * / 斜杠表示 被服务器解析的地址为http://ip:prot/工程名/ 映射到代码的web目录
        * */
        InputStream resourceAsStream = servletContext.getResourceAsStream("/imgs/" + downloadFileName);
        //获取响应的输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //读取输入流中全部的数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream,outputStream);

    }
}

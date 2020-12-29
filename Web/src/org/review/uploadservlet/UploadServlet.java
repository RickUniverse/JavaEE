package org.review.uploadservlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author lijichen
 * @date 2020/10/12 - 18:41
 */
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*ServletInputStream is = req.getInputStream();

        byte[] buffer = new byte[1024000];
        int read = is.read(buffer);
        System.out.println(new String(buffer,0,read));*/

        //使用第三方 jar包
        //1先判断上传的数据是否是多段数据，（只有多段数据才是文件上传的）
        if (ServletFileUpload.isMultipartContent(req)) {
            //2创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //3创建用于解析数据的ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //4解析上传的数据，得到每一个表单项fileItems
                List<FileItem> fileItems = servletFileUpload.parseRequest(req);
                //5循环判断，每一个表单项是普通类型还是上传的文件
                for (FileItem fileItem : fileItems) {
                    if (fileItem.isFormField()) {
                        //6普通表单项
                        System.out.println("表单项的name属性：" + fileItem.getFieldName());
                        //7参数解决乱码问题utf-8
                        System.out.println("表单项的value属性：" + fileItem.getString("UTF-8"));
                    } else {
                        //8上传的文件
                        System.out.println("表单项的name属性：" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());

                        //9保存到本地
                        fileItem.write(new File("e:\\" + fileItem.getName()));
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

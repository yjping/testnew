import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.util.List;

/**
 * @author yuanjiaping
 * @create 2018-10-22 16:29
 * @description TODO
 **/
public class UploadService {
    public void service(Request request, Response response){
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);

        List<FileItem> items = sfu.parseRequest(request);
        for(int i = 0; i < items.size(); i++){
            FileItem curr = items.get(i);
            if(curr.isFormField()){
                String fileName = curr.getName();
                String name = curr.getString();
            }else{
                ServletContext scxt = getServletContext();
                String path = scxt.getRealPath("upload");
                String fileName = curr.getName();
                File file = new File(path + "/" + fileName);
                curr.write(file); // 将curr中的内容保存在file中
            }
        }
    }

}

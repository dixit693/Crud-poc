package com.boot.restbookapi.helper;

import java.io.FileOutputStream;
import java.io.InputStream;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHepler {
    
    public final String UPLOAD_DIR = "E:\\sts_durgesh\\spring-boot-data-1\\src\\main\\resources\\static\\image";
    
    public boolean uploadFile(MultipartFile f) {
        boolean f1 = false;
        
        try {
            InputStream is = f.getInputStream();
            byte[] data = new byte[1024]; // Read in chunks to avoid memory issues
            int bytesRead;
            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + "\\" + f.getOriginalFilename());
            while ((bytesRead = is.read(data)) != -1) {
                fos.write(data, 0, bytesRead);
            }
            fos.flush();
            fos.close();
            f1 = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return f1;
    }
}

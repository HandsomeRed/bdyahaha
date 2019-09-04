package com.bd.service.imply;

import com.bd.action.Key_Value;
import com.bd.dao.ResourceDao;
import com.bd.entity.ResourceEntity;
import com.bd.entity.UserEntity;
import com.bd.service.ResourceService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class ResourceServiceImply implements ResourceService {

    private ResourceDao resourceDao;

    @Override
    public String saveResource(UserEntity user, File file, String fileFileName, ResourceEntity resource) {

        String path = Key_Value.fileUrl + Key_Value.enter + user.getId();
        String fileName = new Date().getTime() + Key_Value.spile + fileFileName;
        if (!uploadFile(file, path, fileName)) {
            return "fail";
        }

        resource.setAddr(path + Key_Value.enter + fileName);
        resource.setName(fileFileName);

        if (!resourceDao.addResurce(user, resource)) {
            File delete = new File(resource.getAddr());
            if (delete.exists()) delete.delete();
            return "fail";
        }

        return "success";

    }

    private Boolean uploadFile(File file, String path, String fileName) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        File save;
        try {

            fileInputStream = new FileInputStream(file);
            save = new File(path);
            if (!save.exists()) {
                save.mkdir();
            }

            fileOutputStream = new FileOutputStream(path + "\\" + fileName);
            byte[] bytes = new byte[1024];
            int i = 0;
            while ((i = fileInputStream.read(bytes)) > 0) {
                fileOutputStream.write(bytes, 0, i);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                assert fileOutputStream != null;
                fileOutputStream.close();
                fileOutputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }


    public ResourceDao getResourceDao() {
        return resourceDao;
    }

    public void setResourceDao(ResourceDao resourceDao) {
        this.resourceDao = resourceDao;
    }
}

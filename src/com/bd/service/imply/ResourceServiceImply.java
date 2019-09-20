package com.bd.service.imply;

import tool.Key_Value;
import com.bd.dao.ResourceDao;
import com.bd.entity.ResourceEntity;
import com.bd.entity.UserEntity;
import com.bd.service.ResourceService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ResourceServiceImply implements ResourceService {

    private ResourceDao resourceDao;

    @Override
    public String saveResource(UserEntity user, File file, String fileFileName, ResourceEntity resource) {

        String path = Key_Value.fileUrl + Key_Value.enter + user.getId();
        String fileName = new Date().getTime() + Key_Value.spile + fileFileName;
        //System.out.println(file.toURI().toString());
        if (!uploadFile(file, path, fileName)) {
            return "fail";
        }
        resource.setAddr(fileName);

        if (!resourceDao.addResource(user, resource)) {
            File delete = new File(resource.getAddr());
            if (delete.exists()) delete.delete();
            return "fail";
        }

        return "success";

    }

    @Override
    public List<ResourceEntity> getMyResources(UserEntity user, ResourceEntity resource) {

        return resourceDao.getResources(user, resource);

    }

    @Override
    public List<ResourceEntity> getResourceList(ResourceEntity resource) {

        return resourceDao.getResourceList(resource);
    }

    @Override
    public ResourceEntity getResource(ResourceEntity resource) {
        return resourceDao.getResource(resource);
    }

    @Override
    public String changeResourceInfor(ResourceEntity resource) {
        return resourceDao.changeResourceInfor(resource);
    }

    //保存文件 常见的 io 操作
    private Boolean uploadFile(File file, String path, String fileName) {

        FileInputStream fileInputStream = null; //输入流
        FileOutputStream fileOutputStream = null; //输出流
        File save; //文件保存地址
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
                if (fileOutputStream != null) fileOutputStream.close();
                if (fileInputStream != null) fileInputStream.close();
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

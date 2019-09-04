package com.bd.service;

import com.bd.entity.ResourceEntity;
import com.bd.entity.UserEntity;

import java.io.File;

public interface ResourceService {

    String saveResource(UserEntity user, File file, String fileFileName, ResourceEntity resource);
}

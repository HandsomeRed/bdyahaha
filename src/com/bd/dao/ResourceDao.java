package com.bd.dao;

import com.bd.entity.ResourceEntity;
import com.bd.entity.UserEntity;

public interface ResourceDao {

    boolean addResurce(UserEntity user, ResourceEntity resource);
}

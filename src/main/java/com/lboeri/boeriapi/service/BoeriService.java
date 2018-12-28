package com.lboeri.boeriapi.service;

import com.lboeri.boeriapi.dao.common.entity.ApiConfigEntity;

import java.util.List;

public interface BoeriService {
    ApiConfigEntity findApiConfig(String id);

}

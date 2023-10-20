package cn.yucheno8.day15_redis.service;

import cn.yucheno8.day15_redis.demain.Province;

import java.util.List;

public interface ProvinceService {
    public List<Province> findAll();

    public String findAllJson();
}

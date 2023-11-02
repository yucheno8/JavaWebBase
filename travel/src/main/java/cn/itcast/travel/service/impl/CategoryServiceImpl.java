package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {

        // 1.从redis中查询
        // 1.1 获取jedis的客户端
        Jedis jedis = JedisUtil.getJedis();
        // 1.2 可使用sortedset排序查询
        // Set<String> categroys = jedis.zrange("categroy", 0, -1);
        // 1.3 查询sortedset中的分数（cid）和值（cname）
        Set<Tuple> categroys = jedis.zrangeWithScores("categroy", 0, -1);


        List<Category> cs = null;
        // 2.判断查询的集合是否为空
        if (categroys == null || categroys.size() == 0) {

            System.out.println("从数据库查询...");
            // 3.如果为空，需要从数据库查询，再将数据存入redis
            // 3.1 从数据库查询
            cs = categoryDao.findAll();
            // 3.2 将集合数据存储到redis中的category的key
            for (int i = 0; i < cs.size(); i++) {
                jedis.zadd("categroy", cs.get(i).getCid(), cs.get(i).getCname());
            }
        } else {
            System.out.println("从redis中查询...");
            // 4.如果不为空，将set的数据存入list
            cs = new ArrayList<Category>();
            for (Tuple tuple : categroys) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int) tuple.getScore());
                cs.add(category);
            }
        }

        return cs;
    }
}

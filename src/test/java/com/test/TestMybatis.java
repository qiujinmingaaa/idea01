package com.test;

import com.dao.UserDao;
import com.domain.User;
import com.domain.User_simple;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @program: mybatis
 * @description:
 * @author:
 * @create: 2019-07-24 15:26
 **/
public class TestMybatis {
    SqlSessionFactoryBuilder builder;
    SqlSessionFactory sessionFactory;
    UserDao mapper;
    InputStream is;
    SqlSession sqlSession;

    @Before
    public void before() throws IOException {

        try {
            //创建对象
            builder= new SqlSessionFactoryBuilder();
            //加载主配置文件,转换成流

            is= Resources.getResourceAsStream("aaa.xml");
            //构建流工厂
            sessionFactory= builder.build(is);
            //通过工厂创建一个SQL对象
            sqlSession= sessionFactory.openSession();
            //通过动态代理获得Dao接口的处理对象
            mapper= sqlSession.getMapper(UserDao.class);
            //调用代理对象的方法

        } catch(Exception e) {

        }

    }

    @After
    public void after() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }
    @Test
    public void testFindAll() throws IOException {

            List<User> users = mapper.fundAll();
            for (User user : users) {
            System.out.println(user);
            }
    }

    @Test
    public void testaddUser(){
        User user = new User();
        /*user.setId(null);
        user.setUsername("李四");
        user.setSex("男");
        user.setAddress("北京");
        user.setBirthday(new Date());*/
        User user1 = new User(null, "王五", new Date(), "女","武汉" );
        mapper.addUser(user1);

    }

    @Test
    public void testdeleteAll() throws IOException {

        mapper.deleteUser(2);

    }

    @Test
    public void testupdateAll() throws IOException {
        User user = new User();
        user.setId(60);
        user.setUsername("李易峰");
        user.setAddress("美国");
        mapper.updateUser(user);

    }
    @Test
    public void testupdate01All() throws IOException {
        Map map =new HashMap<>();
        map.put("username","玉皇大帝");
        map.put("address","天庭");
        map.put("id",61);
        mapper.updateUser01(map);

    }

    @Test
    public void testfind01(){
        User user = mapper.findUserById(60);
        System.out.println(user);
    }
    @Test
    public void testfind02(){
        Map map = mapper.findMapById(61);
        System.out.println(map);
    }

    @Test
    public void testfind03(){
        String username = mapper.findUsername(1);
        System.out.println(username);
    }

    @Test
    public void testfind04(){
        int count = mapper.findCount();
        System.out.println(count);
    }

    @Test
    public void testfind05(){
        List<User> list = mapper.findUserByName("李");
        System.out.println(list);
    }
    @Test
    public void testfind06(){
        List<User> list = mapper.findUserByName01("李");
        System.out.println(list);
    }
    @Test
    public void testfind07(){
        List<User_simple> byName02 = mapper.findUserByName02("李");
        System.out.println(byName02);
    }


}

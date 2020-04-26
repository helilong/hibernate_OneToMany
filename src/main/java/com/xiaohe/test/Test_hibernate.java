package com.xiaohe.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.xiaohe.pojo.User;

public class Test_hibernate {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();
		s.beginTransaction();

		User u = new User();
		u.setUsername("xiaohe");
		u.setPassword("123456");
		u.setAddress("dali");
		s.save(u);
		//¹Ø±Õ
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}

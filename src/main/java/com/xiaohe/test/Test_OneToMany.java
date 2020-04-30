package com.xiaohe.test;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.xiaohe.entity.Customer;
import com.xiaohe.entity.LinkMan;
import com.xiaohe.utils.HibernateUtils;
import org.junit.Test;

public class Test_OneToMany {
	//һ�Զ�ļ����������
	
	//��һ�ַ���
	@Test
	public void Test1() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//�õ�sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			//�õ�session
			session = sessionFactory.openSession();
			//��������
			tx = session.beginTransaction();
			
			// ���һ���ͻ���Ϊ����ͻ����һ����ϵ��
			//1 �����ͻ�����ϵ�˶���
			Customer customer = new Customer();
			customer.setCustName("xiaohe");
			customer.setCustLevel("vip");
			customer.setCustSource("xiaohe2");
			customer.setCustPhone("110");
			customer.setCustMobile("999");
			
			LinkMan linkman = new LinkMan();
			linkman.setLkm_name("lucy");
			linkman.setLkm_gender("nan");
			linkman.setLkm_phone("911");
			
			//2 �ڿͻ���ʾ������ϵ�ˣ�����ϵ�˱�ʾ�ͻ�		
			// �����ͻ��������ϵ�˶����ϵ
			//2.1 ����ϵ�˶��� �ŵ��ͻ������set��������
			customer.getSetLinkMan().add(linkman);
			//2.2 �ѿͻ�����ŵ���ϵ������
			linkman.setCustomer(customer);
			
			//3 ���浽���ݿ�
			session.save(customer);
			session.save(linkman);
			
			//�ύ����
			tx.commit();

		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			//sessionFactory����Ҫ�ر�
			sessionFactory.close();
		}
		
	}
	//�ڶ��ַ���
	@Test
	public void Test2() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//�õ�sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			//�õ�session
			session = sessionFactory.openSession();
			//��������
			tx = session.beginTransaction();
			
			// ���һ���ͻ���Ϊ����ͻ����һ����ϵ��
			//1 �����ͻ�����ϵ�˶���
			Customer customer = new Customer();
			customer.setCustName("baidu");
			customer.setCustLevel("pt");
			customer.setCustSource("wl");
			customer.setCustPhone("110");
			customer.setCustMobile("999");
			
			LinkMan linkman = new LinkMan();
			linkman.setLkm_name("xiaohong");
			linkman.setLkm_gender("nan");
			linkman.setLkm_phone("911");
			
			//2 ����ϵ�˷ŵ��ͻ�����
			customer.getSetLinkMan().add(linkman);
			
			//3 ����ͻ�    ʹ�ü�������
			//cascade="save-update,delete"����������
			session.save(customer);
			
			//�ύ����
			tx.commit();

		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			//sessionFactory����Ҫ�ر�
			sessionFactory.close();
		}
		
	}

	
	//һ�Զ�ļ���ɾ��
	@Test
	public void TestDelete() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//�õ�sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			//�õ�session
			session = sessionFactory.openSession();
			//��������
			tx = session.beginTransaction();
			
			// 1 ����id��ѯ�ͻ�����
			Customer customer = session.get(Customer.class, 2);
			//2 ���÷���ɾ��
			session.delete(customer);
			
			//�ύ����
			tx.commit();

		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			//sessionFactory����Ҫ�ر�
			sessionFactory.close();
		}
	}

	//һ�Զ�ļ������
	@Test
	public void TestUpdate() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//�õ�sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			//�õ�session
			session = sessionFactory.openSession();
			//��������
			tx = session.beginTransaction();
			
			//1 ����id��ѯlucy��ϵ�ˣ�����id��ѯ�ٶȵĿͻ�
			Customer baidu = session.get(Customer.class, 1);
			LinkMan lucy = session.get(LinkMan.class, 1);
			//2 ���ó־�̬����ֵ
			//����ϵ�˷ŵ��ͻ�����
			baidu.getSetLinkMan().add(lucy);
			//�ѿͻ��ŵ���ϵ������
			lucy.setCustomer(baidu);
			
			//�ύ����
			tx.commit();

		}catch(Exception e) {
			tx.rollback();
		}finally {
			session.close();
			//sessionFactory����Ҫ�ر�
			sessionFactory.close();
		}
	}
		
}


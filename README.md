#  ������Ϣ
1.jdk 1.8
2. tomcat   8.5

# ����
### 1.hibernate��һ�Զ�ļ�����ѯ
###	2.hibernate��һ�Զ�ļ���ɾ��
### 3.hibernate��һ�Զ�ļ������
###

```
/�¶�ɾ�� ���Ѳ����������Ա�����Ƴ� �� ��Ա���Ӽ���ɾ�� 
		//��Ϊ���Ż���֪���Լ���Ա��
		
//		deptInfo.setEmpinfos(null);
//		session.delete(deptInfo);
//		
//		deptInfo.setEmpinfos( new HashSet<EmpInfo>());
//		
//		session.delete(deptInfo);
//			
		Set<EmpInfo> empInfos=deptInfo.getEmpinfos();
		Iterator<EmpInfo> it=empInfos.iterator();
		while(it.hasNext()){
			
			it.next();
			it.remove();
		}	
		ts.commit();
		session.close();
		
		
```
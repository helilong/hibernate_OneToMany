#  配置信息
1.jdk 1.8
2. tomcat   8.5

# 内容
### 1.hibernate的一对多的级联查询
###	2.hibernate的一对多的级联删除
### 3.hibernate的一对多的级联添加
###

```
/孤儿删除 （把部门里的所有员工都移除 ） 把员工从集合删除 
		//因为部门还不知道自己的员工
		
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
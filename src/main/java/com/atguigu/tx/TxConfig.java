package com.atguigu.tx;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;
import org.springframework.transaction.annotation.TransactionManagementConfigurationSelector;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ����ʽ����
 * 
 * �������
 * 1�������������
 * 		����Դ�����ݿ�������Spring-jdbcģ��
 * 2����������Դ��JdbcTemplate��Spring�ṩ�ļ����ݿ�����Ĺ��ߣ���������
 * 3���������ϱ�ע @Transactional ��ʾ��ǰ������һ�����񷽷���
 * 4�� @EnableTransactionManagement ��������ע�����������ܣ�
 * 		@EnableXXX
 * 5�������������������������;
 * 		@Bean
 * 		public PlatformTransactionManager transactionManager()
 * 
 * 
 * ԭ��
 * 1����@EnableTransactionManagement
 * 			����TransactionManagementConfigurationSelector�������лᵼ�����
 * 			�����������
 * 			AutoProxyRegistrar
 * 			ProxyTransactionManagementConfiguration
 * 2����AutoProxyRegistrar��
 * 			��������ע��һ�� InfrastructureAdvisorAutoProxyCreator �����
 * 			InfrastructureAdvisorAutoProxyCreator����  
 *               (��AOPע��ʵ���е�AnnotationAwareAspectJAutoProxyCreatorһ�����̳�AbstractAutoProxyCreator implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware)
 * 			���ú��ô����������ڶ��󴴽��Ժ󣬰�װ���󣬷���һ�����������ǿ�������������ִ�з������������������е��ã�
 * 
 * 3����ProxyTransactionManagementConfiguration ����ʲô��
 * 			1����������ע��������ǿ����
 * 		        BeanFactoryTransactionAttributeSourceAdvisor advisor = new BeanFactoryTransactionAttributeSourceAdvisor();
				advisor.setTransactionAttributeSource(transactionAttributeSource());
				advisor.setAdvice(transactionInterceptor());
				advisor.setOrder(this.enableTx.<Integer>getNumber("order"));
 * 				1����������ǿ��Ҫ������ע�����Ϣ��AnnotationTransactionAttributeSource �������н�������ע�� SpringTransactionAnnotationParser
 * 				2����������ǿ��������������������advisor.setAdvice(transactionInterceptor());
 * 					TransactionInterceptor������������������Ϣ�������������
 * 					����һ�� MethodInterceptor��
 * 					��Ŀ�귽��ִ�е�ʱ��
 * 						ִ������������
 * 						������������
 * 							1�����Ȼ�ȡ������ص�����
 * 							2�����ٻ�ȡPlatformTransactionManager���������û�����ָ���κ�transactionmanger
 * 								���ջ�������а������ͻ�ȡһ�� PlatformTransactionManager��
 * 							3����ִ��Ŀ�귽��: retVal = invocation.proceedWithInvocation();
 * 								����쳣����ȡ������������������������ع�������completeTransactionAfterThrowing(txInfo, ex);
 * 								�������������������������ύ����  commitTransactionAfterReturning(txInfo);
 * 			
 */
@EnableTransactionManagement
@ComponentScan("com.atguigu.tx")
@Configuration
public class TxConfig {
	
	//����Դ
	@Bean
	public DataSource dataSource() throws Exception{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("scott");
		dataSource.setPassword("tiger");
		dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
		dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:ORA8");
		return dataSource;
	}
	
	//
	@Bean
	public JdbcTemplate jdbcTemplate() throws Exception{
		//Spring��@Configuration������⴦���������м�����ķ�������ε��ö�ֻ�Ǵ������������
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
	
	//ע�������������������
	@Bean
	public PlatformTransactionManager transactionManager() throws Exception{
		return new DataSourceTransactionManager(dataSource());
	}
	

}

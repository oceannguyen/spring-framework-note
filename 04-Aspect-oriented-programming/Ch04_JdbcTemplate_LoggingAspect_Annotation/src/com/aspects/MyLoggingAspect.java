package com.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

	Logger logger = Logger.getLogger(getClass());

	@Pointcut(value = "execution(* com.dao.BookDAO.addBook(com.beans.Book))")
	public void selectAdd() {
	}

	@Pointcut(value = "execution(* com.dao.BookDAO.*(..))")
	public void selectAll() {
	}

	@Pointcut(value = "execution(int com.dao.BookDAO.*(..))")
	public void selectAddOrUpdate() {

	}

	// @Before("selectAdd()")
	public void beforeAdvise(JoinPoint joinPoint) {
		logger.info("method will be invoked :-" + joinPoint.getSignature());
	}

	// @After("selectAll()")
	public void afterAdvise(JoinPoint joinPoint) {
		logger.info("executed successfully :-" + joinPoint.getSignature());
	}

	// @AfterThrowing("selectAdd()")
	public void throwingAdivse(JoinPoint joinPoint, Exception exception) {
		logger.info(joinPoint.getSignature() + " got and exception " + "\t" + exception);
	}

	// @Around("selectAddOrUpdate()")
	public int aroundAdvise(ProceedingJoinPoint joinPoint) {
		long startTime = System.currentTimeMillis();
		logger.info("around advise before " + joinPoint.getSignature() + " method getting invoked");

		Integer o = null;
		try {
			o = (Integer) joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		logger.info("around advise after " + joinPoint.getSignature() + " method getting invoked");
		long endTime = System.currentTimeMillis();
		logger.info(joinPoint.getSignature() + " took " + (endTime - startTime) + " to complete");

		return o.intValue();
	}

	@AfterReturning(pointcut = "selectAll()", returning = "val")
	public void returnAdvise(JoinPoint joinPoint, Object val) {
		logger.info(joinPoint.getSignature() + " returning val:-" + val);
	}

}

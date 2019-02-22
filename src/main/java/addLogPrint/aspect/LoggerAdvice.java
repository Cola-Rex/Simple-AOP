package addLogPrint.aspect;

import java.time.LocalDateTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import addLogPrint.util.LoggerManage;

/**
 * 	日志切面
 */
@Aspect
@Component
public class LoggerAdvice {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("within(addLogPrint..*) && @annotation(loggerManage)")
	public void addBeforeLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
		LocalDateTime now = LocalDateTime.now();
		
		logger.info(now.toString() + "执行[" + loggerManage.logDescription() + "]开始");
		logger.info(joinPoint.getSignature().toString());
		
		logger.info(parseParams(joinPoint.getArgs()));
	}
	
	@AfterReturning("within(addLogPrint..*) && @annotation(loggerManage)")
	public void addAfterReturningLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
		LocalDateTime now = LocalDateTime.now();
		logger.info(now.toString()+"执行 [" + loggerManage.logDescription() + "] 结束");
	}
	
	private String parseParams(Object[] params) {
		if (null == params || params.length <= 0) {
			return "";
		}
		
		StringBuffer param = new StringBuffer("传入参数 # 个：[ ");
		int i = 0;
		for (Object obj : params) {
			i++;
			if (i == 1) {
				param.append(obj.toString());
				continue;
			}
			param.append(" ,").append(obj.toString());
		}
		return param.append(" ]").toString().replace("#", String.valueOf(i));
	}
	
}

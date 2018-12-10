package kr.AJ.valet.commUtil;

import java.lang.reflect.Method;

public class MethodControll {

	public static Method getMethod(Object bean, String methodName) throws Exception {
		Method[] methods = bean.getClass().getMethods();
		for (int inx = 0; inx < methods.length; inx++) {
			if (methods[inx].getName().equals(methodName)) {
				return methods[inx];
			}
		}
		throw new Exception("Can't find " + methodName + ".");
	}
}

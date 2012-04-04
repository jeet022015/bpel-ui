package be.ac.precise.usixml.androidapp.util;

import java.lang.reflect.Field;

public class R_Util {

	public static final int VALUE_UNDEFINED = -1;

	public static int getStaticValue(Class<?> rClass, String fieldName){
		try {
			Field my_id = rClass.getField(fieldName);
			
			return (Integer) my_id.get(null);
		} catch (Exception e) {
			//e.printStackTrace();
			return VALUE_UNDEFINED;
		}
	}
}

package typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {
	public static void main(String[] args) {
		  // 取得Class物件方法1
	    Class clazz = User.class;
	    
	    // 取得Class物件方法2
	    clazz = new User().getClass();
	    
	    // 取得Class物件方法3
	    try {
	      clazz = Class.forName("typeinfo.User");
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    }
	    
	    // 類別名稱(含package名稱)
	    System.out.println("class coanonical name : " + clazz.getCanonicalName()); 
	    
	    // 類別名稱
	    System.out.println("class simple name : " + (clazz.getSimpleName()));
	    
	    // package名稱
	    System.out.println("class package : " + clazz.getPackage().getName());
	    
	    // modifier名稱
	    System.out.println("class modifiers : " + Modifier.toString(clazz.getModifiers()));
	    
	    // 建構式名稱
	    Constructor[] constructors = clazz.getConstructors();
	    for(int i = 0 ; i < constructors.length ; i++) {
	      System.out.println("constructors" + i + " : " + constructors[i].getName());
	    }
	    
	    // 屬性/成員變數名稱
	    Field[] fields = clazz.getDeclaredFields();
	    for(int i = 0 ; i < fields.length ; i++) {
	      System.out.println("field" + i + " : " + fields[i].getName());
	    }
	    
	    // 方法名稱
	    Method[] methods = clazz.getDeclaredMethods();
	    for(int i = 0 ; i < methods.length ; i++) {
	      System.out.println("method" + i + " : " + methods[i].getName());
	    }
		
	}
}

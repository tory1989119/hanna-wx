package com.hanna.wx.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

import javax.servlet.ServletInputStream;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 解析接收到的微信xml，返回消息对象
 * 
 * @author pamchen-1
 * 
 */
public class ParseMessageXml {

	/**
	 * 解析微信xml消息
	 * 
	 * @param <T>
	 * 
	 * @param strXml
	 * @return
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public static <T> T format2Object( ServletInputStream in ) {

		T obj = null;
		String strXml = "";
		try {
			strXml = IOUtils.toString( in );
			if( strXml.length() <= 0 || strXml == null )
				return null;

			// 将字符串转化为XML文档对象
			Document document = DocumentHelper.parseText( strXml );
			// 获得文档的根节点
			Element root = document.getRootElement();
			// 遍历根节点下所有子节点
			Iterator<?> iter = root.elementIterator();

			// 遍历所有结点
			// 利用反射机制，调用set方法
			// 获取该实体的元类型
			Class<?> c = Class.forName( "com.hanna.wx.model.WxInMessage" );
			obj = ( ( T )c.newInstance() );// 创建这个实体的对象

			while( iter.hasNext() ) {
				Element ele = ( Element )iter.next();
				// 获取set方法中的参数字段（实体类的属性）
				Field field = c.getDeclaredField( ele.getName() );
				// 获取set方法，field.getType())获取它的参数数据类型
				Method method = c.getDeclaredMethod( "set" + ele.getName(), field.getType() );
				Class[] params = method.getParameterTypes();
				// 调用set方法
				if( params[ 0 ].equals( java.lang.Long.class ) ) {
					method.invoke( obj, Long.parseLong( ele.getText() ) );
				} else if( params[ 0 ].equals( java.lang.Integer.class ) ) {
					method.invoke( obj, Integer.parseInt( ele.getText() ) );
				} else if( params[ 0 ].equals( java.lang.Double.class ) ) {
					method.invoke( obj, Double.parseDouble( ele.getText() ) );
				} else {
					method.invoke( obj, ele.getText() );
				}

			}
		} catch( Exception e ) {
			// TODO: handle exception
			System.out.println( "xml 格式异常: " + strXml );
			e.printStackTrace();
		}
		return obj;
	}

}

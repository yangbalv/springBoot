package com.springboot.live_comm.utils;

import java.util.UUID;

/***
 * 
 * @author zhangjian
 *	用于生成数据库表中的id（使用UUID）
 */
public class IdGeneratedUtil {
	
	/**生成数据库表中的主键id*/
	public static String generateId(){
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		return id;
	}

	/**
	 *
	 * @param recommId
	 * @param recommName
	 * @param recommPhone
	 * @param hostaddress
	 * @return
	 */
	public static String recomUrlGenerate(String recommId,String recommName,String recommPhone,String hostaddress) {

		// 生成推荐链接
		StringBuilder recommUrl = new StringBuilder(hostaddress);
		/*recommUrl.append("/card/apply/index/recomm.html")
				.append("?recommId=").append(recommId)
				.append("&recommName=").append(recommName)
				.append("&recommPhone=").append(recommPhone)
				.append("&recommendDate=").append(System.currentTimeMillis());*/
		//跳转广告页
		recommUrl.append("/creditcard/mgm/recomm.html")
				.append("?recommId=").append(recommId)
				.append("&recommPhone=").append(recommPhone);
		return recommUrl.toString();
	}
}

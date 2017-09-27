/**
 * 
 */
package com.local.WebSpider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.local.WebSpider.zhihu.PicFilePipeline;
import com.local.WebSpider.zhihu.PicProcessor;
import com.local.WebSpider.zhihu.PicSeleniumDownloader;
import com.local.WebSpider.zhihu.PicSpider;
import com.local.utils.Constants;


/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年9月15日
 */
public class StartSpider {
	
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String args[]) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
		PicSpider.create(new PicProcessor())
		.addUrl(Constants.STARURL)
		.addPipeline(new PicFilePipeline(Constants.SAVEPATH))
		.setDownloader(new PicSeleniumDownloader()
							.setPageSize(Integer.valueOf(Constants.DEEPPAGESIZE))
							.setSleepTime(Integer.valueOf(Constants.SLEEPTIME)))
		.thread(Integer.valueOf(Constants.THREADNUM))
		.run();
	}
}

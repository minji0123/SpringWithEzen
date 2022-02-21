package com.spstep03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class MemberServiceMain {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("member.xml"));
		MemberService memberService = (MemberService)factory.getBean("memberService");
		memberService.getMembers();
	}

}

package com.ait.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailsender;
	
	public void sendEmailWithAttachment(String toEmail,String subject, String body, String Attachment) throws MessagingException{
		 MimeMessage mimeMessage = mailsender.createMimeMessage();
	        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true );
	        
			mimeMessageHelper.setFrom("vijayabandha22@gmail.com"); //we have to provide company project mail as per project
			mimeMessageHelper.setTo(toEmail);    //sender mail id
			mimeMessageHelper.setText(body);
			mimeMessageHelper.setSubject(subject);
			
			FileSystemResource file = new FileSystemResource(Attachment);
			mimeMessageHelper.addAttachment(file.getFilename(), file);
			
			mailsender.send(mimeMessage);
			System.out.println("mail sent success with attachement");
		}

	
	}
	



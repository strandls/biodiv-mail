package com.strandls.mail.util;

import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TemplateUtil {
	
	private Configuration configuration;
	
	public TemplateUtil(Configuration configuration) {
		this.configuration = configuration;
		this.configuration.setClassForTemplateLoading(getClass(), "/templates/");
	}
	
	public String getTemplateAsString(String templateFile, Map<String, Object> model) {
		Template template = null;
		StringWriter writer = new StringWriter();
		try {
			template = configuration.getTemplate(templateFile);
			template.process(model, writer);	
		} catch (Exception ex) {	
			ex.printStackTrace();
		}
		return writer.toString();			
	}

}

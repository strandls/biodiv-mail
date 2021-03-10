package com.strandls.mail.util;

import java.io.StringWriter;
import java.util.Map;

import javax.inject.Inject;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TemplateUtil {

	@Inject
	private Configuration configuration;

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

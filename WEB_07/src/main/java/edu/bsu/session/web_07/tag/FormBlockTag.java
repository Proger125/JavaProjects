package edu.bsu.session.web_07.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class FormBlockTag extends TagSupport {

    private String name;

    private String type;

    private String valueName;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            if (name.equals("house-number") && !valueName.isBlank()) {
                int houseNumber = Integer.parseInt(valueName);
            }
            JspWriter out = pageContext.getOut();
            out.write("<div class=\"form-block\">\n" +
                    "<label for=\"" + name + "\" >");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            out.write("</label>" +
                    "<input type=\"" + type + "\" id=\"" + name + "\" name=\"" + name + "\" value=\"" + valueName + "\">\n" +
                    "</div>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return EVAL_PAGE;
    }
}

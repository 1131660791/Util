/**
 * 
 */
package util.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import util.taglib.base.CodeTableValue;

/**
 * 基础码表类<!-- 使用标签引入 -->
 * 
 * @author hzw
 * @version 1.0,2013/1/8
 */
public class CodeTableTagLib extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

	private String id; // select 主键

	private String name; // 加载数据的类型

	private String selected; // 选中的元素

	private String onchange; // select的事件

	private Boolean showall = true; // 是否显示请选择

	private Integer state = 0;// 显示状态

	private String disabled = null;

	private String classStyle = null; // select 样式

	public int doStartTag() throws JspTagException {
		return EVAL_BODY_BUFFERED;
	}

	public void setBodyContent(BodyContent bodyContent) {
		this.bodyContent = bodyContent;
	}

	/**
	 * @see 执行完BODY后要干的事情
	 */
	public int doAfterBody() throws JspTagException {

		StringBuffer sb = new StringBuffer();

		sb.append("<select");

		if (id != null && !id.trim().equals("")) {
			sb.append(" id='" + id + "'");
		}

		if (onchange != null && !onchange.trim().equals("")) {
			sb.append(" onchange='" + onchange + "'");
		}

		if (classStyle != null && !classStyle.trim().equals("")) {
			sb.append(" class='" + classStyle + "'");
		}

		if (disabled != null) {
			sb.append("  disabled='disabled'");
		}

		sb.append(">");

		if (showall) {
			if (state == 0) {
				sb.append("<option value=''>请选择</option>");
			} else if (state == 1) {
				sb.append("<option value=''>全部</option>");
			}

		}

		if (name != null && !name.trim().equals("")) {
			String[] value_array = null;
			if (name.trim().equalsIgnoreCase("XB")) {
				value_array = CodeTableValue.XB_LIST;
			} else if (name.trim().equalsIgnoreCase("ZGMZ")) {
				value_array = CodeTableValue.ZGMZ_LIST;
			} else if (name.trim().equals("KS")) {
				value_array = CodeTableValue.KS_LIST;
			} else if (name.trim().equals("ZZMM")) {
				value_array = CodeTableValue.ZZMM_LIST;
			} else if (name.trim().equals("XL")) {
				value_array = CodeTableValue.XL_LIST;
			} else if (name.trim().equals("XW")) {
				value_array = CodeTableValue.XW_LIST;
			} else if (name.trim().equalsIgnoreCase("HYZK")) {
				value_array = CodeTableValue.HYZK_LIST;
			} else if (name.trim().equalsIgnoreCase("JKONE")) {
				value_array = CodeTableValue.JKONE_LIST;
			} else if (name.trim().equalsIgnoreCase("CYQK")) {
				value_array = CodeTableValue.CYQK_LIST;
			} else if (name.trim().equalsIgnoreCase("XL")) {
				value_array = CodeTableValue.XL_LIST;
			} else if (name.trim().equalsIgnoreCase("ZZMM")) {
				value_array = CodeTableValue.ZZMM_LIST;
			} else if (name.trim().equalsIgnoreCase("GBZW")) {
				value_array = CodeTableValue.GBZW_LIST;
			} else if (name.trim().equalsIgnoreCase("ZGZT")) {
				value_array = CodeTableValue.ZGZT_LIST;
			} else if (name.trim().equalsIgnoreCase("ZJXY")) {
				value_array = CodeTableValue.ZJXY_LIST;
			} else if (name.trim().equalsIgnoreCase("HKLB")) {
				value_array = CodeTableValue.HKLB_LIST;
			} else if (name.trim().equalsIgnoreCase("ZWJB")) {
				value_array = CodeTableValue.ZWJB_LIST;
			} else if (name.trim().equalsIgnoreCase("GBZW")) {
				value_array = CodeTableValue.GBZW_LIST;
			} else if (name.trim().equalsIgnoreCase("ZWBD")) {
				value_array = CodeTableValue.ZWBD_LIST;
			} else if (name.trim().equalsIgnoreCase("MZFS")) {
				value_array = CodeTableValue.MZFS_LIST;
			} else if (name.trim().equalsIgnoreCase("RZFS")) {
				value_array = CodeTableValue.RZFS_LIST;
			} else if (name.trim().equalsIgnoreCase("RZZT")) {
				value_array = CodeTableValue.RZZT_LIST;
			} else if (name.trim().equalsIgnoreCase("ZZYC")) {
				value_array = CodeTableValue.ZZYC_LIST;
			} else if (name.trim().equalsIgnoreCase("XX")) {
				value_array = CodeTableValue.XX_LIST;
			} else if (name.trim().equalsIgnoreCase("PYFS")) {
				value_array = CodeTableValue.PYFS_LIST;
			}
			for (int i = 0; i < value_array.length; i++) {
				String value = value_array[i];
				if (selected != null && selected.trim().equals(value)) {
					sb.append("<option value='" + value + "' selected='true'>");
				} else {
					sb.append("<option value='" + value + "'>");
				}
				sb.append(value + "</option>");
			}
		}

		sb.append("</select>");

		// 输出标签数据
		JspWriter jw = this.bodyContent.getEnclosingWriter();
		try {
			jw.println(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspTagException {

		return EVAL_PAGE;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public Boolean getShowall() {
		return showall;
	}

	public void setShowall(Boolean showall) {
		this.showall = showall;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getClassStyle() {
		return classStyle;
	}

	public void setClassStyle(String classStyle) {
		this.classStyle = classStyle;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}

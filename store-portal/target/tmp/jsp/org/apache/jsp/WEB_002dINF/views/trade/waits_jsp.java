package org.apache.jsp.WEB_002dINF.views.trade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class waits_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>未处理订单</title>\r\n");
      out.write("\t<script  type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t$(function() {\r\n");
      out.write("   \t\t// Loading 按钮\r\n");
      out.write("\t\t$('#loadingDiv')\r\n");
      out.write("\t\t.hide()\r\n");
      out.write("\t\t.ajaxStart(function() {\r\n");
      out.write("\t\t    $(this).show();\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t.ajaxStop(function() {\r\n");
      out.write("\t\t    $(this).hide();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tfunction delayEnable(time){\r\n");
      out.write("\t    var hander = setInterval(function () {\r\n");
      out.write("\t    \ttime--;\r\n");
      out.write("        if (time > 0) {\r\n");
      out.write("        \t$('#info').text('重新抓单需等待' +time+'秒');\r\n");
      out.write("        } else {\r\n");
      out.write("        \tclearInterval(hander);\r\n");
      out.write("        \t$('#info').text(' 抓取未处理交易订单（买家已付款等待商家发货）');\r\n");
      out.write("\t        $('.btn').attr('disabled',false);\r\n");
      out.write("        }\r\n");
      out.write("\t    }, 1000);\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction fetchTrade(day) {\r\n");
      out.write("\t\t$('.btn').attr('disabled',true);\r\n");
      out.write("\t\tdelayEnable(10);\r\n");
      out.write("\t\tvar action = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/trade/waits/fetch?preday=\" + day;\r\n");
      out.write("\t\thtmlobj=$.ajax({\r\n");
      out.write("\t\t\turl:action,\r\n");
      out.write("\t\t\tasync:true,\r\n");
      out.write("\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\tsuccess: function(msg) {\r\n");
      out.write("               $(\"#fetchBody\").html(htmlobj.responseText);\r\n");
      out.write("            },\r\n");
      out.write("\t\t\terror: function(XMLHttpRequest, textStatus, errorThrown) {\r\n");
      out.write("            }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t  <div class=\"span3\">\r\n");
      out.write("\t  \t  <button onclick=\"javascript:fetchTrade(0)\" class=\"btn btn-primary\"> 今 天 </button>\r\n");
      out.write("\t  \t  <button onclick=\"javascript:fetchTrade(1)\" class=\"btn btn-primary\"> 昨 天 </button>\r\n");
      out.write("\t  \t  <button onclick=\"javascript:fetchTrade(-1)\" class=\"btn btn-primary\">最近一周</button>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t  <div id=\"info\" class=\"span4 alert alert-info\">\r\n");
      out.write("\t\t  抓取未处理交易订单（买家已付款等待商家发货）\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"fetchBody\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"loadingDiv\" class=\"hint hide\">\r\n");
      out.write("\t\t<img src = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/images/fetch.gif\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("ctx");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }
}

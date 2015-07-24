package org.apache.jsp.WEB_002dINF.views.item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class itemAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/bootstrap-plugin-js/bootstrap-tab.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-validation/1.10.0/jquery.validate.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-validation/1.10.0/jquery.validate.ext.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-validation/1.10.0/validate.css\" type=\"text/css\" rel=\"stylesheet\" />\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t//聚焦第一个输入框\r\n");
      out.write("\t\t\t$(\"#item_title\").focus();\r\n");
      out.write("\t\t\t//为inputForm注册validate函数\r\n");
      out.write("\t\t\t$(\"#inputForm\").validate();\r\n");
      out.write("\t\t\t// 同步按钮\r\n");
      out.write("\t\t\t$('#btn_sycn').click(function () {\r\n");
      out.write("\t        \tvar btn = $(this);\r\n");
      out.write("\t\t        btn.button('loading');\r\n");
      out.write("\t\t        $('#sync_result').html(\" loading ....\");\r\n");
      out.write("\t\t        sync();\r\n");
      out.write("\t\t    });\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction sync() {\r\n");
      out.write("\t\t\t$.ajax({ \r\n");
      out.write("                type: 'get', \r\n");
      out.write("                url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/rest/item/sync',\r\n");
      out.write("                success: function() {\r\n");
      out.write("                \t$('#btn_sycn').button('reset');\r\n");
      out.write("                \t$('#sync_result').html(\"同步成功\");\r\n");
      out.write("                },\r\n");
      out.write("                error:function() {\r\n");
      out.write("\t                $('#btn_sycn').button('reset');\r\n");
      out.write("\t                $('#sync_result').html(\"同步失败\");\r\n");
      out.write("                }\r\n");
      out.write("        \t}); \r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<legend><small>添加商品</small></legend>\r\n");
      out.write("\r\n");
      out.write("\t<ul class=\"nav nav-tabs\">\r\n");
      out.write("\t  <li class=\"active\"><a href=\"#single\" data-toggle=\"tab\">添加单个商品</a></li>\r\n");
      out.write("\t  <li><a href=\"#upload\" data-toggle=\"tab\">批量上传商品</a></li>\r\n");
      out.write("\t  <li><a href=\"#import\" data-toggle=\"tab\">同步淘宝商品</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t\r\n");
      out.write("    <div class=\"tab-content\">\r\n");
      out.write("    \t\r\n");
      out.write("    \t<!-- 单个商品添加 -->\r\n");
      out.write("    \t<div class=\"tab-pane active\" id=\"single\">\r\n");
      out.write("\t\t<form id=\"inputForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/item/create\" method=\"post\" class=\"form-horizontal\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"type\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.type}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t<label for=\"item_title\" class=\"control-label\">商品名称:</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"title\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input-large required\" minlength=\"3\"/>\r\n");
      out.write("\t\t\t\t\t\t<p class=\"help-block\">商品标题 如A3时尚春款修身打底衫T恤 </p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t<label class=\"control-label\">商品编号（条形码）:</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"code\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.code}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input-large required\" minlength=\"8\"/>\r\n");
      out.write("\t\t\t\t\t\t<p class=\"help-block\">SKU对应的商品条形码</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t<label class=\"control-label\">sku(属性):</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"sku\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.sku}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input-large\"/>\r\n");
      out.write("\t\t\t\t\t\t<p class=\"help-block\">如 长袖13180 尺寸:XL; 颜色:天蓝色</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t<label class=\"control-label\">重量（单位：克）:</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"weight\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.weight}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input-large required digits\" minlength=\"1\" />\r\n");
      out.write("\t\t\t\t\t\t<p class=\"help-block\">商品重量（带包装），用于结算快递费用。</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t\t<label for=\"item_title\" class=\"control-label\">描述:</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t\t\t<textarea id=\"description\" name=\"description\" class=\"input-large\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t<div class=\"form-actions\">\r\n");
      out.write("\t\t\t\t\t<input id=\"submit_btn\" class=\"btn btn-primary\" type=\"submit\" value=\"提交\"/>&nbsp;\t\r\n");
      out.write("\t\t\t\t\t<input id=\"cancel_btn\" class=\"btn\" type=\"button\" value=\"返回\" onclick=\"history.back()\"/>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t</div>    \r\n");
      out.write("    \r\n");
      out.write("    \t<!-- 批量商品上传 -->\r\n");
      out.write("    \t<div class=\"tab-pane\" id=\"upload\">\r\n");
      out.write("\t\t<form id=\"uploadForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/item/upload\" method=\"post\" enctype=\"multipart/form-data\" class=\"form-horizontal\">\r\n");
      out.write("\t\t<fieldset>\r\n");
      out.write("\t\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" name=\"file\"/> \r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/download/item.xls\" class=\"\">下载商品模板 <small>(商品模板.xls)</small></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\t\r\n");
      out.write("\t\t\t<div class=\"form-actions\">\r\n");
      out.write("\t\t\t\t<input id=\"submit_btn\" class=\"btn btn-primary\" type=\"submit\" value=\"提交\"/>&nbsp;\t\r\n");
      out.write("\t\t\t\t<input id=\"cancel_btn\" class=\"btn\" type=\"button\" value=\"返回\" onclick=\"history.back()\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- 淘宝商品导入 -->\r\n");
      out.write("\t\t<div class=\"tab-pane \" id=\"import\">\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<button id=\"btn_sycn\" data-loading-text=\"数据同步中...\" class=\"btn btn-primary btn-large\">\r\n");
      out.write("                    同步淘宝数据\r\n");
      out.write("                 </button>\r\n");
      out.write("                 <label id=\"sync_result\"></label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
}

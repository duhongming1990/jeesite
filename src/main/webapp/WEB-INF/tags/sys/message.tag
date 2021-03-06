<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<script type="text/javascript">include('sweetalert_lib','${ctxStatic}/sweetalert/2.1.0/docs/assets/sweetalert/',['sweetalert.min.js']);</script>
<%@ attribute name="content" type="java.lang.String" required="true" description="消息内容"%>
<%@ attribute name="type" type="java.lang.String" description="消息类型：info、success、warning、error"%>
<c:if test="${not empty content}">
	<c:if test="${not empty type}"><c:set var="ctype" value="${type}"/></c:if>
	<c:if test="${empty type}"><c:set var="ctype" value="${fn:indexOf(content,'失败') eq -1?'success':'error'}"/></c:if>
	<script type="text/javascript">
		swal("提示框","${content}","${ctype}");
        top.$.jBox.closeTip();
	</script>
</c:if>

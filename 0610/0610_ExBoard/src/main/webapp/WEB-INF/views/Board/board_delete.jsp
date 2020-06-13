<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${result == 'true'}">

	<c:if test="${empty pageVO.search || empty pageVO.key}">
		<script type="text/javascript">
			url = "board_list?page=${pageVO.page}"
		</script>
	</c:if>
	
	<c:if test="${!empty pageVO.search && !empty pageVO.key}">
		<script type="text/javascript">
			url = "board_list?page=${pageVO.page}&search=${pageVO.search}&key=${pageVO.key}";
		</script>
	</c:if>
	
	<script type="text/javascript">
		window.close(); //자신의 팝업창을 닫음
		window.opener.location.href=url; //부모의 창을 이동시킴
	</script>

</c:if>
<c:if test="${result == 'false'}">
	<script type="text/javascript">
		alert("비밀번호가 틀렸습니다.");
	</script>
</c:if>

<html>
<head><title>방명록 삭제</title>
 <link rel="stylesheet" type="text/css" href="/stylesheet.css">
 </head>
 <body>
 <form method="post" action="board_delete" name="frm_input">
 	<input type="hidden" name="idx" value="${idx}">
   <table border="0" cellpadding="0" cellspacing="0" width="300" align="center">
     <tr>
       <td height="50">
       <img src="/img/bullet-05.gif"><b><font size="3" color="red">잠깐 !!</font></b></td></tr>
     <tr>
       <td valign="middle" height="30">
       <font size="2" face="돋움">게시물은 작성하신 분만 삭제할 수 있습니다.<br>
       글작성시 입력한 비밀번호를 입력해 주세요...</font></td></tr>
     <tr>
       <td valign="middle" height="40">
       <font size="2" face="돋움">
       비밀번호 <input type="password" name="pass" size="8"></font>
       <input type="submit" value="삭제">
       <input type="button" value="닫기" onclick="javascript:closePopUp()"></td></tr>
   </table>
   </form>
   
   <script type="text/javascript">
   
   	function boardDelete(){
   		if(frm_input.pass.value==""){
   			alert("비밀번호를 입력해주세요.");
   			frm_input.pass.focus();
   			return
   		}
   		
   		frm_input.submit();
   	}
   	
   	function closePopUp(){
   		window.close();
   	}
   </script>
   
 </body>
 </html>

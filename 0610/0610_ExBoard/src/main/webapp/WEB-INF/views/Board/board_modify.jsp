<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${!empty result}">
	<script type="text/javascript">
		alert("비밀번호가 틀렸습니다.");
	</script>
</c:if>

   <head><title>게시판 수정</title>
    <link rel="stylesheet" type="text/css" href="/stylesheet.css">

</head>

 <body topmargin="0" leftmargin="0">
 <table border="0" width="800">
 <tr>
   <td width="20%" height="500" bgcolor="#ecf1ef" valign="top">

   <!-- 다음에 추가할 부분 "-->

   </td>
   <td width="80%" valign="top">&nbsp;<br>
     <img src="/img/bullet-01.gif"><font size="3" face="돋움" color="blue"> <b>자 유 게 시 판</b></font>
     <font size="2"> - 수정하기</font><p>
     <img src="/img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
     <img src="/img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
     <form action="board_modify" method="post" name="frm_input">
		<input type="hidden" name="idx" value="${idx}">
		<input type="hidden" name="page" value="${pageVO.page}">
		<c:if test="${!empty pageVO.search && !empty pageVO.key}">
			<input type="hidden" name="search" value="${pageVO.search}">
			<input type="hidden" name="key" value="${pageVO.key}">
		</c:if>

      <table border="0">
       <tr>
         <td width="5%" align="right"><img src="/img/bullet-02.gif"></td>
         <td width="15%"><font size="2 face="돋움"">글쓴이</font></td>
         <td width="80%">
         <input type="text" size="20" name="name" value="${board.name}" readonly></td>
       </tr>
       <tr>
         <td align="right">&nbsp;</td>
         <td ><font size="2 face="돋움"">메일주소</font></td>
         <td>
          <input type="text" size="20" name="email" value="${board.email}"></td>
       </tr>
       <tr>
         <td align="right"><img src="/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">제 목</font></td>
         <td><input type="text" size="60" name="subject" value="${board.subject}"></td>
       </tr>
       <tr>
         <td align="right"><img src="/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">내용</font></td>
         <td><textarea wrap="physical" rows="10" name="contents" cols="60" >${board.contents}</textarea></td>
       </tr>
       <tr>
         <td align="right"><img src="/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">비밀번호</font></td>
          <td><input type="password" size="10" name="pass" >
		  <font size="2" face="돋움">*.수정과 삭제시 꼭 입력하셔야 합니다.</font></td>
        </tr>
        <tr>
          <td align="right">&nbsp;</td>
          <td><font size="2">&nbsp;</font></td>
          <td><a href="javascript:modify()"><img src="/img/edit2.gif" border=0></a>&nbsp;
		<c:if test="${empty pageVO.search && empty pageVO.key}">
			<a href="board_view?page=${pageVO.page}&idx=${idx}"><img src="/img/cancle.gif" border=0></a></td></tr>
		</c:if>
		<c:if test="${!empty pageVO.search && !empty pageVO.key}">
			<a href="board_view?page=${pageVO.page}&idx=${idx}&search=${pageVO.search}&key=${pageVO.key}"><img src="/img/cancle.gif" border=0></a></td></tr>
		</c:if>
          
      </table>
      </form>
    </td></tr>
  </table>
  
  <script type="text/javascript">
  	function modify(){
  		if(frm_input.email.value == ""){
  			alert("메일주소를 입력해주세요");
  			frm_input.email.focus();
  			return;
  		}
  		
  		if(frm_input.subject.value == ""){
  			alert("제목을 입력해주세요");
  			frm_input.subject.focus();
  			return;
  		}
  		
  		if(frm_input.contents.value == ""){
  			alert("내용을 입력해주세요");
  			frm_input.contents.focus();
  			return;
  		}
  		
  		if(frm_input.pass.value == ""){
  			alert("비밀번호를 입력해주세요");
  			frm_input.pass.focus();
  			return;
  		}
  		
  		frm_input.submit();

  	}
  </script>
  </body>
  </html>

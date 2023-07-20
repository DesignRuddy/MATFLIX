<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<%@ include file="../includes/header.jsp" %>
    
               <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Modify</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                      <div class="panel-heading">Board Modify Page</div>                      
                      <div class="panel-body">
                      <form action="/board/modify" method="post" role="form">
                      
                      <!-- Page719 input type의 hidden 태그는 ${_csrf.parameterName}로 처리합니다.
          이때, EL의 값은 실제 브라우저에서는 '_csrf'라는 이름으로 처리됩니다.
    스프링 시큐리티에서 POST 방식을 이용하는 경우, 기본적으로 CSRF(Cross Site Request Forgery) 토큰
	     이라는 것을 이용하게 됩니다. 별도의 설정이 없다면 스프링 시큐리티가 적용된 사이트의 모든 POST방식에는
	     CSRF 토큰이 사용되는데 '사이트간 위조 방지'를 목적으로 특정한 값의 토큰을 사용하는 방식입니다.
	     CSRF 토큰은 사용자가 임의로 변하는 특정한 토큰값을 서버에서 체크하는 방식입니다. 서버에는 브라우저에
	     데이터를 전송할 때 CSRF 토큰을 같이 전송합니다. 사용자가 POST 방식 등으로 특정한 작업을 할 때는
     브라우저에서 전송된 CSRF 토큰의 값과 서버가 보관하고 있는 토큰의 값을 비교합니다. 만일, CSRF 토큰의 값이
	     다르다면 작업을 처리하지 않는 방식입니다. 서버에서 생성하는 토큰은 일반적으로 난수를 생성해서
	     공격자가 패턴을 찾을 수 없도록 합니다. -->	
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                      
                                            
                      <!-- Page318, Page319 파라미터 추가 코딩 -->
                      <input type="hidden" name="pageNum" value="<c:out value="${cri.pageNum}" />">
	                  <input type="hidden" name="amount" value="<c:out value="${cri.amount}" />">
	                  
	                  <!-- Page346 : 수정/삭제 페이지에서 검색 처리 아래 2줄 소스 추가 적용 -->
	                  <input type="hidden" name="type" value="<c:out value="${cri.type}" />" />
					  <input type="hidden" name="keyword" value="<c:out value="${cri.keyword}" />" />                      
                      
                      <div class="form-group">
                          <label>Bno</label>
                          <input class="form-control" name="bno" value='<c:out value="${board.bno}" />' readonly="readonly">                       
                       </div>
                       <div class="form-group">
                          <label>Title</label>
                          <input class="form-control" name="title" value='<c:out value="${board.title}" />'>                       
                       </div>                       
                       <div class="form-group">
                          <label>Content</label>
                          <textarea class="form-control" rows="3" name="content"><c:out value="${board.content}" /></textarea>
                       </div>
                       <div class="form-group">
                          <label>Writer</label>
                          <input class="form-control" name="writer" value='<c:out value="${board.writer}" />' readonly="readonly">                                                 
                       </div>
                         
                       <div class="form-group" style="display: none;">
                          <label>RegDate</label>
                          <input class="form-control" name="regdate" value='<fmt:formatDate value="${board.regdate}" pattern="yyyy/MM/dd" />' readonly="readonly">                                                
                       </div>  
                       <div class="form-group" style="display: none;">
                          <label>UpdateDate</label>
                          <input class="form-control" name="updateDate" value='<fmt:formatDate value="${board.updateDate}" pattern="yyyy/MM/dd" />' readonly="readonly">                                                
                       </div>                        
                       
                       <!-- Page719 아래 현재 로그인한 사용자가 게시물의 작성자인 경우에만
                                                     수정과 삭제가 가능하도록 소스 코딩 합니다. -->
                       <sec:authentication property="principal" var="pinfo" />
                       <sec:authorize access="isAuthenticated()">
                       <c:if test="${pinfo.username eq board.writer}">
                       <button data-oper='modify' class="btn btn-default">글내용 수정!</button>
                       <button data-oper='remove' class="btn btn-danger">글삭제 버튼!</button>
                       </c:if>
                       </sec:authorize>
                       <button data-oper='list' class="btn btn-info">글목록 조회로 Go!</button>                       
                       </form>
                       </div>
                       <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <script type="text/javascript">
            	$(document).ready(function() {
					var formObj = $("form");
					// Javascript에서 button 태그의 'data-oper'속성을
					// 이용해서 원하는 기능을 동작하도록 처리합니다.
					$('button').on("click", function(e) {
						// form 태그의 모든 버튼은 기본적으로 submit으로
						// 처리하기 때문에 e.preventDefault() 메서드로
						// 기본 동작을 제한하고,
						e.preventDefault();
						
						var operation = $(this).data("oper");
						
						console.log(operation);
						
						if(operation === 'remove'){
							formObj.attr("action", "/board/remove");
						} else if (operation === 'list') {
							// move to list
							// 수정된 내용은 클릭한 버튼이 List인 경우 action 속성과 method 속성을
							// 변경합니다. '/board/list'로의 이동은 아무런 파라미터가 없기 때문에
							// form 태그의 모든 내용은 삭제한 상태에서 submit()을 진행합니다.			
						   formObj.attr("action", "/board/list").attr("method", "get");
						// 만약 사용자가 data-oper 속성의 "글목록 조회로 Go!" 버튼을 클릭한다면 form 태그에서 필요한 부분만 잠시 복사(clone)해서 보관해 두고, form 태그 내의 모든 내용은 지워서 초기화 처리합니다(empty). 이후에 다시 필요한 태그들만 추가해서(append) '/board/list'를 호출하는 형태를 이용합니다.
							var pageNumTag = $("input[name='pageNum']").clone();
							var amountTag = $("input[name='amount']").clone();
							var typeTag = $("input[name='type']").clone();
							var keywordTag = $("input[name='keyword']").clone();							
							
						   formObj.empty();
						   formObj.append(pageNumTag);
						   formObj.append(amountTag);
						   formObj.append(typeTag);
						   formObj.append(keywordTag);
						}
						// 마지막에 직접 submit()메서드를 처리합니다.
						formObj.submit();  
					});            		
				});            
            </script>
            
            
            
            
<%@ include file="../includes/footer.jsp" %>
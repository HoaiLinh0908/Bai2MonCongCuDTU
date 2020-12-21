<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-news" />
<c:url var="Newsurl" value="/admin-news" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sach bai viet</title>
</head>
<body>
				<c:if test="${not empty messageResponse}">
					<div class="alert alert-${alert}">${messageResponse}</div>
				</c:if>
<div class="dt-buttons btn-overlap btn-group">
	<a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
		data-toggle="tooltip" title="Add News" href="<c:url value='/admin-news?type=edit' />">
			<span>
				<i class="fa fa-plus-circle" aria-hidden="true">Add</i>
			</span>	
	</a>
	<button type="button" id="btnDelete"
			class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
			data-toggle="tooltip" title="Delete News">
				<span>
					<i class="fa fa-trash" aria-hidden="true">Delete</i>
				</span>			
	</button>
</div>

<form action="<c:url value='/admin-news' />" id="formSubmit" method="get">
  <table class="table table-striped">
	<thead>
		<tr>
			<th><input type="checkbox" id="checkAll"></th>
			<th>Name</th>
			<th>Short Description</th>
			<th>Method</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${model.listResult}">
			<tr>
				<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
				<td>${item.title}</td>
				<td>${item.shortDescription}</td>
				<td>
					<c:url var="editURL" value="/admin-news">
						<c:param name="type" value="edit" />
						<c:param name="id" value="${item.id}" />
					</c:url>
					<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
						title="Update News" href="${editURL}">
							<i class="fa fa-pencil-square" aria-hidden="true">Edit</i>		
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
  </table>
  <ul class="pagination" id="pagination"></ul>
  <input type="hidden" value="" id="page" name="page" />
  <input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
  <input type="hidden" value="" id="sortName" name="sortName" />
  <input type="hidden" value="" id="sortBy" name="sortBy" />
  <input type="hidden" value="" id="type" name="type" />
</form>
  
<script type="text/javascript">
	var totalPages = ${model.totalPage}
	var currentPage = ${model.page};
	var limit = 2;
    $(function () {
         window.pagObj = $('#pagination').twbsPagination({
             totalPages: totalPages,
             visiblePages: 10,
             startPage: currentPage,
             onPageClick: function (event, page) {
                 if(currentPage != page){
                	 $('#maxPageItem').val(limit);
                     $('#page').val(page);
                     $('#sortName').val('title');
                     $('#sortBy').val('desc');
                     $('#type').val('list');
                     $('#formSubmit').submit(); 
                 }
             }
         });
     });
     
     $("#btnDelete").click(function(){
    	 var data = {};
    	 var ids = $('tbody input[type=checkbox]:checked').map(function(){
    		return $(this).val(); 
    	 }).get();
    	 data['ids'] = ids;
    	 deleteNews(data);
     });
     
     function deleteNews(data){
 		$.ajax({
 			url: '${APIurl}',
 			type: 'DELETE',
 			contentType: 'application/json',
 			data: JSON.stringify(data),
 			success: function (result){
 				window.location.href = "${Newsurl}?type=list&maxPageItem=2&page=1&message=delete_success";
 			},
 			error: function (result){
 				window.location.href = "${Newsurl}?type=list&maxPageItem=2&page=1&message=error_system";
 			}
 		});
 	}
</script>
</body>
</html>
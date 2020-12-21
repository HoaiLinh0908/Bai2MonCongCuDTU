<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-news" />
<c:url var="Newsurl" value="/admin-news" />
<!DOCTYPE html>
<html>
<head>
<title>News Editor</title>
</head>
<body>
	<div class="breadcrumbs" id="breadcrumbs">
		<script type="text/javascript">
			try {
				ace.settings.check('breadcrumbs', 'fixed')
			} catch (e) {
			}
		</script>
		<ul class="breadcrumbs">
			<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
			</li>
			<li class="active">Edit News</li>
		</ul>
	</div>

	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<c:if test="${not empty messageResponse}">
					<div class="alert alert-${alert}">${messageResponse}</div>
				</c:if>
				<form id="formSubmit">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">Category</label>
						<div class="col-sm-9">
							<c:if test="${empty model.categoryCode}">
								<select class="form-control" id="categoryCode"
									name="categoryCode">
									<option value="">Select Category</option>
									<c:forEach var="item" items="${categories}">
										<option value="${item.code}">${item.name}</option>
									</c:forEach>
								</select>
							</c:if>
							<c:if test="${not empty model.categoryCode}">
								<select class="form-control" id="categoryCode"
									name="categoryCode">
									<option value="">Select Category</option>
									<c:forEach var="item" items="${categories}">
										<option value="${item.code}"
											<c:if test="${item.code == model.categoryCode}">selected="selected"</c:if>>
											${item.name}</option>
									</c:forEach>
								</select>
							</c:if>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">Title</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="title" name="title"
								value="${model.title}" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">Thumbnail</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="thumbnail"
								name="thumbnail" value="${model.thumbnail}" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">ShortDescription</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="shortDescription"
								name="shortDescription" value="${model.shortDescription}" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">Content</label>
						<div class="col-sm-9">
							<textarea rows="" cols="" id="content" name="content">${model.content}</textarea>
						</div>
					</div>

					<div class="form-group">

						<div class="col-sm-12">
							<c:if test="${not empty model.id}">
								<input type="button" class="btn btn-white btn-warning btn-bold"
									id="btnAddOrUpdate" value="Update" />
							</c:if>
							<c:if test="${empty model.id}">
								<input type="button" class="btn btn-white btn-warning btn-bold"
									id="btnAddOrUpdate" value="Add" />
							</c:if>
						</div>
					</div>
					<input type="hidden" value="${model.id}" id="id" name="id" />
				</form>

			</div>
		</div>
	</div>
<script>
	var editor ='';
	
	$(document).ready(function(){
		editor = CKEDITOR.replace('content');
	});

	$('#btnAddOrUpdate').click(function (e){
		e.preventDefault();
		var data = {};
		var formData = $('#formSubmit').serializeArray();
		$.each(formData, function (i, v){
			data[""+ v.name +""] = v.value;
		});
		data["content"] = editor.getData();
		var id = $('#id').val();
		if(id == ""){
			addNews(data);
		}else {
			updateNews(data);
		}
	});
	
	function addNews(data){
		$.ajax({
			url: '${APIurl}',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function (result){
				window.location.href = "${Newsurl}?type=edit&id="+result.id+"&message=insert_success";
			},
			error: function (result){
				window.location.href = "${Newsurl}?type=list&maxPageItem=2&page=1&message=error_system";
			}
		});
	}
	
	function updateNews(data){
		$.ajax({
			url: '${APIurl}',
			type: 'PUT',
			contentType: 'application/json',
			data: JSON.stringify(data),
			dataType: 'json',
			success: function (result){
				window.location.href = "${Newsurl}?type=edit&id="+result.id+"&message=update_success";
			},
			error: function (result){
				window.location.href = "${Newsurl}?type=list&maxPageItem=2&page=1&message=error_system";
			}
		});
	}
</script>
</body>
</html>
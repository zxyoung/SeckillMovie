<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加成功</title>
</head>
<body>

<script type="text/javascript">
	
</script>
	<table class="table">
		<thead>
			<tr>
				<th>电影名称</th>
				<th>剩余数量</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>活动详情</th>
			</tr>
		</thead>
		<tbody id="movieTable">

			<tr v-for="item in sortmovies" class="movieItem">
				<th v-text="item.name"></th>
				<th v-text="item.num"></th>
				<th v-text="item.startTime" class="start"></th>
				<th v-text="item.endTime" class="end"></th>
				<th><a v-bind:href="item.url" class="btn"
					v-bind:class="item.style" v-text="item.text"></a></th>
			</tr>

		</tbody>
	</table>
</body>
</html>
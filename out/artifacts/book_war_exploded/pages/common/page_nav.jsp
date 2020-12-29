<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/16
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--分页开始--%>
<div class="page_nav">
    <ul>
        <li>
            <a href="${ requestScope.page.url }&pageNo=1">首页</a>
        </li>
        <li>
            <a href="${ requestScope.page.url }&pageNo=${requestScope.page.prePage}">上一页</a>
        </li>

        <%--判断页码--%>
        <c:choose>
            <%--当总页码小于等于5--%>
            <c:when test="${requestScope.page.pageTotal <= 5}">
                <c:set scope="page" var="begin" value="1"></c:set>
                <c:set scope="page" var="end" value="${requestScope.page.pageTotal}"></c:set>
            </c:when>
            <%--当总页码大于5--%>
            <c:when test="${requestScope.page.pageTotal > 5}">
                <c:choose>
                    <%--当前页码为前三个，1,2,3，的情况，页码范围是1 - 5  --%>
                    <c:when test="${requestScope.page.pageNo <= 3}">
                        <c:set scope="page" var="begin" value="1"></c:set>
                        <c:set scope="page" var="end" value="5"></c:set>
                    </c:when>
                    <%--当前页码为最后三个，。。。 ，的情况，页码范围是总页码-4 - 总页码  --%>
                    <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal - 3}">
                        <c:set scope="page" var="begin" value="${requestScope.page.pageTotal - 4}"></c:set>
                        <c:set scope="page" var="end" value="${requestScope.page.pageTotal}"></c:set>
                    </c:when>
                    <%--其他的情况，页码范围是当前页码-2 - 当前页码+2  --%>
                    <c:otherwise>
                        <c:set scope="page" var="begin" value="${requestScope.page.pageNo - 2}"></c:set>
                        <c:set scope="page" var="end" value="${requestScope.page.pageNo + 2}"></c:set>
                    </c:otherwise>
                </c:choose>
            </c:when>
        </c:choose>

        <c:forEach begin="${begin}" end="${end}" var="i">

            <c:if test="${i eq requestScope.page.pageNo}" >
                <li>
                    <a href="javascript:;">[${i}]</a>
                </li>
            </c:if>
            <c:if test="${i ne requestScope.page.pageNo}" >
                <li>
                    <a href="${ requestScope.page.url }&pageNo=${i}">${i}</a>
                </li>
            </c:if>

        </c:forEach>
        <li>
            <a href="${ requestScope.page.url }&pageNo=${requestScope.page.nextPage}">下一页</a>
        </li>
        <li>
            <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageTotal}">末页</a>
        </li>
        <li>
            共${requestScope.page.pageTotalCount}条数据，
            分为${requestScope.page.pageTotal}页，
            到第
            <input type="number" min="1" max="${requestScope.page.pageTotal}" value="${requestScope.page.pageNo}" name="" id="pageNo">页
            <input type="button" name="" value="确定" id="searchPageBtn">
            <script>
                $(function () {
                    $('#searchPageBtn').click(function () {
                        var pageNo = $('#pageNo').val();
                        location.href = "${ requestScope.page.url }&pageNo="+pageNo+"";
                    })
                })
            </script>
        </li>
    </ul>
</div>
<%--分页结束--%>

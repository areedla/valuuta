<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="false"%>
<html>
	<jsp:include page="header.jsp"/>
	<body>

		<h2>${startMessage}</h2>
		
		<div class="container_12">
		
			<!-- SISESTUSVORM -->
			<div  class="grid_12 center textCenter" id="valuutaVorm">
			<form:form>
			</form:form>
			TODO: form

			</div>
			
			
			<!-- TEATED -->
			<div class="grid_12">		
				<!-- Siia kogume kõik teated kokku. Nt. veateated. -->
				<c:if test="${!msg.equals('')}"> 
					<div style="color:blue; font-weight:bold;">
						<c:out value="${msg}"/>
					</div>
				</c:if>
				<c:if test="${!error.equals('')}"> 
					<div style="color:red; font-weight:bold;">
						<c:out value="${error}"/>
					</div>
				</c:if>
			</div>
			
			
			<!-- TULEMUSTE TABEL -->
			<div class="grid_12 textCenter height300 textCenter center">
				
				<c:if test="${tulemused != null and tulemused.size() > 0}"> 
					<div>
						<table>
			       			<thead>
			         			<tr>
			          				<th> Allikas</th>
			          				<th> Kurs </th>
			          				<th> Summa </th>
			         			</tr>
			        		</thead>
			        		<tbody>
						        <c:forEach var="tulemus" items="${tulemused}">
							        <tr>
							          	<td><c:out value="${tulemus.allikas}"/></td>
							          	<td><c:out value="${tulemus}"/></td>
							          	<td><c:out value="${tulemus}"/></td>
							        </tr>
						        </c:forEach>
			       			</tbody>
			     		</table>
			     	</div>
		     	</c:if>
		     	
		    </div>
		    
		</div>
		
		<jsp:include page="footer.jsp"/>
	</body>
</html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<%@page session="false"%>
<html>
	<jsp:include page="header.jsp"/>
	<body>
		
		<h2>${startMessage}</h2>
		
		<div class="container_12">
		
			<!-- SISESTUSVORM -->
			<div  class="grid_8 formContainer" id="valuutaVorm">
				
				<form id='valuutaForm' action='/valuuta/' method='GET'>
					<input name="cal" type="hidden" value="ok"/>
					
					<table>
						<tr>
							<td class="textRight"><label>Summa</label></td>							
							<td><input name="summa" type="text" value="<c:out value="${summa}"/>"></td>
						</tr>
						<tr>
							<td class="textRight"><label>L�htevaluuta</label></td>
							<td>
								<input name="fromP" type="hidden" value="<c:out value="${from}"/>"/>
								<select name="from">
								  <c:forEach var="valuuta" items="${valuutad}">
								    <option value="<c:out value='${valuuta.nimetus}'/>" id="<c:out value='${valuuta.nimetus}'/>">
								      <c:out value="${valuuta.nimetusPikk}" />
								    </option>
								  </c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class="textRight"><label>Sihtvaluuta</label></td>
							<td>
								<input name="toP" type="hidden" value="<c:out value="${to}"/>"/>
								<select name="to">
								  <c:forEach var="valuuta" items="${valuutad}">
								    <option value="<c:out value='${valuuta.nimetus}'/>" id="<c:out value='${valuuta.nimetus}'/>">
								      <c:out value="${valuuta.nimetusPikk}" />
								    </option>
								  </c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class="textRight"><label>Kursi kuup�ev</label></td>
							<td><input name="kp" type="text" value="<c:out value="${kp}"/>"></td>
						</tr>
						<tr>
							<td class="textRight"><button id="clearButton" class="nupp" style="float:right;">Puhasta</button></td>
							<td><input type='submit' class="nupp" style="float:left;" value='Kalkuleeri' style='float:right'/></td>
						</tr>
					
					</table>
				</form>
				

			</div>
			
			
			<!-- TEATED -->
			<div class="grid_8 lightYellow">		
				<!-- Siia kogume k�ik teated kokku. Nt. veateated. -->
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
			<div name="tulemused" class="grid_8 textCenter center lightYellow">
				
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
							          	<td><c:out value="${tulemus.kurs}"/></td>
							          	<td><c:out value="${tulemus.summa}"/></td>
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

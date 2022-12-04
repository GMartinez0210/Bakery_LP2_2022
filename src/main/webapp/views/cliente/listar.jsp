<jsp:include page="../partials/head.jsp" />

<jsp:include page="../../components/nav/nav.jsp" />

<div class="container my-5">
	<main class="row">
		<section class="col col-12 col-md-4">
			<% String tipo = (String) request.getParameter("tipo"); %>
			<% if(tipo.equals("buscar")) { %>
				<jsp:include page="../../components/formCliente/modificarCliente.jsp" />
			<% } %>
			<% if(!tipo.equals("buscar")) { %>
				<jsp:include page="../../components/formCliente/agregarCliente.jsp" />
			<% } %>
		</section>
		<section class="col col-12 col-md-8">
			<jsp:include page="../../components/tableCliente/tableCliente.jsp" />
		</section>
	</main>
</div>

<jsp:include page="../partials/foot.jsp" />
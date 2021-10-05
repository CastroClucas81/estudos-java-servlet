package br.com.alura.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listaEmpresasServlet", value = "/listaEmpresasServlet")
public class ListaEmpresasServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //pegando banco
        Banco banco = new Banco();

        // pegando empresas
        List<Empresa> lista = banco.getEmpresas();

        // passando um atributo pela requisicao para o jsp
        //
        request.setAttribute("empresas", lista);
        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
        rd.forward(request, response);
    }

}

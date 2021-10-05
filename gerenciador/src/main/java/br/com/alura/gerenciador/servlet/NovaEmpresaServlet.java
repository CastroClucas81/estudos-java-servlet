package br.com.alura.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "novaEmpresa", value = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    //colocando doPost ele já só aceitará o Method como POST
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        //pegando os parâmetros enviados por url
        String nomeEmpresa = req.getParameter("nome");
        String paramDataEmpresa = req.getParameter("data");

        Date dataAbertura = null;
        try {
            //formatando a data
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(paramDataEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        Banco banco = new Banco();
        banco.adiciona(empresa);

        req.setAttribute("empresa", empresa.getNome());

        //pra enviar o reenvio do formulário, podemos mandar o navegador redirecionar
        // no lugar do servidor...
        resp.sendRedirect("listaEmpresasServlet");


        //chamar uma requisição sempre se uma o req
        //posso chamar outro servlet com o getRequestDispatcher ou qualquer recurso disponível
        //o próximo dispatcher tem q ter o mesmo method post ou service
        //o request no lado do servidor pedir ao usuário reenviar a requisicao com f5
        //RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresasServlet");
        //passando um atributo pela requisicao para o jsp
        //req.setAttribute("empresa", empresa.getNome());
        //rd.forward(req, resp);
    }
}

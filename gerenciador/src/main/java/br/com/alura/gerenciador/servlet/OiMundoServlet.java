package br.com.alura.gerenciador.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//definir url dessa página
//eu defini no xml a rota padrão. essa era a forma usual para fazer isso
@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {

    // SOBRESCREVER UM MÉTODO
    //dois parâmetros requisicao e resposta
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //devolver conteúdo html
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Parabéns, vocÊ fez seu primeiro servlet");
        out.println("<body>");
        out.println("<html>");
    }
}

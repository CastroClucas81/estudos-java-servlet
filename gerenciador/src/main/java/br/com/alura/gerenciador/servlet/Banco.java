package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
    private static List<Empresa> empresas = new ArrayList<>();
    //simulando a adicao de uma chave primeira do banco
    private static Integer ChaveSequencial = 1;

    static {
        Empresa empresa = new Empresa();
        empresa.setNome("teste");
        empresa.setId(ChaveSequencial++);
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(Banco.ChaveSequencial++);
        empresas.add(empresa);
    }

    public List<Empresa> getEmpresas() {
        //assim que se usa atributos estáticos
        return Banco.empresas;
    }

    public void removeEmpresa(Integer id) {

        Iterator<Empresa> it = empresas.iterator();

        //verificando se há outro elemento na lista
        while(it.hasNext()) {
            //pegando o próximo elemento da lista
            Empresa emp = it.next();

            if(emp.getId() == id) {
                //ele já sabe qual é a posição
                it.remove();
            }
        }
    }

    public Empresa buscaEmpresaPelaId(Integer id) {
        for (Empresa empresa : empresas) {
            if(empresa.getId() == id) {
                return empresa;
            }
        }

        return null;
    }
}

package controller;

import javax.servlet.annotation.WebServlet;
import model.Colaborador;
import model.Projeto;
import model.RelatorioColaborador;

/**
 *
 * @author Rafael
 */
@WebServlet(name = "ControllerRelatorio", urlPatterns = {"/ControllerRelatorio"})
public class ControllerRelatorio extends Base {

    public void consultaProjeto() {
        if (this.request.getParameter("projeto") != null) {
            this.request.setAttribute("relProjeto", this.getProjeto(this.request.getParameter("projeto")));
        }
        this.request.setAttribute("listaProjetos", mem.getAll(Projeto.class));
    }

    public void consultaColaborador() {
        if (this.request.getParameter("colaborador") != null) {
            this.request.setAttribute("relColaborador", this.getColaborador(Integer.valueOf(this.request.getParameter("colaborador"))));
        }
        this.request.setAttribute("listaColaboradores", mem.getAll(Colaborador.class));
    }

    private RelatorioColaborador getColaborador(int id) {
        RelatorioColaborador relColaborador = null;
        Colaborador colaborador = null;
        for (Object col : mem.getAll(Colaborador.class)) {
            if (((Colaborador) col).getId() == id) {
                colaborador = (Colaborador) col;
                relColaborador = new RelatorioColaborador(colaborador);
            }
        }
        return relColaborador;
    }
}

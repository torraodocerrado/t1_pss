package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import memoria.Memoria;
import model.Aluno;
import model.AlunoGraduacao;
import model.Colaborador;
import model.Professor;
import model.Projeto;

/**
 *
 * @author Rafael
 */
@WebServlet(name = "Base", urlPatterns = {"/Base"})
public class Base extends HttpServlet {

    protected Memoria mem;
    protected HttpServletRequest request;
    HttpServletResponse response;
    protected String output = "";
    protected String param = "";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        this.response = response;
        this.output = "";
        this.param = "";
        this.response.setContentType("text/html;charset=UTF-8");
        if (this.request.getParameterMap().containsKey("memoria")) {
            this.response.sendRedirect("memoria.jsp?memoria=" + this.request.getParameter("memoria"));
        } else if (this.request != null && this.request.getParameterMap().containsKey("cmd") && !this.request.getParameter("cmd").isEmpty()) {
            try {
                Method method = this.getClass().getMethod(this.request.getParameter("cmd"));
                method.invoke(this);
                this.request.getRequestDispatcher(this.request.getParameter("cmd") + ".jsp" + param).forward(this.request, this.response);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public Base() {
        if (mem == null) {
            mem = new Memoria();
        }
    }

    public Professor getProfessor(int id) {
        for (Object obj : mem.getAll()) {
            if ((obj instanceof Professor) && (((Professor) obj).getId() == id)) {
                return (Professor) obj;
            }
        }
        return null;
    }

    public Aluno getAluno(int id) {
        for (Object ojb : mem.getAll()) {
            if ((ojb instanceof Aluno) && (((Aluno) ojb).getId() == id)) {
                return (Aluno) ojb;
            }
        }
        return null;
    }

    public ArrayList<Object> getParticipantesProjeto() {
        ArrayList<Object> temp = new ArrayList<>();
        for (Object mem : mem.getAll()) {
            if ((mem instanceof Colaborador) && (!(mem instanceof Professor))) {
                if (!(mem instanceof AlunoGraduacao) || (this.getNumeroProjetosAndamentoAlunoParticipa((AlunoGraduacao) mem) < 2)) {
                    temp.add(mem);
                }
            }
        }
        return temp;
    }

    public int getNumeroProjetosAndamentoAlunoParticipa(AlunoGraduacao aluno) {
        int num = 0;
        for (Projeto mem : this.getProjetosEmAndamento()) {
            if (mem.colaboradores.contains(aluno)) {
                num++;
            }
        }
        return num;
    }

    public ArrayList<Projeto> getProjetosEmElaboracao() {
        return this.getAllProjetosPorSituacao("Em elaboração");
    }

    public ArrayList<Projeto> getProjetosEmAndamento() {
        return this.getAllProjetosPorSituacao("Em andamento");
    }

    public ArrayList<Projeto> getProjetosConcluido() {
        return this.getAllProjetosPorSituacao("Concluído");
    }

    public Projeto getProjeto(String parameter) {
        for (Object memItem : mem.getAll()) {
            if ((memItem instanceof Projeto) && (((Projeto) memItem).getTitulo().equals(parameter))) {
                return (Projeto) memItem;
            }
        }
        return null;
    }

    private ArrayList<Projeto> getAllProjetosPorSituacao(String situacao) {
        ArrayList<Projeto> result = new ArrayList<>();
        for (Object memItem : mem.getAll(Projeto.class)) {
            if (((Projeto) memItem).getSituacao().equals(situacao)) {
                result.add((Projeto) memItem);
            }
        }
        return result;
    }

    protected void debugParameters() {
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.println(paramName);
            String[] paramValues = request.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                System.out.println(paramValues[i]);

            }
        }
    }
}

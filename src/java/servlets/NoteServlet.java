/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domain.Note;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jingbo hou
 */
public class NoteServlet extends HttpServlet {
    

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
        String edit = request.getParameter("edit");
        
        //String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        //BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        //String title = br.readLine();
        //String content = br.readLine();
        
        //Note note = new Note();
        
        //note.setTitle(title);
        //note.setContent(content);
        
        if(edit == null){
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String content = br.readLine();
        
        Note note = new Note();
        
        note.setTitle(title);
        note.setContent(content);
        request.setAttribute("title", note.getTitle());
        request.setAttribute("content", note.getContent());
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;
        }else{
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        request.setAttribute("title",title);
        request.setAttribute("content",content);
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
        
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
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        
        pw.println(note.getTitle());
        pw.println(note.getContent());
        pw.close();
        
        title = br.readLine();
        content = br.readLine();
        note.setTitle(title);
        note.setContent(content);
        br.close();
        
        request.setAttribute("title",title);
        request.setAttribute("content",content);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relatorios;

import controleConexao.Conexao;
import java.io.InputStream;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.*;
import net.sf.jasperreports.engine.JRResultSetDataSource;


/**
 *
 * @author nip02
 */
public class Relatorio {
    public void geraRelatorio() throws JRException{
        Conexao con = new Conexao();
        String SQL = """
                     SELECT  idaluno, nome, cpf, bolsa_familia, responsavel
                     FROM aluno
                     WHERE bolsa_familia = true""";
        ResultSet rs = con.executaBusca(SQL);
        JRResultSetDataSource jrRS =  new JRResultSetDataSource(rs);
        InputStream caminho = this.getClass().getClassLoader().getResourceAsStream("relatorios/AlunosBolsaFamilia.jrxml");
        JasperReport jr = JasperCompileManager.compileReport(caminho);
        JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap(), jrRS);
        JasperViewer.viewReport(jp);
    }
}

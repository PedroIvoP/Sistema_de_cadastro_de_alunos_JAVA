package MODEL;

import java.time.LocalDate;


public class Aluno {
    
    String nome, turno;
    LocalDate nascimento;
    
    public Aluno(String nome, String turno, int ano, int mes, int dia){
        
        this.setNome(nome);
        this.setNascimento(ano, mes, dia);
        this.setTurno(turno);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(int ano, int mes, int dia) {
        this.nascimento = LocalDate.of(ano, mes, dia);
    }
    
    
    
}

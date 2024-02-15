import java.util.ArrayList;
import java.util.List;

interface Matricula {
    void matricularAluno(Aluno aluno);
    void cancelarMatricula(Aluno aluno);
    void exibirMatriculados();
}

class Disciplina implements Matricula {
    private List<Aluno> alunosMatriculados = new ArrayList<>();

    @Override
    public void matricularAluno(Aluno aluno) {
        alunosMatriculados.add(aluno);
        System.out.println(aluno.getNome() + " matriculado na disciplina.");
    }

    @Override
    public void cancelarMatricula(Aluno aluno) {
        if (alunosMatriculados.contains(aluno)) {
            alunosMatriculados.remove(aluno);
            System.out.println(aluno.getNome() + " teve a matrícula cancelada.");
        } else {
            System.out.println(aluno.getNome() + " não está matriculado nesta disciplina.");
        }
    }

    @Override
    public void exibirMatriculados() {
        System.out.println("Alunos matriculados:");
        for (Aluno aluno : alunosMatriculados) {
            System.out.println(aluno.getNome());
        }
    }
}

class Aluno {
    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

public class MainInterface {
    public static void main(String[] args) {
        Matricula disciplina = new Disciplina();

        Aluno aluno1 = new Aluno("João");
        Aluno aluno2 = new Aluno("Maria");

        disciplina.matricularAluno(aluno1);
        disciplina.matricularAluno(aluno2);
        disciplina.exibirMatriculados();

        disciplina.cancelarMatricula(aluno1);
        disciplina.cancelarMatricula(new Aluno("Carlos")); // Tentativa de cancelar um aluno não matriculado
        disciplina.exibirMatriculados();
    }
}

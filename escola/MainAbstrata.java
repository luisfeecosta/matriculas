import java.util.ArrayList;
import java.util.List;

abstract class DisciplinaAbstrata {
    protected List<Aluno> alunosMatriculados = new ArrayList<>();

    public abstract void matricularAluno(Aluno aluno);

    public abstract void cancelarMatricula(Aluno aluno);

    public void exibirMatriculados() {
        System.out.println("Alunos matriculados:");
        for (Aluno aluno : alunosMatriculados) {
            System.out.println(aluno.getNome());
        }
    }
}

class DisciplinaComAbstrata extends DisciplinaAbstrata {
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
}

public class MainAbstrata {
    public static void main(String[] args) {
        DisciplinaAbstrata disciplina = new DisciplinaComAbstrata();

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

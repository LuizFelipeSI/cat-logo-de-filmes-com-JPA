import javax.persistence.*;

@Entity
public class Midia {
    @Id
    int ID;
    @Column
    String Nome;
    @ManyToOne
    @JoinColumn(name = "ID_genero")
    Genero Genero;
    @Column
    int AnoLancamento;
    @ManyToOne
    @JoinColumn(name = "ID_diretor")
    Diretor Diretor;

    public Midia(int ID, String nome, Genero genero, int anoLancamento, Diretor diretor) {
        this.ID = ID;
        Nome = nome;
        Genero = genero;
        AnoLancamento = anoLancamento;
        Diretor = diretor;
    }

    public Midia(){

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setGenero(Genero genero) {
        Genero = genero;
    }

    public void setAnoLancamento(int anoLancamento) {
        AnoLancamento = anoLancamento;
    }

    public void setDiretor(Diretor diretor) {
        Diretor = diretor;
    }

    @Override
    public String toString() {
        return "Midia{" +
                "Nome='" + Nome + '\'' +
                ", Genero=" + Genero.toString() +
                ", AnoLancamento=" + AnoLancamento +
                ", Diretor=" + Diretor.toString() +
                '}';
    }

    public int getIDGenero() {
        return Genero.getID();
    }
    public int getIDDiretor(){
        return Diretor.getID();
    }
}
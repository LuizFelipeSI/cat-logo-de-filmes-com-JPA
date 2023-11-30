import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Genero {

    @Id
    int ID;
    @Column
    String Nome;
    @OneToMany
    @JoinTable(name="midia_genero", joinColumns = @JoinColumn(name="genero_id"),
            inverseJoinColumns = @JoinColumn(name="midia_id"))
    List<Midia> Midias;
    public void addMidia(Midia Midia){
        Midias = new ArrayList<>();
        Midias.add(Midia);

    }

    public Genero(int ID, String nome) {
        this.ID = ID;
        Nome = nome;
    }
    public Genero(){

    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getNome() {
        return Nome;
    }

    @Override
    public String toString() {
        return Nome;
    }

    public int getID() {
        return ID;
    }

    public List<Midia> getMidias() {
        return Midias;
    }
}
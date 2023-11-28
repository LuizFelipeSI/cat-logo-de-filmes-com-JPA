import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class CRUD {
    EntityManagerFactory emf;
  public CRUD(){
      emf = Persistence.createEntityManagerFactory("ORMPRJ");
  }
  public void endSession(){
      emf.close();
  }
  public void addMidia(int ID, String nome, Genero genero, int anoLancamento, Diretor diretor){
      EntityManager em = emf.createEntityManager();
      Midia m1 =  new Midia(ID, nome, genero, anoLancamento, diretor);
      em.getTransaction().begin();
      em.persist(m1);
      em.getTransaction().commit();
      em.close();
  }

  public Midia searchMidia(int ID){
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      Midia m1 = em.find(Midia.class,ID);
      em.close();
      return m1;

  }

  public void updateMidia(int ID){
      Scanner scan = new Scanner(System.in);
      Midia m1 = searchMidia(ID);
      System.out.println("Digite 1 para atualizar o nome ou 2 para o ano de lançamento");
      int resposta = scan.nextInt();
      if(resposta==1){
          System.out.println("Digite o novo nome: ");
          String novoNome = scan.next();
          scan.nextLine();
          m1.setNome(novoNome);
      } else if (resposta==2) {
          System.out.println("Digite o ano de lançamento: ");
          int novoAno = scan.nextInt();
          m1.setAnoLancamento(novoAno);

      }
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      em.merge(m1);
      em.getTransaction().commit();
      em.close();
  }
  public void deleteMidia(int ID){
      Scanner scan = new Scanner(System.in);
      EntityManager em = emf.createEntityManager();

      try {
          Midia m1 = em.find(Midia.class, ID);

          if (m1 != null) {
              System.out.println("Confirmar exclusão? [y/n]");
              String resposta = scan.nextLine();

              if (resposta.equals("y")) {
                  em.getTransaction().begin();
                  em.remove(m1);
                  em.getTransaction().commit();
                  System.out.println("Mídia excluída com sucesso");
              } else if (resposta.equals("n")) {
                  System.out.println("Operação cancelada");
              } else {
                  System.out.println("Resposta inválida");
              }
          } else {
              System.out.println("Mídia não encontrada");
          }
      } catch (Exception e) {
          System.out.println("Ocorreu um erro durante a exclusão: " + e.getMessage());
          if (em.getTransaction().isActive()) {
              em.getTransaction().rollback();
          }
      } finally {
          em.close();
          emf.close();
      }

  }
  public void addGenero(int ID, String nome){
      EntityManager em = emf.createEntityManager();
      Genero g1 = new Genero(ID, nome);
      em.getTransaction().begin();
      em.persist(g1);
      em.getTransaction().commit();
      em.close();

  }
  public Genero searchGenero(int ID){
      EntityManager em = emf.createEntityManager();
      Genero genero = em.find(Genero.class,ID);
      em.close();
      return genero;

  }

    public void updateGenero(int ID){
        Scanner scan = new Scanner(System.in);
        Genero genero = searchGenero(ID);

        System.out.println("Digite o novo nome do gênero: ");
        String novoNome = scan.nextLine();
        genero.setNome(novoNome);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(genero);
        em.getTransaction().commit();
        em.close();
        System.out.println("atualizado.");
    }

    public void deleteGenero(int ID){
        Scanner scan = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();

        try {
            Genero g1 = em.find(Genero.class, ID);

            if (g1 != null) {
                System.out.println("Confirmar exclusão? [y/n]");
                String resposta = scan.nextLine();

                if (resposta.equals("y")) {
                    em.getTransaction().begin();
                    em.remove(g1);
                    em.getTransaction().commit();
                    System.out.println("Gênero excluída com sucesso");
                } else if (resposta.equals("n")) {
                    System.out.println("Operação cancelada");
                } else {
                    System.out.println("Resposta inválida");
                }
            } else {
                System.out.println("Gênero não encontrado");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a exclusão: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

  public void addDiretor(int ID, String nome){
      EntityManager em = emf.createEntityManager();
      Diretor d1 = new Diretor(ID, nome);
      em.getTransaction().begin();
      em.persist(d1);
      em.getTransaction().commit();
      em.close();
  }
  public Diretor searchDiretor(int ID){
      EntityManager em = emf.createEntityManager();
      Diretor diretor = em.find(Diretor.class, ID);
      em.close();
      return diretor;

  }
    public void updateDiretor(int ID){
        Scanner scan = new Scanner(System.in);
        Diretor diretor = searchDiretor(ID);

        System.out.println("Digite o novo nome do diretor: ");
        String novoNome = scan.nextLine();
        diretor.setNome(novoNome);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(diretor);
        em.getTransaction().commit();
        em.close();
        System.out.println("atualizado.");
    }
    public void deleteDiretor(int ID) {
        Scanner scan = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();

        try {
            Diretor d1 = em.find(Diretor.class, ID);

            if (d1 != null) {
                System.out.println("Confirmar exclusão? [y/n]");
                String resposta = scan.nextLine();

                if (resposta.equals("y")) {
                    em.getTransaction().begin();
                    em.remove(d1);
                    em.getTransaction().commit();
                    System.out.println("Diretor excluída com sucesso");
                } else if (resposta.equals("n")) {
                    System.out.println("Operação cancelada");
                } else {
                    System.out.println("Resposta inválida");
                }
            } else {
                System.out.println("Diretor não encontrada");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a exclusão: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}

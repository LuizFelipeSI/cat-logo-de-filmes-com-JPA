import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int resposta=0;
        boolean execute = true;
      do{
          CRUD crud = new CRUD();
          System.out.println("----------------MENU----------------");
          System.out.println("Selecione uma opção: ");
          System.out.println("1) Cadastrar Mídia ");
          System.out.println("2) Consultar Mídia ");
          System.out.println("3) Atualizar Mídia ");
          System.out.println("4) Deletar Mídia ");
          System.out.println("5) Cadastrar gênero");
          System.out.println("6) Consultar gênero");
          System.out.println("7) Atualizar gênero");
          System.out.println("8) Deletar gênero");
          System.out.println("9) Cadastrar diretor");
          System.out.println("10) Consultar diretor");
          System.out.println("11) Atualizar diretor");
          System.out.println("12) Deletar diretor");
          System.out.println("13) Encerrar programa");
          System.out.println("----------------*----------------");
          resposta = scan.nextInt();
          switch (resposta){
              case 1:
                  System.out.println("Identificador da mídia: ");
                  int id = scan.nextInt();
                  System.out.println("Nome da mídia: ");
                  String nome = scan.next();
                  scan.nextLine();
                  System.out.println("ID do gênero: ");
                  int id_genero = scan.nextInt();
                  Genero g1 = crud.searchGenero(id_genero);
                  System.out.println("Ano de lançamento: ");
                  int ano = scan.nextInt();
                  System.out.println("Id do diretor: ");
                  int id_diretor = scan.nextInt();
                  Diretor d1 = crud.searchDiretor(id_diretor);
                  crud.addMidia(id,nome,g1,ano,d1);
                  break;

              case 2:
                  System.out.println("Identificador da mídia: ");
                  id = scan.nextInt();
                  Midia m = crud.searchMidia(id);
                  System.out.println(m);
                  break;

              case 3:
                  System.out.println("Identificador da mídia: ");
                  id = scan.nextInt();
                  crud.updateMidia(id);
                  break;

              case 4:
                  System.out.println("Identificador da mídia: ");
                  id = scan.nextInt();
                  crud.deleteMidia(id);
                  break;

              case 5:
                  System.out.println("Identificador do gênero: ");
                  id = scan.nextInt();
                  System.out.println("Nome do gênero: ");
                  nome = scan.next();
                  scan.nextLine();
                  crud.addGenero(id,nome);
                  break;

              case 6:
                  System.out.println("Identificador do gênero: ");
                  id = scan.nextInt();
                  Genero g = crud.searchGenero(id);
                  System.out.println(g.getNome());
                  break;

              case 7:
                  System.out.println("Identificador do gênero: ");
                  id = scan.nextInt();
                  crud.updateGenero(id);
                  break;

              case 8:
                  System.out.println("Identificador do gênero: ");
                  id = scan.nextInt();
                  crud.deleteGenero(id);
                  break;

              case 9:
                  System.out.println("Identificador do diretor: ");
                  id = scan.nextInt();
                  System.out.println("Nome do diretor: ");
                  nome = scan.next();
                  scan.nextLine();
                  crud.addDiretor(id,nome);
                  break;

              case 10:
                  System.out.println("Identificador do diretor: ");
                  id = scan.nextInt();
                  Diretor d = crud.searchDiretor(id);
                  System.out.println(d.getNome());
                  break;

              case 11:
                  System.out.println("Identificador do diretor: ");
                  id = scan.nextInt();
                  crud.updateDiretor(id);
                  break;

              case 12:
                  System.out.println("Identificador do diretor: ");
                  id = scan.nextInt();
                  crud.deleteDiretor(id);
                  break;

              case 13:
                  execute = false;
                  break;
          }
      }
      while (execute);

    }
}

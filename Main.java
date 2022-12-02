import java.util.Scanner;
import java.util.Random;

class Main {
  static int genero, FrA, MnA, CrA, PvA, PeA;
  static String nome, strGenero, divisao = "---------------------------------------------------------------------";
  public static String div2 = "***********************************************************";
  /* <----- Variaveis Globais -----> */
  public static String msg;
  public static char cmd;
  public static int GPS_location = 0;
  public static int syst_locate, locate;
  public static char comandoChar;
  static int danoRevolver = 3;
  static int danoRealAgente, danoRealMonstro = 3, pvMonstro = 10, manaMonstro;

  /* <----- Variaveis Fixas -----> */
  /* <----- Variaveis Gráficas -----> */

  public static final String div = "--------------------------------------------------";
  public static final String l1 = "\n";
  public static final String l2 = "\n\n";
  public static final String l3 = "\n\n\n";

  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    menu();
  }

  public static void validarGenero() {

    do {
      System.out.println("               Qual o gênero do seu agente?");
      System.out.println("     [ Feminino (1) | Masculino (2) | não-binário (3) ]");
      System.out.print("Gênero: ");
      genero = input.nextInt();

      if (genero == 1) {
        System.out.println("                        Feminino");
        strGenero = "Feminino";

      } else if (genero == 2) {
        System.out.println("                        Masculino");
        strGenero = "Masculino";
      } else if (genero == 3) {
        System.out.println("                       Não-binario");
        strGenero = "Não-binario";
      } else {
        System.out.println(divisao);
        System.out.println("                   Gênero invalido, tente outro");
        System.out.println(divisao);
      }
    } while (genero != 1 && genero != 2 && genero != 3);

  }

  public static void distribuirPontos() {
    do {
      System.out.println(divisao);
      System.out.println("                   Distribua 30 pontos entre PV e PE");
      System.out.println("            Primeiro digite quantos pontos vão para os pontos de vida");
      System.out.println("   Obs:não pode ser colocado menos que 2 ou mais de 28 pontos em cada");
      PvA = input.nextInt();
      if (PvA <= 28 && PvA >= 2) {
        PeA = 30 - PvA;
        System.out.println("      seus pontos de energia são " + PeA + " seus pontos de vida são " + PvA);
      } else {
        System.out.println("Digite um número válido");
        System.out.println(divisao);
      }
    } while (PvA > 28 || PvA < 2);

  }

  public static void definirAtributos() {
    Random randon = new Random();
    System.out.println("Definindo seus atributos:");
    try {
      Thread.sleep(1000);
    } catch (Exception erro) {
    }
    FrA = randon.nextInt(6) + 1;
    System.out.print('.');
    try {
      Thread.sleep(1000);
    } catch (Exception erro) {
    }
    MnA = randon.nextInt(6) + 1;
    System.out.print('.');
    try {
      Thread.sleep(1000);
    } catch (Exception erro) {
    }
    CrA = randon.nextInt(6) + 1;
    System.out.println('.');
    System.out.println(divisao);
    System.out.println(l3);
  }

  public static void criarPainel() {
    // message possivelmente tem que alterar o nome da var
    msg = "";

    System.out.println(div2);
    System.out.println("                 Painel do agente                         ");
    System.out.println(div2);
    System.out.println("Nome do agente: " + nome);
    System.out.println("Gênero do agente:" + strGenero);

    msg = "";
    msg += "Pontos de Vida: " + PvA + l1;
    msg += "Pontos de Energia: " + PeA;
    System.out.println(msg);

    msg = "";
    msg += l2;
    msg += "Força: " + FrA + " | ";
    msg += "Mente: " + MnA + " | ";
    msg += "Coração: " + CrA + l1;
    System.out.print(msg);
    System.out.println("***********************************************************");

  }

  public static void chamarCriacao() {
    System.out.println(l3);
    System.out.println(divisao);
    System.out.println("                 Qual o nome do seu agente?");
    System.out.print("nome: ");
    nome = input.nextLine();
    validarGenero();
    distribuirPontos();
    definirAtributos();
    criarPainel();
  }

  /* Código fonte ----> Cenas (Enrico Migliorini) */

  /*------------------------------------------------------------------------------------------------ */

  /* <---- MENU ----> */
  public static void menu() {
    Scanner input = new Scanner(System.in);

    while (true) {
      clear();
      msg = "";
      msg += div + l1;
      msg += "                      ";
      msg += "Menu" + l1;
      msg += div + l1;
      msg += "[1] Jogar" + l1;
      msg += "[2] Créditos" + l1;
      msg += "[0] Sair" + l1;
      msg += div + l1;
      msg += "cmd: ";
      System.out.print(msg);
      cmd = input.next().charAt(0);
      System.out.print(div + l1);

      switch (cmd) {
        case '1':
          clear();
          /* Entrada */
          // chamar a criação de personagem
          chamarCriacao();
          entrada();
          break;

        case '2':
          /* Créditos */
          creditos(); /* ----> Colocar TIMING no Texto */
          cmd = '0';
          break;

        case '0':
          /* Saida */
          System.exit(0);
          break;

        default:
          msg = "";
          msg += "Erro 000!" + l1;
          msg += "Tente Novamente" + l1;
          msg += div + l1;
      }

      System.out.print(msg);
    }
  }

  /*------------------------------------------------------------------------------------------------ */
  /* <----- Cenas -----> */

  /* Método para Entrada */
  public static void entrada() {
    Scanner input = new Scanner(System.in);

    while (true) {

      clear();
      msg = "";
      msg += div + l1;
      msg += "                  Entrada" + l1;
      msg += div + l1;
      msg += "Ao adentrar na velha mansão, " + nome + l1;
      msg += "avista um grande salão de entrada, que tinha" + l1;
      msg += "acesso a corredores na direita e a esquerda," + l1;
      msg += "além de uma escadaria, que levava para o andar a" + l1;
      msg += "cima,  as janelas estavam cobertos por uma grossa" + l1;
      msg += "camada de poeira, a madeira estava velha e" + l1;
      msg += "estourada pela umidade dos longos contatos com as" + l1;
      msg += "chuvas e no teto possuia um lustre aparentemente" + l1;
      msg += "velho, quase se soltando." + l1;
      msg += l1 + l3;
      msg += "Comandos:" + l1;
      msg += "[1] Corredor Direito" + l1;
      msg += "[2] Corredor Esquerdo" + l1;
      msg += "[3] Escadaria" + l1;
      msg += div + l1;
      System.out.print(msg);
      System.out.print("cmd: ");
      cmd = input.next().charAt(0);
      System.out.print(div + l1);

      switch (cmd) {

        case '1':
          cor_dir1();
          break;

        case '2':
          cor_esq1();
          break;

        case '3':
          escadaria();
          break;

        case '0':
          menu();
          break;

        default:

      }
    }
  }

  public static void cor_dir1() {
    Scanner input = new Scanner(System.in);
    locate = 2;
    while (true) {
      clear();
      msg = "";
      /* msg += ""+l1; */
      msg += div + l1;
      msg += "           1° Andar | Corredor Direito" + l1;
      msg += div + l1;
      msg += "O corredor aparentava um estado de mal " + l1;
      msg += "envelhecimento, assim como todo o resto da casa," + l1;
      msg += "possui moveis com uns candelabros e com velas" + l1;
      msg += "prestes acabar e apagadas, o corredor dava acesso" + l1;
      msg += "a duas portas, a primeira dava a sala de jantar " + l1;
      msg += "e a outra dava ao quarto das empregas." + l1;
      msg += l3 + l1;
      msg += "Cômodos:" + l1;
      msg += "[1] Sala de Jantar" + l1;
      msg += "[2] Quartos das Empregadas" + l1;
      msg += "[3] Entrada" + l1;
      msg += div + l1;

      System.out.print(msg);
      System.out.print("cmd: ");
      cmd = input.next().charAt(0);
      System.out.print(div + l1);

      switch (cmd) {

        case '1':
          /* Sala de Jantar */
          sla_jantar();
          break;

        case '2':
          /* Quarto das Empregadas */
          qrt_empregadas();
          break;

        case '3':
          /* Entrada */
          entrada();
          break;

        case '0':
          menu();
          break;

        case 'i':
          /* Interagir */
          menuInter();
          break;

        case 'b':
          /* Inventário | Bolsa */
          break;

      }
    }
  }

  public static void cor_esq1() {
    Scanner input = new Scanner(System.in);

    while (true) {
      clear();

      msg = "";
      msg += div + l1;
      msg += "           1° Andar | Corredor Esquerdo" + l1;
      msg += div + l1;
      /* msg += "--------------------------------------------------" + l1; */
      msg += "O corredor aparentava um estado de mal" + l1;
      msg += "envelhecimento, assim como todo o resto da casa," + l1;
      msg += "o corredor dava acesso a quatro portas, a" + l1;
      msg += "primeira dava ao almoxarifado, a outra dava ao" + l1;
      msg += "banheiro, a seguinte a sala de estar e a última" + l1;
      msg += "dava ao quarto de empregados." + l1;
      msg += l3 + l1;
      msg += "[1] Almoxarifado" + l1;
      msg += "[2] Banheiro" + l1;
      msg += "[3] Sala de Estar" + l1;
      msg += "[4] Quartos dos Empregados" + l1;
      msg += div + l1;

      System.out.print(msg);
      System.out.print("cmd :");
      cmd = input.next().charAt(0);
      System.out.print(div + l1);

      switch (cmd) {
        case '1':
          /* Almoxarifado */
          almoxarifado1();
          break;

        case '2':
          /* Banheiro */
          banheiro1();
          break;

        case '3':
          /* Sala de Estar */
          sla_estar();

          break;

        case '4':
          /* Quarto de Empregado */
          qrt_empregados();

          break;

        case '5':
          cor_esq1();
          break;

        case '0':
          /* Voltar para o menu */
          menu();
          break;

        case 't':
          /*
           * Teste ----> Se t > 4
           * gera a dica sobre onde tem o segredo
           * naquela sala.
           */

          break;

        case 'i':
          /* Interação */
          // O case de interação não é visivel ao player
          menuInter();

          break;

        case 'b':
          /* Bolsa | Inventário */
          break;

        default:

      }

    }
  }

  public static void escadaria() {
    Scanner input = new Scanner(System.in);

    while (true) {
      clear();
      msg = "";
      msg += div + l1;
      /* msg += "--------------------------------------------------" + l1; */
      msg += "                    Escadaria" + l1;
      msg += div + l1;
      msg += "A grande escadaria é formada por uma escada que" + l1;
      msg += "dava ao meio andar, onde se encontrava na parede e" + l1;
      msg += "que dai se dividia em duas, uma para cada lado que" + l1;
      msg += "subia o resto que faltava para o egundo andar, no" + l1;
      msg += "meio piso as parede tinham três pinturas, uma com" + l1;
      msg += "uma mulher, um menino e um homem, de feições o" + l1;
      msg += "outro quadro era de um homem, mais velhos, com" + l1;
      msg += "abelos grisalhos e um corpo até que bem definidas" + l1;
      msg += "para a idade que aparentava, o terceiro quadro, não" + l1;
      msg += "dava para ver direito, mas parece ser um quadro de" + l1;
      msg += "uma menina sorrindo com sua boneca." + l1;
      msg += l3 + l1;
      msg += "[1] Corredor Direito 2º Andar" + l1;
      msg += "[2] Corredor Esquerdo 2º Andar" + l1;
      msg += "[3] Entrada" + l1;
      msg += div + l1;

      System.out.print(msg);
      System.out.print("cmd: ");
      cmd = input.next().charAt(0);
      System.out.print(div + l1);

      switch (cmd) {
        case '1':
          cor_dir2();
          break;

        case '2':
          cor_esq2();
          break;

        case '3':
          entrada();
          break;

        case '0':
          menu();
          break;

        case 'i':
          /* Interação */
          menuInter();
          break;

        case 'b':
          /* bolsa | Inventário */
          break;

        default:
      }
    }
  }

  /* Cômodos Corredor Direito 1° Andar */
  public static void sla_jantar() {
    Scanner input = new Scanner(System.in);
    locate = 5;

    while (true) {
      clear();

      msg = "";
      msg += div + l1;
      // msg += "--------------------------------------------------" + l1;
      msg += "               Sala de Jantar" + l1;
      msg += div + l1;
      msg += "Entrando na sala de jantar é possivel, avistar um" + l1;
      msg += "móvel na quina a direita da porta, moveis velhos," + l1;
      msg += "uma mesa grande e redonda, cabendo até oito" + l1;
      msg += "pessoas sentadas por lá, havia uma porta dupla," + l1;
      msg += "iguais as de bar do velho oeste, que dava acesso" + l1;
      msg += "a cozinha, além de ter nas paredes quadros bem" + l1;
      msg += "velhos e irreconheciveis." + l1;
      msg += l3 + l1;
      msg += "Cômodos:" + l1;
      msg += "[1] Cozinha" + l1;
      msg += "[2] Corredor Direito" + l1;
      msg += div + l1;

      System.out.print(msg);
      System.out.print("cmd: ");
      cmd = input.next().charAt(0);
      System.out.print(div + l1);

      switch (cmd) {
        case '1':
          cozinha();
          break;

        case '2':
          cor_dir1();
          break;

        case '0':
          menu();
          break;

        case 'i':
          /* Interação */
          menuInter();
          break;

        case 'b':
          /* Bolsa | Inventário */
          break;

        default:
      }

    }
  }

  public static void qrt_empregadas() {
    Scanner input = new Scanner(System.in);
    locate = 6;
    while (true) {
      msg = "";
      msg += div + l1;
      /* msg = "--------------------------------------------------" + l1; */
      msg += "Um quarto, todo bagunçado, com quatros quartos e" + l1;
      msg += "dois armários, dividos igualmente por uma" + l1;
      msg += "divisória, cada cama possue uma escrivaninha," + l1;
      msg += "bem velha e com uma luminária antiga." + l1;
      msg += l3 + l1;
      msg += "Cômodo: " + l1;
      msg += "[1] Corredor Direito" + l1;
      msg += div + l1;

      System.out.print(msg);
      System.out.print("cmd: ");
      cmd = input.next().charAt(0);
      System.out.print(div + l1);

      switch (cmd) {
        case '1':
          cor_dir1();
          break;

        case '0':
          menu();
          break;

        case 'i':
          /* Interação */
          menuInter();
          break;

        case 'b':
          /* Bolsa | Inventário */
          break;

        default:
          break;
      }

    }
  }

  public static void cozinha() {
    Scanner input = new Scanner(System.in);

    while (true) {
      msg = "";
      msg += div + l1;
      msg += "                   Cozinha" + l1;
      msg += div + l1;
      msg += "Um grande comodô da casa, a cozinha possui antigos" + l1;
      msg += "armários e estantes que guardam diversos";
      msg += "utensilios para cozinhar." + l1;
      msg += l3 + l1;
      msg += "Cômodos:" + l1;
      msg += "[1] Sala de Jantar" + l1;
      msg += div + l1;

      System.out.print(msg);
      System.out.print("cmd: ");
      cmd = input.next().charAt(0);
      System.out.print(div + l1);

      switch (cmd) {
        case '1':
          sla_jantar();
          break;

        case '0':
          menu();
          break;

        case 'i':
          /* Interação */
          menuInter();
          break;

        case 'b':
          /* Bolsa | Inventário */
          break;

        default:

      }

    }
  }

  /* Cômodos Corredor Esquerdo 1° Andar */
  public static void almoxarifado1() {
    Scanner input = new Scanner(System.in);
    locate = 8;

    while (true) {
      msg = "";

      msg += div + l1;
      msg += "1° Almoxarifado" + l1;
      msg += div + l1;
      /* msg += "--------------------------------------------------"; */
      msg += "Um pequeno comôdo na casa, com produtos de limpeza" + l1;
      msg += "vencidos e vassouras e pás." + l1;
      msg += l3 + l1;
      msg += "[1] Corredor Esquerdo" + l1;
      msg += div + l1;

      System.out.print(msg);
      System.out.print("cmd: ");
      cmd = input.next().charAt(0);
      System.out.print(div + l1);

      switch (cmd) {
        case '1':
          cor_esq1();
          break;

        case '0':
          menu();
          break;

        case 'i':
          /* Interação */
          // menuInter();
          pas_secreta();
          break;

        case 'b':
          /* Bolsa | Inventário */
          break;

        default:

      }
    }
  }

  public static void sla_estar() {
    Scanner input = new Scanner(System.in);

    while (true) {
      msg = "";
      msg += div + l1;
      msg += "Sala de Estar" + l1;
      msg += div + l1;
      msg += "Uma grande poltrona verde musgo, em frente e de" + l1;
      msg += "costas para porta, indicando uma lareira, com um" + l1;
      msg += "quadro da mesma mulher que estava no quadro da" + l1;
      msg += "família na entrada, desta vez ela passava um ár de" + l1;
      msg += "superioridade, como se quem olha-se aquele quadro" + l1;
      msg += "estivesse a baixo dela. Além do quadro, o comôdo" + l1;
      msg += "também tinhas moveis velhos e empoeirados." + l1;
      msg += l3 + l1;
      msg += "Cômodos: " + l1;
      msg += "[1] Corredor Esquerdo" + l1;
      msg += div + l1;

      System.out.print(msg);
      System.out.print(cmd);
      cmd = input.next().charAt(0);
      System.out.print(div + l1);

      switch (cmd) {
        case '1':
          cozinha();
          break;

        case '2':
          sla_jantar();
          break;

        case '0':
          menu();
          break;

        case 'i':
          /* Interação */
          menuInter();
          break;

        case 'b':
          /* Bolsa | Inventário */
          break;

        default:

      }
    }
  }

  public static void banheiro1() {

    while (true) {
      msg = "";
      msg += div + l1;
      msg += "                   Banheiro" + l1;
      msg += div + l1;
      msg += "Uma pia, com rastros vicosos verdes, uma privada" + l1;
      msg += "que nem se enxerga mais o fundo, com uma água" + l1;
      msg += "suja velha e moscas percorrendo todo banheiro," + l1;
      msg += "uma banheira antiga e quebrada, com rachaduras" + l1;
      msg += "que a partir ela quase ao meio." + l1;
      msg += l3 + l1;
      msg += "Cômodos: " + l1;
      msg += "[1] Corredor Esquerdo" + l1;
      msg += div + l1;

      System.out.print(msg);
      System.out.print("cmd: ");
      cmd = input.next().charAt(0);
      System.out.print(div + l1);

      switch (cmd) {
        case '1':
          cor_esq1();
          break;

        case '0':
          menu();
          break;

        case 'i':
          /* Interação */
          menuInter();
          break;

        case 'b':
          /* Bolsa | Inventário */
          break;

        default:

      }
    }
  }

  public static void qrt_empregados() {

    while (true) {
      msg = "";
      msg += div + l1;
      msg += "Quarto dos Empregados" + l1;
      msg += div + l1;
      msg += "Um quarto, todo bagunçado, com quatro camas e dois" + l1;
      msg += "armários, dividos igualmente por uma divisória," + l1;
      msg += "cama possue uma escrivaninha, bem velha e com" + l1;
      msg += "uma luminária antiga." + l1;
      msg += l3 + l1;
      msg += "[1] Corredor Esquerdo" + l1;
      msg += div + l1;

      System.out.print(msg);
      System.out.print("cmd: ");
      cmd = input.next().charAt(0);
      System.out.print(div + l1);

      switch (cmd) {
        case '1':
          cor_esq1();
          break;

        case '0':
          menu();
          break;

        case 'i':
          /* Interação */
          menuInter();
          break;

        case 'b':
          /* Bolsa | Inventário */
          break;

        default:

      }
    }
  }

  /* <----- Pausa ------> */

  /* Escadaria */
  public static void cor_dir2() {
    Scanner input = new Scanner(System.in);
    msg = "";
    msg += div + l1;

    msg += "           Corredor Direito 2° Andar" + l1;
    msg += div + l1;
    msg += "O corredor aparentava um estado de mal" + l1;
    msg += "envelhecimento, assim como todo o resto da casa," + l1;
    msg += "possui moveis com uns candelabros e com velas" + l1;
    msg += "prestes acabar e apagadas, o corredor dava acesso" + l1;
    msg += "a três portas, a primeira dava ao banheiro a" + l1;
    msg += "segunda dava a biblioteca e a terceira dava a" + l1;
    msg += "um quarto de uma criança." + l1;
    msg += div + l1;
    msg += "Cômodos:";
    msg += "[1] Banheiro" + l1;
    msg += "[2] Biblioteca" + l1;
    msg += "[3] Quarto Infnatil" + l1;
    msg += "[4] Entrada" + l1;
    msg += div + l1;

    System.out.print(msg);
    System.out.print("cmd: ");
    cmd = input.next().charAt(0);
    System.out.print(div + l1);

    switch (cmd) {
      case '1':
        /* Banheiro */
        banheiro2();
        break;

      case '2':
        /* Biblioteca */
        biblioteca();
        break;

      case '3':
        /* Quarto Infantil */
        qrt_crianca();
        break;

      case '4':
        /* escada */
        escadaria();
        break;
    }
  }

  public static void cor_esq2() {
    Scanner input = new Scanner(System.in);
    msg = "";
    msg += div + l1;
    msg += "            Corredor Esquerdo 2° Andar" + l1;
    msg += div + l1;
    msg += "O corredor aparentava um estado de mal" + l1;
    msg += "envelhecimento, assim como todo o resto da casa," + l1;
    msg += "o corredor dava acesso a quatro portas, a primeira" + l1;
    msg += "dava ao almoxarifado, a outra dava ao escritório, e" + l1;
    msg += "a última dava ao quarto dos adultos" + l1;
    msg += div + l1;
    msg += "Cômodos:" + l1;
    msg += "[1] Almoxarifado" + l1;
    msg += "[2] Escritório" + l1;
    msg += "[3] Quarto de Adultos" + l1;
    msg += "[4] Escada" + l1;
    msg += div + l1;

    System.out.print(msg);
    System.out.print("cmd: ");
    cmd = input.next().charAt(0);
    System.out.print(div + l1);

    switch (cmd) {
      case '1':
        almoxarifado2();
        break;

      case '2':
        escritorio();
        break;

      case '3':
        qrt_adulto();
        break;

      case '4':
        escadaria();
        break;

      case '0':
        menu();
        break;
    }

  }

  /* Cômodos Corredor Direito 2° Andar */
  public static void banheiro2() {
    Scanner input = new Scanner(System.in);
    msg = "";
    msg += div + l1;
    msg += "                   Banheiro" + l1;
    msg += div + l1;
    msg += "Uma pia, com rastros vicosos verdes, uma privada" + l1;
    msg += "que nem se enxerga mais o fundo, com uma água suja" + l1;
    msg += "velha e moscas percorrendo todo banheiro, uma" + l1;
    msg += "banheira antiga e quebrada, com rachaduras que a" + l1;
    msg += "partir ela quase ao meio." + l1;
    msg += div + l1;
    msg += "Cômodos:" + l1;
    msg += "[1] Corredor Direito 2º Andar" + l1;
    msg += div + l1;

    System.out.print(msg);
    System.out.print("cmd: ");
    cmd = input.next().charAt(0);
    System.out.print(div + l1);

    switch (cmd) {
      case '1':
        cor_dir2();
        break;

      case '0':
        menu();
        break;
    }
  }

  public static void biblioteca() {
    Scanner input = new Scanner(System.in);
    locate = 15;
    msg = "";
    msg += div + l1;
    msg += "                    Biblioteca" + l1;
    msg += div + l1;
    msg += "Um comôdo com uma mesa de costas para uma enorme" + l1;
    msg += "janela suja e com várias estantes." + l1;
    msg += div + l1;
    msg += "Cômodos:" + l1;
    msg += "[1] Corredor Direito 2º Andar" + l1;
    msg += div + l1;

    System.out.print(msg);
    System.out.print("cmd: ");
    cmd = input.next().charAt(0);
    System.out.print(div + l1);

    switch (cmd) {
      case '1':
        cor_dir2();
        break;

      case '0':
        menu();
        break;
    }

  }

  public static void qrt_crianca() {
    Scanner input = new Scanner(System.in);
    msg = "";
    msg += div + l1;
    msg += "                Quarto de Criança";
    msg += div + l1;
    msg += "Um quarto com uma cama de casal, uma mesa rústica" + l1;
    msg += "de madeira, um armário e uma antiga TV de tubo" + l1;
    msg += "em frente a mesa." + l1;
    msg += div + l1;
    msg += "Cômodos:";
    msg += "[1] Corredor Direito 2º Andar" + l1;
    msg += div + l1;

    System.out.print(msg);
    System.out.print("cmd: ");
    cmd = input.next().charAt(0);
    System.out.print(div + l1);

    switch (cmd) {
      case '1':
        cor_dir2();
        break;

      case '0':
        menu();
        break;
    }

  }

  /* Cômodos Corredor Esquerdo 2° Andar */
  public static void almoxarifado2() {
    Scanner input = new Scanner(System.in);
    msg = "";
    msg += div + l1;
    msg += "                  Almoxarifado" + l1;
    msg += div + l1;
    msg += "Um pequeno comôdo na casa, com produtos de " + l1;
    msg += "limpeza vencidos e vassouras e pás." + l1;
    msg += div + l1;
    msg += "Cômodos:" + l1;
    msg += "[1] Corredor Esquerdo 2º Andar" + l1;
    msg += div + l1;

    System.out.print(msg);
    System.out.print("cmd: ");
    cmd = input.next().charAt(0);
    System.out.print(div + l1);

    switch (cmd) {
      case '1':
        cor_esq2();
        break;

      case '0':
        menu();
        break;
    }

  }

  public static void escritorio() {
    Scanner input = new Scanner(System.in);
    locate = 18;
    msg = "";
    msg += div + l1;
    msg += "                 Escritório" + l1;
    msg += div + l1;
    msg += "Uma mesa, com um velho computador, alguns" + l1;
    msg += "disquetes quebrados e jogados no lixo, embora" + l1;
    msg += "aquela sala trás uma sensação de viagem no tempo," + l1;
    msg += "era o comôdo menos sujo da casa." + l1;
    msg += div + l1;
    msg += "Cômodos:" + l1;
    msg += "[1] Corredor Esquerdo 2º Andar" + l1;
    msg += div + l1;

    System.out.print(msg);
    System.out.print("cmd: ");
    cmd = input.next().charAt(0);
    System.out.print(div + l1);

    switch (cmd) {
      case '1':
        cor_esq2();
        break;

      case '0':
        menu();
        break;
    }
  }

  public static void qrt_adulto() {
    Scanner input = new Scanner(System.in);
    locate = 19;
    msg = "";
    msg += div + l1;
    msg += "             Quarto dos Adultos" + l1;
    msg += div + l1;
    msg += "Uma cama de casal, com um grande armário e duas" + l1;
    msg += "escrivaninha." + l1;
    msg += div + l1;
    msg += "Cômodos:" + l1;
    msg += "[1] Corredor Esquerdo 2º Andar" + l1;
    msg += div + l1;

    System.out.print(msg);
    System.out.print("cmd: ");
    cmd = input.next().charAt(0);
    System.out.print(div + l1);

    switch (cmd) {
      case '1':
        cor_esq2();
        break;

      case '0':
        menu();
        break;

    }

  }

  /* <----- Interação ----- */

  /* Funções */
  /*
   * public static int addLocalizacao() {
   * int locate = 0;
   * System.out.print("Em Qual sala você está? "); locate = input.nextInt();
   * return locate;
   * }
   */

  public static char tomada_decisao() {
    char dec = '0';
    System.out.print("Você deseja guardar este objeto?\n[s] sim\n[n] não\n");
    System.out.print("cmd: ");
    dec = input.next().charAt(0);

    if (dec != 's' || dec != 'S' || dec != 'n' || dec != 'N') {
      System.out.print("Erro! Este comando não existe.");
      tomada_decisao();
    }
    return dec;
  }

  /* Métodos - Objetos */

  public static void jornal() {
    msg = "";
    msg += "Trecho:" + l1;
    msg += "26 de Setembro de 1958 - Alphaville, SP" + l1;
    msg += "Um homem de 52 anos, chamado de Carlos Alberto Miranda, mais conhecido CAM, é preso" + l1;
    msg += "nesta manhã, acusado por sequestrar crianças e participar de ceitas. Os políciais," + l1;
    msg += "encontraram vestígios em sua mansão, porém não se encontraram, mais nenhuma criança." + l1;
    System.out.print(msg);
    char rst = tomada_decisao();

    if (rst == 's' || rst == 'S') {
      /* Deve gravar no inventário (Jornal) */
    }
  }

  public static void revolver() {
    char rst = tomada_decisao();

    if (rst == 's' || rst == 'S') {
      /* Deve gravar no inventário (Jornal) */
    }
  }

  public static void adaga() {
    // int danoAdaga = 3;
    char rst = tomada_decisao();

    if (rst == 's' || rst == 'S') {
      /* Deve gravar no inventário (Jornal) */
    }
  }

  public static void pergaminho() {
    msg = "";
    msg += "Descrição: " + l1;
    msg += "EQUINATARUS PYROLOCUTATUM BRADANUM DESCAP" + l1;
    msg += "POCALUS SOCANIAN COSTARUS MIGARIAN SACASTE" + l1;
    msg += div + l1;
    msg += "Aprende bola de fogo" + l1;
    /* bola de fogo: Armazena nas magias */
    /* dano: 5 */

    char rst = tomada_decisao();

    if (rst == 's' || rst == 'S') {
      /* Deve gravar em mágica */
    }
  }

  public static void ped_papel() {
    msg = "";
    msg += "5 Crianças Puras:" + l1;
    msg += "[x] Carla papazzini" + l1;
    msg += "[x] Gislana Oliveira" + l1;
    msg += "[x] Pietro Antonio" + l1;
    msg += "[x] Sabrina Pascoali" + l1;
    msg += "[x] Lucas Pereira" + l1;

    char rst = tomada_decisao();

    if (rst == 's' || rst == 'S') {
      /* Deve gravar no inventário */
    }

  }

  /* Era para imprimir isto aqui embaixo */
  public static void pas_secreta() {
    msg += "Você empurra a estante do mesmo jeito que a marca" + l1;
    msg += "então atrás e escondido, lhe é revelado uma passagem" + l1;
    msg += "secreta. Você então desce a escada" + l1;
    System.out.print(msg);

    msg = "";
    msg += "Você então desce a escadaria, atrás da porta" + l1;
    msg += "ao chegar no fim, você encontra um corredor" + l1;
    msg += "O corredor ao invés de paredes, tinha grades" + l1;
    msg += "como as de uma cela, cheios de esqueletos" + l1;
    msg += "ao final do corredor, você se depara com um" + l1;
    msg += "grande salão, com uma mesa de pedra no centro." + l1;
    msg += "você então escuta." + l1;
    msg += "HRAHRARHAaaaaaaaaaaaaa!!!!!" + l1;
    msg += "Então uma enorme criatura aparece" + l1;
    System.out.print(msg);
    executarCombate();
    gameOver();
  }

  /* Métodos - Catálogo */

  public static void interacaoSala(int locate) {

    switch (locate) {

      case 5:
        /* Sala de Jantar */
        adaga();
        break;

      case 6:
        /* Quarto Empregada */
        ped_papel();
        break;

      case 8:
        /* Almoxarifado */
        pas_secreta();
        break;

      case 15:
        /* Biblioteca */
        pergaminho();
        break;

      case 18:
        /* Escritório */
        revolver();
        break;

      case 19:
        /* Quarto dos Pais */
        jornal();
        break;

      default:
        System.out.print("Nada foi encontrado.");

    }

  }

  public static void receberDica(int syst_locate) {
    msg = "";

    switch (syst_locate) {
      case 2:
        /* Corredor direito */
        msg += "As velas no candelabro estão apagadas, porém ainda exalam uma fumaça" + l1;
        msg += "como se tivessem sido apagadas recentemente." + l1;
        System.out.print(msg);
        break;

      case 5:
        /* Sala de Jantar */
        msg += "Um pequeno objeto escondido, atrás do Móvel." + l1;
        msg += "você encontra uma pequena adaga ritualista." + l1;
        System.out.print(msg);
        break;

      case 6:
        /* Quarto Empregada */
        msg += "Um pequeno papel, escondido em um fundo falso do gaveteiro." + l1;
        System.out.print(msg);
        break;

      case 8:
        /* Almoxarifado */
        msg += "Um pequeno rastro de arrastão, partem do pé de uma estante." + l1;
        System.out.print(msg);
        break;

      case 15:
        /* Biblioteca */
        msg += "Um livro se destaca dentre todos os livros, você pega" + l1;
        msg += "e abre ele, você então encontra um pedaço de pergaminho," + l1;
        msg += "antigo." + l1;
        System.out.print(msg);
        break;

      case 18:
        /* Escritório */
        msg += "Na escrivaninha é avistado uma gaveta com tranca, após abrir" + l1;
        msg += "você encontra um revolver." + l1;
        System.out.print(msg);
        break;

      case 19:
        /* Quarto dos Pais */
        msg += "Em baixo da cama, ao lado do gaveteiro, um jornal lhe é revelado." + l1;
        System.out.print(msg);
        break;

      default:
        System.out.print("Nada foi encontrado.");
    }
  }

  /* Método - Controles */

  public static void controle2() {

    for (int key = 0; key <= 2; key++) {

      switch (key) {

        case 1:
          /* Definir com o que deseja interagir */
          interacaoSala(syst_locate);
          break;

      }
    }
  }

  public static void controle1() {

    for (int key = 0; key <= 3; key++) {

      switch (key) {

        case 1:
          /* inserir Valor para syst_locate */
          // Valor não inserido, printa "Em qual sala você está?"
          // sys_locate = addVariable();
          syst_locate = locate;

          break;

        case 2:
          /* Retornar a dica */
          receberDica(syst_locate);
          break;

        case 3:
          /* Retornar Menu */
          menuInter();
          break;
      }
    }
  }

  /* Método - Menu */

  public static void menuInter() {
    char cmd;
    msg = "";
    msg += div + l1;
    msg += "                Menu" + l1;
    msg += div + l1;
    msg += "Digite a opção desejada" + l1;
    msg += "[d] Dica" + l1;
    msg += "[i] Interagir" + l1;
    msg += "[0] Sair" + l1;
    msg += div + l1;

    System.out.print(msg);
    System.out.print("cmd: ");
    cmd = input.next().charAt(0);
    System.out.print(div + l1);

    switch (cmd) {
      case 'd':
        /* Rodar dica */
        controle1();
        break;

      case 'i':
        /* Rodar interação */
        controle2();
        break;

      case '0':
        /* Saída do Programa */
        System.exit(0);
        break;

      default:
        System.out.print("Erro 000!\nComando Inválido\nTente Novamente.");
        menuInter();
    }
  }

  /* <---- Inventário (Gustavo Martins) ----> */

  /* <----- Créditos -----> */

  public static void creditos() {
    clear();
    msg = "";
    msg += div + l1;
    msg += "                    ";
    msg += "Créditos" + l1;
    msg += div + l1;
    msg += "Grupo: XXX" + l1;
    msg += l2;
    msg += "Equipe:" + l1;
    msg += "> Enrico de Oliveira Migliorini" + l1;
    msg += "> Thais" + l1;
    msg += "> Gustavo" + l1;
    msg += "> Samuel" + l1;
    msg += "> Matheus Henrique da Costa" + l1;
    msg += div + l1;
    msg += "Sobre o Projeto:" + l1;
    msg += "Mansão Malassombrada é um jogo criado para a " + l1;
    msg += "matéria de Projeto Integrador para o Centro " + l1;
    msg += "Universitário senac, o jogo é inspirado no jogo de" + l1;
    msg += "RPG de Mesa, chamado Rastros Paranormais, do autor" + l1;
    msg += "Enrico de Oliveira Migliorini. " + l1;
    msg += div + l1;

    System.out.print(msg);

    menu();
  }

  /* <------ Gráficos -----> */

  public static void clear() {
    msg = "";
    msg += l3 + l3 + l3 + l3 + l3 + l3 + l3 + l3 + l3 + l1;
    msg += l3 + l3 + l3 + l3 + l3 + l3 + l3 + l3 + l3 + l1;
    msg += l3 + l3 + l3 + l3 + l3 + l3 + l3 + l3 + l3 + l1;
    msg += l3 + l3 + l3 + l3 + l3 + l3 + l3 + l3 + l3 + l1;
    msg += l3 + l3 + l3 + l3 + l3 + l3;
    System.out.print(msg);
  }

  /* <------ Combate ------> */
  // Game Over
  public static void gameOver() {
    Scanner cmdGameOver = new Scanner(System.in);
    if (pvMonstro < 1) {
      System.out.println("Você venceu a batalha!");
    }
    if (PvA < 1) {
      do {
        System.out.println("\n\nVocê perdeu!\nDeseja continuar? \n[1] SIM\n[2] NÃO");
        comandoChar = cmdGameOver.nextLine().charAt(0);
        switch (comandoChar) {
          case '1':
            PvA = 30;
            pvMonstro = 10;
            executarCombate();
            break;
          case '2':
            System.exit(0);
            break;
          default:
            System.out.println("Digite um comando valido!");
        }
      } while (PvA < 1);
    }
  }

  // Turnos
  public static void avancarTurno() {
    if (PvA > 0 && pvMonstro > 0) {
      danoFisicoMonstro(danoRealMonstro);
      try {
        Thread.sleep(1000);
      } catch (Exception erro) {
      }
      System.out.println("Vida do Agente: " + PvA);
      try {
        Thread.sleep(2000);
      } catch (Exception erro) {
      }
    }
  }

  // Magias
  public static int bolaDeFogo(int danoBolaDeFogo) {
    PeA -= 5;
    Random dano = new Random();
    danoBolaDeFogo = dano.nextInt(MnA + 1 - (MnA / 2)) + MnA;
    danoBolaDeFogo += MnA * 0.50;
    pvMonstro -= danoBolaDeFogo;
    if (pvMonstro < 0)
      pvMonstro = 0;
    System.out
        .println("\nVocê incendeia o monstro com uma poderosa bola de fogo e causa " + danoBolaDeFogo + " de dano");
    return danoBolaDeFogo;
  }

  public static int magiaNegra(int danoMagiaNegra) {
    int retornarDano;
    PeA -= 10;
    Random dano = new Random();
    danoMagiaNegra = dano.nextInt((MnA + 1) - 5) + MnA;
    danoMagiaNegra += MnA * 0.50;
    pvMonstro -= danoMagiaNegra;
    if (pvMonstro < 0)
      pvMonstro = 0;
    System.out
        .println("\nVocê manipulou as forças do vazio e desferiu um ataque causando " + danoMagiaNegra + " de dano");
    try {
      Thread.sleep(3000);
    } catch (Exception erro) {
    }
    retornarDano = dano.nextInt(danoMagiaNegra);
    PvA -= retornarDano;
    System.out.println("\nVocê sente sua força vital se esvaindo");
    try {
      Thread.sleep(3000);
    } catch (Exception erro) {
    }
    System.out.println("Você perde " + retornarDano + " pontos de vida");
    return danoMagiaNegra;
  }

  public static int curarAgente(int quantidadeCura) {
    Random cura = new Random();
    PeA -= 10;
    quantidadeCura = cura.nextInt((MnA + 1) - 5) + 30;
    System.out.println("Você canaliza a energia ao redor e restaura " + quantidadeCura + " pontos de vida");
    PvA += quantidadeCura;
    if (PvA > 100)
      PvA = 100;
    return quantidadeCura;
  }

  // Menu das magias
  public static void escolherMagias() {
    switch (comandoChar) {
      case '1':
        if (PeA >= 5) {
          bolaDeFogo(MnA);
          try {
            Thread.sleep(3000);
          } catch (Exception erro) {
          }
          System.out.println("Vida do monstro: " + pvMonstro);
          try {
            Thread.sleep(3000);
          } catch (Exception erro) {
          }
          avancarTurno();
        } else {
          System.out.println("\nVocê não tem energia suficiente\n");
          try {
            Thread.sleep(3000);
          } catch (Exception erro) {
          }
        }
        break;
      case '2':
        if (PeA >= 10) {
          magiaNegra(MnA);
          try {
            Thread.sleep(3000);
          } catch (Exception erro) {
          }
          System.out.println("Vida do monstro: " + pvMonstro);
          try {
            Thread.sleep(3000);
          } catch (Exception erro) {
          }
          avancarTurno();
        } else {
          System.out.println("\nVocê não tem energia suficiente\n");
          try {
            Thread.sleep(3000);
          } catch (Exception erro) {
          }
        }
        break;
      case '3':
        if (PeA >= 10) {
          curarAgente(comandoChar);
          try {
            Thread.sleep(3000);
          } catch (Exception erro) {
          }
          avancarTurno();
        } else {
          System.out.println("\nVocê não tem energia suficiente\n");
          try {
            Thread.sleep(3000);
          } catch (Exception erro) {
          }
        }
      case '4':
        executarCombate();
      default:
        System.out.println("\nDigite uma opção valida!");
        try {
          Thread.sleep(3000);
        } catch (Exception erro) {
        }
        // Magias();
    }
  }

  // Dano do Agente
  public static int danoFisico(int danoAgente) {
    Random dano = new Random();
    danoRealAgente = danoRevolver;
    danoAgente = dano.nextInt(danoRealAgente + 1 - FrA) + FrA;
    danoAgente += FrA * 0.25;
    pvMonstro -= danoAgente;
    if (pvMonstro < 0)
      pvMonstro = 0;
    System.out.println("\nVocê ataca o monstro e causa " + danoAgente + " de dano");
    return danoAgente;
  }

  // Dano do Monstro
  public static int danoFisicoMonstro(int danoMonstro) {
    Random dano = new Random();
    danoMonstro = dano.nextInt(danoRealMonstro + 1 - danoRealMonstro) + danoRealMonstro;
    PvA -= danoMonstro;
    if (PvA < 0)
      PvA = 0;
    System.out.println("\nO monstro te atacou e causou " + danoMonstro + " de dano");
    return danoMonstro;
  }

  // Executar o combate

  public static void executarCombate() {
    Scanner cmdExecutarCombate = new Scanner(System.in);
    // char comandoChar;
    do {
      String div = "----------------------------------";
      System.out.println(div + "\n");
      System.out.println("O que deseja fazer?\n");
      System.out.println("[1]Atacar\n[2]Magia\n[3]Status");
      System.out.println("\n" + div);
      System.out.print("\nAção: ");
      comandoChar = cmdExecutarCombate.next().charAt(0);

      switch (comandoChar) {
        case '1':
          danoFisico(danoRealAgente);
          try {
            Thread.sleep(1000);
          } catch (Exception erro) {
          }
          System.out.println("Vida do monstro: " + pvMonstro);
          try {
            Thread.sleep(2000);
          } catch (Exception erro) {
          }
          avancarTurno();
          break;

        case '2':
          System.out.println("\n[1]Bola de Fogo         [2]Magia Negra\n\n[3]Curar                [4]Voltar");
          System.out.print("\nAção: ");
          comandoChar = cmdExecutarCombate.next().charAt(0);
          escolherMagias();
          break;

        case '3':
          System.out.println("\n[STATUS]\n\nVida do Agente: " + PvA + "\n\nEnergia do Agente: " + PeA
              + "\n\nVida do Monstro: " + pvMonstro + "\n");
          try {
            Thread.sleep(5000);
          } catch (Exception erro) {
          }
          break;

        default:
          System.out.println("\nDigite uma opção valida!");
          try {
            Thread.sleep(1000);
          } catch (Exception erro) {
          }
      }
    } while (pvMonstro > 0 && PvA > 0);
  }
}

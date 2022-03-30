import java.util.Scanner;
public class Principal{
    public static void main(String[] args) {
        Campo[][] jogoVelha = new Campo[3][3];
        Boolean game = true;
        char simboloAtual = 'X'; 
        String vitoria = "";
        String empate = "";
        Scanner scanner = new Scanner(System.in);
        
        iniciarJogo(jogoVelha);

        while(game == true){
            desenhaJogo(jogoVelha);
            
            vitoria = verificaVitoria(jogoVelha);

            if(!vitoria.equals("")){
                System.out.printf("Jogador %s venceu %n",vitoria);
                break;
            }


            try{
                if(verificarJogada(jogoVelha, jogar(scanner, simboloAtual), simboloAtual)){
                    if(simboloAtual == 'X'){
                        simboloAtual = 'O';
                    }else{
                        simboloAtual = 'X';
                    }
                }
            }catch(Exception e){
                System.out.println("Erro: " + e);
            }

            System.out.println("Fim de Jogo ");
        }

    }

    public static void iniciarJogo(Campo[][] velha){
        for(int linha = 0; linha < 3; linha++){
            for(int coluna = 0; coluna < 3; coluna++){
                velha[linha][coluna] = new Campo();
            }
        }
    }

    public static void desenhaJogo(Campo[][] velha){
        limparTela();
        System.out.println("   0     1     2 ");
        System.out.printf("0   %c |  %c | %c %n ", velha[0][0].getSimbolo(),velha[0][1].getSimbolo(), velha[0][2].getSimbolo());
        System.out.println( "-----------------");
        System.out.printf("1   %c |  %c | %c %n ", velha[1][0].getSimbolo(),velha[1][1].getSimbolo(), velha[1][2].getSimbolo());
        System.out.println( "-----------------");
        System.out.printf("2   %c |  %c | %c %n ", velha[2][0].getSimbolo(),velha[2][1].getSimbolo(), velha[2][2].getSimbolo());
    }

    public static void limparTela(){
        for(int cont=0; cont < 200;cont++){
            System.out.println("");
        }
    }

    public static int[] jogar(Scanner scan, char simboloAtual){
        int ponto[] = new int[2];
        System.out.printf("%s %c %n","Quem Joga: ", simboloAtual);
        System.out.print("Informe a linha: ");
        ponto[0] = scan.nextInt();
        System.out.print("Informe a coluna: ");
        ponto[1] = scan.nextInt();

        return ponto;

    }

    public static boolean verificarJogada(Campo[][] velha, int p[],char simboloAtual){
        if(velha[p[0]][p[1]].getSimbolo()==' '){
            velha[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        }else{
            return false;
        }
    }

    public static String verificaVitoria(Campo[][] velha){

        if( (velha[0][0].getSimbolo() == 'X') && (velha[1][0].getSimbolo() == 'X') && (velha[2][0].getSimbolo() == 'X') 
            || (velha[0][1].getSimbolo() == 'X') && (velha[1][1].getSimbolo() == 'X') && (velha[2][1].getSimbolo() == 'X')
            || (velha[0][2].getSimbolo() == 'X') && (velha[1][2].getSimbolo() == 'X') && (velha[2][2].getSimbolo() == 'X')
            || (velha[0][0].getSimbolo() == 'X') && (velha[0][1].getSimbolo() == 'X') && (velha[0][2].getSimbolo() == 'X')
            || (velha[1][0].getSimbolo() == 'X') && (velha[1][1].getSimbolo() == 'X') && (velha[1][2].getSimbolo() == 'X')
            || (velha[2][0].getSimbolo() == 'X') && (velha[2][1].getSimbolo() == 'X') && (velha[2][2].getSimbolo() == 'X')
            || (velha[0][2].getSimbolo() == 'X') && (velha[1][1].getSimbolo() == 'X') && (velha[2][0].getSimbolo() == 'X')
            || (velha[0][0].getSimbolo() == 'X') && (velha[1][1].getSimbolo() == 'X') && (velha[2][2].getSimbolo() == 'X'))
            {

            return "X";

            }else if( (velha[0][0].getSimbolo() == 'O') && (velha[1][0].getSimbolo() == 'O') && (velha[2][0].getSimbolo() == 'O') 
            || (velha[0][1].getSimbolo() == 'O') && (velha[1][1].getSimbolo() == 'O') && (velha[2][1].getSimbolo() == 'O')
            || (velha[0][2].getSimbolo() == 'O') && (velha[1][2].getSimbolo() == 'O') && (velha[2][2].getSimbolo() == 'O')
            || (velha[0][0].getSimbolo() == 'O') && (velha[0][1].getSimbolo() == 'O') && (velha[0][2].getSimbolo() == 'O')
            || (velha[1][0].getSimbolo() == 'O') && (velha[1][1].getSimbolo() == 'O') && (velha[1][2].getSimbolo() == 'O')
            || (velha[2][0].getSimbolo() == 'O') && (velha[2][1].getSimbolo() == 'O') && (velha[2][2].getSimbolo() == 'O')
            || (velha[0][2].getSimbolo() == 'O') && (velha[1][1].getSimbolo() == 'O') && (velha[2][0].getSimbolo() == 'O')
            || (velha[0][0].getSimbolo() == 'O') && (velha[1][1].getSimbolo() == 'O') && (velha[2][2].getSimbolo() == 'O') )
            {
                
                return "O";
            }

            return "";
        
    }

}
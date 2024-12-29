import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o seu CPF: ");
        String entradaCPF = leitura.nextLine();
        String cpfMascara;

        // ELIMINANDO OS PONTOS E O HÍFEN DA STRING
        cpfMascara = entradaCPF.replaceAll("\\D","");
       //System.out.println(cpfMascara);

        if(cpfMascara.length() == 11){
            int digitoVrf1 = Integer.parseInt(String.valueOf(cpfMascara.charAt(9))),digitoVrf2 =Integer.parseInt(String.valueOf(cpfMascara.charAt(10))) ;
            int[] multp1 = {10,9,8,7,6,5,4,3,2};
            int[] multp2 = {11,10,9,8,7,6,5,4,3,2};
            int soma1 = 0,soma2 = 0,resto1, resto2;

            //PRIMEIRO DIGITO VERIFICADOR
            for(int i = 0; i<9; i++){
                soma1+= Integer.parseInt(String.valueOf(cpfMascara.charAt(i))) * multp1[i];
            }
            resto1 = soma1 % 11;
            if(resto1<2){
                resto1 = 0;
            }else{
                resto1 = 11 - resto1;
            }

            //SEGUNDO DIGITO VERIFICADOR
            for(int a = 0; a<10; a++){
                soma2 += Integer.parseInt(String.valueOf(cpfMascara.charAt(a))) * multp2[a];
            }
            resto2 = soma2 % 11;
            if(resto2 <2 ){
                resto2 = 0;
            }else {
                resto2 = 11- resto2;
            }

            //VERIFICADOR DE AUTENTICIDADE
            boolean vrf1;
            vrf1 = resto1 == digitoVrf1 || resto2 == digitoVrf2;
            System.out.println(vrf1);

        }
            }
        }

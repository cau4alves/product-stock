package productStock;

import java.util.*;

public class productStock {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Csv estoque = new Csv();
        Estoque obj1 = new Estoque();
        Estoque obj2 = new Estoque();
        Estoque obj3 = new Estoque();
        Estoque obj4 = new Estoque();
        Estoque obj5 = new Estoque();
        Estoque obj6 = new Estoque();
        Estoque obj7 = new Estoque();
        Estoque obj8 = new Estoque();
        Estoque obj9 = new Estoque();
        Estoque obj10 = new Estoque();
        int qtd = 0;
        int codigo = 0;

        obj1.adiciona(estoque.pegarValor());
        obj2.adiciona(estoque.pegarValor());
        obj3.adiciona(estoque.pegarValor());
        obj4.adiciona(estoque.pegarValor());
        obj5.adiciona(estoque.pegarValor());
        obj6.adiciona(estoque.pegarValor());
        obj7.adiciona(estoque.pegarValor());
        obj8.adiciona(estoque.pegarValor());
        obj9.adiciona(estoque.pegarValor());
        obj10.adiciona(estoque.pegarValor());


        // obj1.atualiza(10, 1);
        // obj2.atualiza(10, 2);
        // obj3.atualiza(10, 3);
        // obj4.atualiza(10, 4);
        // obj5.atualiza(10, 5);
        // obj6.atualiza(10, 6);
        // obj7.atualiza(10, 7);
        // obj8.atualiza(10, 8);
        // obj9.atualiza(10, 9);
        // obj10.atualiza(10, 10);

        estoque.escreve();

        try {
            System.out.println("\nDigite o código do produto (0 para sair do programa): ");
            codigo = scan.nextInt();
            System.out.println("Digite a quantidade: ");
            qtd = scan.nextInt();
        } catch (Exception e)  {
            System.out.println("Valor inválido");
        }

        switch(codigo) {
            case 1:
                obj1.excluir(qtd);
                break;
            case 2:
                obj2.excluir(qtd);
                break;
            case 3:
                obj3.excluir(qtd);
                break;
            case 4:
                obj4.excluir(qtd);
                break;
            case 5:
                obj5.excluir(qtd);
                break;
            case 6:
                obj6.excluir(qtd);
                break;
            case 7:
                obj7.excluir(qtd);
                break;
            case 8:
                obj8.excluir(qtd);
                break;
            case 9:
                obj9.excluir(qtd);
                break;
            case 10:
                obj10.excluir(qtd);
                break;
        }



        obj1.atualiza(obj1.quantidade, 1);
        obj2.atualiza(obj2.quantidade, 2);
        obj3.atualiza(obj3.quantidade, 3);
        obj4.atualiza(obj4.quantidade, 4);
        obj5.atualiza(obj5.quantidade, 5);
        obj6.atualiza(obj6.quantidade, 6);
        obj7.atualiza(obj7.quantidade, 7);
        obj8.atualiza(obj8.quantidade, 8);
        obj9.atualiza(obj9.quantidade, 9);
        obj10.atualiza(obj10.quantidade, 10);

        estoque.escreve();

        scan.close();
    }
}
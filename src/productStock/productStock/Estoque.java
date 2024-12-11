package productStock;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    int quantidade;

    public void adiciona(int qtd) {
        this.quantidade = qtd;
    }

    public void excluir(int qtd) {
        if(qtd <= this.quantidade) {
            this.quantidade -= qtd;
        } else {
            System.out.println("Quantidade insuficiente");
        }
    }

    public void atualiza(int qtd, int linha) {
        String csvFile = "C:\\Users\\Carla\\Downloads\\produtos.csv"; // Caminho para o seu arquivo CSV
        List<String> lines = new ArrayList<>();
        int lineToUpdate = qtd; // O número que você deseja inserir
        int rowToUpdate = linha; // A linha que você deseja atualizar (0-indexed)

        // Lê o arquivo CSV
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Atualiza o valor na linha desejada
        if (rowToUpdate < lines.size()) {
            String[] columns = lines.get(rowToUpdate).split(",");
            columns[3] = Integer.toString(lineToUpdate); // Atualiza a primeira coluna com o novo valor
            lines.set(rowToUpdate, String.join(",", columns));
        } else {
            System.out.println("Linha especificada não existe.");
        }

        // Escreve as alterações de volta no arquivo CSV
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
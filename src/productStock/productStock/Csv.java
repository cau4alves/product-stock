package productStock;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Csv {
    public void escreve() {
        String filePath = "C:\\Users\\Carla\\Downloads\\produtos.csv"; // Substitua pelo caminho do seu arquivo
        ArrayList<String[]> data = new ArrayList<>();

        // Verifica se o caminho do arquivo é válido
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Ajuste o delimitador conforme necessário
                data.add(values);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        // Exibindo os dados lidos
        if (data.isEmpty()) {
            System.out.println("Nenhum dado foi lido do arquivo.");
        } else {
            for (String[] row : data) {
                for (String value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
    }

    public int pegarValor() {
        String linha;
        String filePath = "C:\\Users\\Carla\\Downloads\\produtos.csv";
        int qtd = 0;
        int contador = 0; // Para contar a linha (ajudar a ignorar o cabeçalho)

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((linha = br.readLine()) != null) {
                // Ignorar o cabeçalho (primeira linha)
                if (contador == 0) {
                    contador++;
                    continue; // Pula a primeira linha
                }

                // Divide a linha em campos usando a vírgula como separador
                String[] campos = linha.split(",");

                // Verifica se há pelo menos 4 colunas
                if (campos.length > 3) {
                    try {
                        // Remove as aspas e converte para inteiro
                        qtd = Integer.parseInt(campos[3].replace("\"", "").trim());
                    } catch (NumberFormatException e) {
                        System.err.println("Valor inválido na linha " + (contador + 1) + ": " + campos[3]);
                    }
                } else {
                    System.err.println("Linha " + (contador + 1) + " não contém colunas suficientes.");
                }

                contador++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return qtd;
    }
}